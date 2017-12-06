import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.Timer;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/**
 * Created by s581467 on 11/7/2017.
 */
public class SnakeActor extends Actor implements Mover
{
    private Timer toMove;
    private LinkedList<SnakeBody> snakeBodies;
    private int[] keys;
    private boolean multi;
    private int Player;
    private boolean canMove;
    public SnakeActor()
    {
        canMove =true;
        multi = false;
        keys = new int[8];
        keys[0] = Keyboard.KEY_W;
        keys[1] = Keyboard.KEY_S;
        keys[2] = Keyboard.KEY_A;
        keys[3] = Keyboard.KEY_D;
        keys[4] = Keyboard.KEY_UP;
        keys[5] = Keyboard.KEY_DOWN;
        keys[6] = Keyboard.KEY_LEFT;
        keys[7] = Keyboard.KEY_RIGHT;
        if(TitleWorld.skin == null)
        {
            setImage("img/snake.png");
        }
        else setImage(TitleWorld.img);

        toMove = new Timer(75);
        size = 0;
        snakeBodies = new LinkedList<>();
        Player = 1;
        dir=0;
    }
    public SnakeActor(int player)
    {canMove = false;
        multi = true;
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
            if(!multi)
                if(checkDead())
                dead();
            SnakeBody snakeBody = new SnakeBody(size);
            //movement and directions
        if(canMove) {
            if ((Mayflower.isKeyPressed(keys[0]) || Mayflower.isKeyPressed(keys[4])) && !(dir == 2)) {
                dir = 8;
            } else if ((Mayflower.isKeyPressed(keys[1]) || Mayflower.isKeyPressed(keys[5])) && !(dir == 8)) {
                dir = 2;
            } else if ((Mayflower.isKeyPressed(keys[2]) || Mayflower.isKeyPressed(keys[6])) && !(dir == 6)) {
                dir = 4;
            } else if ((Mayflower.isKeyPressed(keys[3]) || Mayflower.isKeyPressed(keys[7])) && !(dir == 4)) {
                dir = 6;
            }
        }
            if (dir == 8 && toMove.isDone()) {
                setLocation(getX(), getY() - 20);
                add(snakeBody, getX(), getY() + 20);
                snakeBodies.addLast(snakeBody);
                remove();
                toMove.reset();
            } else if (dir == 2 && toMove.isDone()) {

                setLocation(getX(), getY() + 20);
                add(snakeBody, getX(), getY() - 20);
                snakeBodies.addLast(snakeBody);
                remove();
                toMove.reset();
            } else if (dir == 4 && toMove.isDone()) {

                setLocation(getX() - 20, getY());
                add(snakeBody, getX() + 20, getY());
                snakeBodies.addLast(snakeBody);
                remove();
                toMove.reset();
            } else if (dir == 6 && toMove.isDone()) {

                setLocation(getX() + 20, getY());
                add(snakeBody, getX() - 20, getY());
                snakeBodies.addLast(snakeBody);
                remove();
                toMove.reset();
            }

            if (this.isTouching(PointActor.class)) {
                this.removeTouching(PointActor.class);
                PointActor pointActor = new PointActor();
                getWorld().addObject(pointActor, pointActor.getRow() * 20, pointActor.getCol() * 20);
                size++;
                score++;
                add();
            }

    }
    public boolean checkDead()
    {
        if(this.isTouching(SnakeActor.class)&& SnakeActor.class.equals(MouseActor.class))
            return false;
        else return this.isTouching(SnakeActor.class)|| this.isTouching(SnakeBody.class) || this.isTouching(WallActor.class);
    }

    public void setCanMove(boolean canMove)
    {
        this.canMove = canMove;
    }

    public boolean add(Actor actor, int x, int y)
    {
        getWorld().addObject(actor,x,y);
        return true;
    }
    public String getName(){return name = Mayflower.ask("Enter Your Name");}
    public void remove()
    {
        for(int x = 0;x<snakeBodies.size();x++)
        {
            if (snakeBodies.get(x).getLife() <=0) {
                getWorld().removeObject(snakeBodies.get(x));
                snakeBodies.remove(x);
            }
            else
                snakeBodies.get(x).setLife(snakeBodies.get(x).getLife()-1);
        }

    }
    public void add()
    {
        for(int x = 0;x<snakeBodies.size();x++)
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
                    GameOver over = new GameOver(true,Player);
                    Mayflower.setWorld(over);
                }
                else
                {
                    //this.removeTouching(SnakeActor.class);
                    GameOver over = new GameOver();
                    Mayflower.setWorld(over);
                }




        }
}
