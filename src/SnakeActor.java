import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.Timer;
import org.lwjgl.Sys;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by s581467 on 11/7/2017.
 */
public class SnakeActor extends Actor implements Mover{
    private Timer toMove;
    protected LinkedList<SnakeBody> snakeBodies;
    private int[] keys;
    private boolean multi;
    private int Player;
    private boolean canMove;
    private long testingTime;

    private String mode;
    private Properties properties;

    public SnakeActor(Properties p)
    {
        properties = p;
        mode = properties.getMode();

        canMove =false;
        multi = false;

        /*
        keys = new int[8];
        keys[0] = Keyboard.KEY_W;
        keys[1] = Keyboard.KEY_S;
        keys[2] = Keyboard.KEY_A;
        keys[3] = Keyboard.KEY_D;
        keys[4] = Keyboard.KEY_UP;
        keys[5] = Keyboard.KEY_DOWN;
        keys[6] = Keyboard.KEY_LEFT;
        keys[7] = Keyboard.KEY_RIGHT;
        */
        keyMode(1);

        setImage("img/snake.png");
        toMove = new Timer(75);
        size = 0;
        snakeBodies = new LinkedList<>();
        Player = 1;
        dir=0;

    }
    public SnakeActor(Properties p,int player)
    {
        //The snakes can't move at the start
        canMove = false;

        //Gets the mode of play
        properties = p;
        mode = properties.getMode();

        //Gets the number of players, and thus the multiplayer boolean
        int Player = player;
        multi = Integer.parseInt(properties.getPlayers()) > 1;

        //Gets the mode
        mode = properties.getMode();

        /*
        keys = new int[8];
        if(player==1)
        {
            keys[0] = Keyboard.KEY_W;
            keys[1] = Keyboard.KEY_S;
            keys[2] = Keyboard.KEY_A;
            keys[3] = Keyboard.KEY_D;
            keys[4] = Keyboard.KEY_W;
            keys[5] = Keyboard.KEY_S;
            keys[6] = Keyboard.KEY_A;
            keys[7] = Keyboard.KEY_D;
            Player = 1;
        }
        if(player==2)
        {
            keys[0] = Keyboard.KEY_UP;
            keys[1] = Keyboard.KEY_DOWN;
            keys[2] = Keyboard.KEY_LEFT;
            keys[3] = Keyboard.KEY_RIGHT;
            keys[4] = Keyboard.KEY_UP;
            keys[5] = Keyboard.KEY_DOWN;
            keys[6] = Keyboard.KEY_LEFT;
            keys[7] = Keyboard.KEY_RIGHT;
            Player = 2;
        }
        if(player==3)
        {
            keys[0] = Keyboard.KEY_I;
            keys[1] = Keyboard.KEY_K;
            keys[2] = Keyboard.KEY_J;
            keys[3] = Keyboard.KEY_L;
            keys[4] = Keyboard.KEY_I;
            keys[5] = Keyboard.KEY_K;
            keys[6] = Keyboard.KEY_J;
            keys[7] = Keyboard.KEY_L;
            Player = 3;
        }
        if(player==4)
        {
            keys[0] = Keyboard.KEY_T;
            keys[1] = Keyboard.KEY_G;
            keys[2] = Keyboard.KEY_F;
            keys[3] = Keyboard.KEY_H;
            keys[4] = Keyboard.KEY_T;
            keys[5] = Keyboard.KEY_G;
            keys[6] = Keyboard.KEY_F;
            keys[7] = Keyboard.KEY_H;
            Player = 4;
        }
        */
        keyMode(player);

        setImage("img/snake.png");
        toMove = new Timer(75);
        size = 0;
        snakeBodies = new LinkedList<>();
        dir=0;
    }
    private int score;
    private String name;
    private int dir; // 8 is up, 2 is down , 4 is left, 6 is right
    public int size;

    public boolean ready()
    {
        if(dir==0)
            return false;
        return true;
    }

    public void act()
    {
        int countResets = 0;
        if(!ready())
        {
            setImage("img/wall.png");
        }
        else
            setImage("img/snake.png");

        /*
            if(toMove.isDone())
            {
                System.out.println(System.currentTimeMillis() - testingTime);
                testingTime = System.currentTimeMillis();
            }
        */
            if(!multi)
                if(checkDead())
                    dead();
            SnakeBody snakeBody = new SnakeBody(size);
            //movement and directions

            /*
            if ((Mayflower.isKeyPressed(keys[0]) || Mayflower.isKeyPressed(keys[4])) && !(dir == 2))
            {
                dir = 8;
            }
            else if ((Mayflower.isKeyPressed(keys[1]) || Mayflower.isKeyPressed(keys[5])) && !(dir == 8))
            {
                dir = 2;
            }
            else if ((Mayflower.isKeyPressed(keys[2]) || Mayflower.isKeyPressed(keys[6])) && !(dir == 6))
            {
                dir = 4;
            }
            else if ((Mayflower.isKeyPressed(keys[3]) || Mayflower.isKeyPressed(keys[7])) && !(dir == 4))
            {
                dir = 6;
            }
            */
            moveMode();

            if(canMove)
            {
                if (dir == 8 && toMove.isDone())
                {
                    setLocation(getX(), getY() - 20);
                    add(snakeBody, getX(), getY() + 20);
                    snakeBodies.addLast(snakeBody);
                    mode();
                    toMove.set((int) (System.currentTimeMillis() - testingTime) + 75);
                    testingTime = testingTime + 75;
                }
                else if (dir == 2 && toMove.isDone())
                {
                    setLocation(getX(), getY() + 20);
                    add(snakeBody, getX(), getY() - 20);
                    snakeBodies.addLast(snakeBody);
                    mode();
                    toMove.set((int) (System.currentTimeMillis() - testingTime) + 75);
                    testingTime = testingTime + 75;
                }
                else if (dir == 4 && toMove.isDone())
                {
                    setLocation(getX() - 20, getY());
                    add(snakeBody, getX() + 20, getY());
                    snakeBodies.addLast(snakeBody);
                    mode();
                    toMove.set((int) (System.currentTimeMillis() - testingTime) + 75);
                    testingTime = testingTime + 75;
                }
                else if (dir == 6 && toMove.isDone())
                {
                    setLocation(getX() + 20, getY());
                    add(snakeBody, getX() - 20, getY());
                    snakeBodies.addLast(snakeBody);
                    mode();
                    toMove.set((int) (System.currentTimeMillis() - testingTime) + 75);
                    testingTime = testingTime + 75;
                }
            }
    }

    public void mode()
    {
        if(mode.equals("B") || mode.equals("T"))
        {
            if (this.isTouching(PointActor.class))
            {
                this.removeTouching(PointActor.class);
           //     PointActor pointActor = new PointActor();
            //    getWorld().addObject(pointActor, pointActor.getRow() * 20, pointActor.getCol() * 20);
                size++;
                score++;
                add();
            }
            remove();
        }

        if(mode.equals("A"))
        {

        }

    }

    /*
        TODO:
        Implement moveMode into the program
    */

    public void keyMode(int player)
    {
        //Sets the controls for BC mode and AG mode - singleplayer
        if((mode.equals("B") || mode.equals("A")) && !multi)
        {
            keys = new int[8];
            keys[0] = Keyboard.KEY_W;
            keys[1] = Keyboard.KEY_S;
            keys[2] = Keyboard.KEY_A;
            keys[3] = Keyboard.KEY_D;
            keys[4] = Keyboard.KEY_UP;
            keys[5] = Keyboard.KEY_DOWN;
            keys[6] = Keyboard.KEY_LEFT;
            keys[7] = Keyboard.KEY_RIGHT;
            Player = 1;
        }

        //Sets the controls for BC mode and AG mode - multiplayer
        if((mode.equals("B") || mode.equals("A")) && multi)
        {
            if(player==1)
            {
                keys = new int[4];
                keys[0] = Keyboard.KEY_W;
                keys[1] = Keyboard.KEY_S;
                keys[2] = Keyboard.KEY_A;
                keys[3] = Keyboard.KEY_D;
                Player = 1;
            }
            if(player==2)
            {
                keys = new int[4];
                keys[0] = Keyboard.KEY_UP;
                keys[1] = Keyboard.KEY_DOWN;
                keys[2] = Keyboard.KEY_LEFT;
                keys[3] = Keyboard.KEY_RIGHT;
                Player = 2;
            }
            if(player==3)
            {
                keys = new int[4];
                keys[0] = Keyboard.KEY_I;
                keys[1] = Keyboard.KEY_K;
                keys[2] = Keyboard.KEY_J;
                keys[3] = Keyboard.KEY_L;
                Player = 3;
            }
            if(player==4)
            {
                keys = new int[4];
                keys[0] = Keyboard.KEY_T;
                keys[1] = Keyboard.KEY_G;
                keys[2] = Keyboard.KEY_F;
                keys[3] = Keyboard.KEY_H;
                Player = 4;
            }
        }

        //Sets the controls for Twitch Play mode
        if(mode.equals("T"))
        {
            keys = new int[16];
            keys[0] = Keyboard.KEY_W;
            keys[1] = Keyboard.KEY_S;
            keys[2] = Keyboard.KEY_A;
            keys[3] = Keyboard.KEY_D;
            keys[4] = Keyboard.KEY_UP;
            keys[5] = Keyboard.KEY_DOWN;
            keys[6] = Keyboard.KEY_LEFT;
            keys[7] = Keyboard.KEY_RIGHT;
            keys[8] = Keyboard.KEY_I;
            keys[9] = Keyboard.KEY_K;
            keys[10] = Keyboard.KEY_J;
            keys[11] = Keyboard.KEY_L;
            keys[12] = Keyboard.KEY_T;
            keys[13] = Keyboard.KEY_G;
            keys[14] = Keyboard.KEY_F;
            keys[15] = Keyboard.KEY_H;
            Player = 1;
        }


    }

    /*
        TODO:
        Implement move into the program
    */

    public void moveMode()
    {
        //Sets the movement of BC and AG modes - singleplayer
        if((mode.equals("B") || mode.equals("A")) && !multi)
        {
            if ((Mayflower.isKeyPressed(keys[0])) && !(dir == 2))
            {
                dir = 8;
            }
            else if ((Mayflower.isKeyPressed(keys[1])) && !(dir == 8))
            {
                dir = 2;
            }
            else if ((Mayflower.isKeyPressed(keys[2])) && !(dir == 6))
            {
                dir = 4;
            }
            else if ((Mayflower.isKeyPressed(keys[3])) && !(dir == 4))
            {
                dir = 6;
            }
        }

        //Sets the controls for BC and AG modes - multiplayer
        if((mode.equals("B") || mode.equals("A")) && multi)
        {
            if ((Mayflower.isKeyPressed(keys[0]) || Mayflower.isKeyPressed(keys[4])) && !(dir == 2))
            {
                dir = 8;
            }
            else if ((Mayflower.isKeyPressed(keys[1]) || Mayflower.isKeyPressed(keys[5])) && !(dir == 8))
            {
                dir = 2;
            }
            else if ((Mayflower.isKeyPressed(keys[2]) || Mayflower.isKeyPressed(keys[6])) && !(dir == 6))
            {
                dir = 4;
            }
            else if ((Mayflower.isKeyPressed(keys[3]) || Mayflower.isKeyPressed(keys[7])) && !(dir == 4))
            {
                dir = 6;
            }
        }

        //Sets the movement of Twitch Play mode
        if(mode.equals("T"))
        {
            //If there is one player...
            if( Integer.parseInt( properties.getPlayers() ) == 1 )
            {
                if ((Mayflower.isKeyDown(keys[0])) && !(dir == 2))
                {
                    dir = 8;
                }
                else if ((Mayflower.isKeyDown(keys[1])) && !(dir == 8))
                {
                    dir = 2;
                }
                else if ((Mayflower.isKeyDown(keys[2])) && !(dir == 6))
                {
                    dir = 4;
                }
                else if ((Mayflower.isKeyDown(keys[3])) && !(dir == 4))
                {
                    dir = 6;
                }

            }

            //If there are two players...
            if( Integer.parseInt( properties.getPlayers() ) == 2 )
            {
                if ((Mayflower.isKeyDown(keys[0]) &&
                        Mayflower.isKeyDown(keys[4])) && !(dir == 2))
                {
                    dir = 8;
                }
                else if ((Mayflower.isKeyDown(keys[1]) &&
                        Mayflower.isKeyDown(keys[5])) && !(dir == 8))
                {
                    dir = 2;
                }
                else if ((Mayflower.isKeyDown(keys[2]) &&
                        Mayflower.isKeyDown(keys[6])) && !(dir == 6))
                {
                    dir = 4;
                }
                else if ((Mayflower.isKeyDown(keys[3]) &&
                        Mayflower.isKeyDown(keys[7])) && !(dir == 4))
                {
                    dir = 6;
                }

            }

            //If there are three players...
            if( Integer.parseInt( properties.getPlayers() ) == 3 )
            {
                if ((Mayflower.isKeyDown(keys[0]) &&
                        Mayflower.isKeyDown(keys[4]) &&
                        Mayflower.isKeyDown(keys[8])) && !(dir == 2))
                {
                    dir = 8;
                }
                else if ((Mayflower.isKeyDown(keys[1]) &&
                        Mayflower.isKeyDown(keys[5]) &&
                        Mayflower.isKeyDown(keys[9])) && !(dir == 8))
                {
                    dir = 2;
                }
                else if ((Mayflower.isKeyDown(keys[2]) &&
                        Mayflower.isKeyDown(keys[6]) &&
                        Mayflower.isKeyDown(keys[10])) && !(dir == 6))
                {
                    dir = 4;
                }
                else if ((Mayflower.isKeyDown(keys[3]) &&
                        Mayflower.isKeyDown(keys[7]) &&
                        Mayflower.isKeyDown(keys[11])) && !(dir == 4))
                {
                    dir = 6;
                }

            }

            //If there are four players...
            if( Integer.parseInt( properties.getPlayers() ) == 4 )
            {
                if ((Mayflower.isKeyDown(keys[0]) &&
                        Mayflower.isKeyDown(keys[4]) &&
                        Mayflower.isKeyDown(keys[8]) &&
                        Mayflower.isKeyDown(keys[12])) && !(dir == 2))
                {
                    dir = 8;
                }
                else if ((Mayflower.isKeyDown(keys[1]) &&
                        Mayflower.isKeyDown(keys[5]) &&
                        Mayflower.isKeyDown(keys[9]) &&
                        Mayflower.isKeyDown(keys[13])) && !(dir == 8))
                {
                    dir = 2;
                }
                else if ((Mayflower.isKeyDown(keys[2]) &&
                        Mayflower.isKeyDown(keys[6]) &&
                        Mayflower.isKeyDown(keys[10]) &&
                        Mayflower.isKeyDown(keys[14])) && !(dir == 6))
                {
                    dir = 4;
                }
                else if ((Mayflower.isKeyDown(keys[3]) &&
                        Mayflower.isKeyDown(keys[7]) &&
                        Mayflower.isKeyDown(keys[11]) &&
                        Mayflower.isKeyDown(keys[15])) && !(dir == 4))
                {
                    dir = 6;
                }

            }
        }

    }

    public boolean checkDead()
    {
        return this.isTouching(SnakeActor.class)|| this.isTouching(SnakeBody.class) || this.isTouching(WallActor.class);
    }

    public void portal()
    {
        SnakeBody snakeBody = new SnakeBody(size);
        if (dir == 8) {
            setLocation(getX(), getY() - 20);
            add(snakeBody, getX(), getY() + 20);
            //snakeBodies.addLast(snakeBody);
        } else if (dir == 2) {
            setLocation(getX(), getY() + 20);
            add(snakeBody, getX(), getY() - 20);
            //snakeBodies.addLast(snakeBody);
        } else if (dir == 4) {
            setLocation(getX() - 20, getY());
            add(snakeBody, getX() + 20, getY());
            //snakeBodies.addLast(snakeBody);

        } else if (dir == 6) {
            setLocation(getX() + 20, getY());
            add(snakeBody, getX() - 20, getY());
            //snakeBodies.addLast(snakeBody);
        }
    }

    public void setCanMove(boolean canMove)
    {
        this.canMove = canMove;
        testingTime = System.currentTimeMillis();
    }

    public boolean add(Actor actor, int x, int y)
    {
        getWorld().addObject(actor,x,y);
        return true;
    }

    public String getName()
    {
        return name = Mayflower.ask("Enter Your Name");
    }

    public void remove()
    {
        for(int x = 0; x < snakeBodies.size(); x++)
        {
            if (snakeBodies.get(x).getLife() <= 0)
            {
                getWorld().removeObject(snakeBodies.get(x));
                snakeBodies.remove(x);
            }
            else
            {
                snakeBodies.get(x).setLife(snakeBodies.get(x).getLife()-1);
            }
        }

    }

    public void add()
    {
        for(int x = 0; x < snakeBodies.size(); x++)
        {
            snakeBodies.get(x).setLife(snakeBodies.get(x).getLife()+1);
        }
    }

    public int getPoints()
    {
        return score;
    }

    public void removeBody()
    {
        for(int i = 0;i<snakeBodies.size();i++)
        {
            this.getWorld().removeObject(snakeBodies.get(i));
        }
    }

    public int getPlayer()
    {
        return Player;
    }

    public void dead()
    {

            int score = getPoints();
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("score.txt", true), "utf-8")))
            {
                System.out.println("The final score is " + score);
                writer.write( getName() + "-" + score);
                writer.write("\r\n");

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            if(multi)
            {
                this.removeTouching(SnakeActor.class);
                GameOver over = new GameOver(true,Player,properties);
                Mayflower.setWorld(over);
            }
            else
            {
                this.removeTouching(SnakeActor.class);
                GameOver over = new GameOver(properties);
                Mayflower.setWorld(over);
            }




    }

    public boolean isIntersecting()
    {
        if(this.isTouching(SnakeActor.class))
            return true;
        return false;
    }

    public List<Mover> isTouchingSA()
    {
        List ret = new ArrayList();
        for(int i = 0; i<this.getIntersectingObjects(Actor.class).size();i++)
            if(this.getIntersectingObjects(Actor.class).getClass().equals(SnakeActor.class)||this.getIntersectingObjects(Actor.class).getClass().equals(MouseActor.class))
                ret.add(this.getIntersectingObjects(Actor.class).get(i));
        return ret;
    }

    public boolean couldMove(int i)
    {
        return true;
    }
}
