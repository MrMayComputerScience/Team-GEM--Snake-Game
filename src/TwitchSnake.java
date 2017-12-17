import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.Timer;

import java.util.LinkedList;

public class TwitchSnake extends SnakeActor
{
    private Timer toMove;
    //private LinkedList<SnakeBody> snakeBodies;
    private int[][] keys;
    private boolean multi;
    private int Player;
    private boolean canMove;
    private long testingTime;

    private String mode;
    private Properties properties;

    public TwitchSnake(Properties p)
    {
        super(p);

        Player = Integer.parseInt(p.getPlayers());
        canMove = false;
        multi = true;

        //The snakes can't move at the start
        canMove = false;

        //Gets the mode of play
        properties = p;
        mode = properties.getMode();

        //Gets the number of players, and thus the multiplayer boolean
        multi = Integer.parseInt(properties.getPlayers()) > 1;

        //Gets the mode
        mode = properties.getMode();
        keys = new int[4][5];
        if(Player>=1)
        {
            keys[0][0] = Keyboard.KEY_W;
            keys[0][1] = Keyboard.KEY_S;
            keys[0][2] = Keyboard.KEY_A;
            keys[0][3] = Keyboard.KEY_D;


        }
        if(Player>=2)
        {
            keys[1][0] = Keyboard.KEY_UP;
            keys[1][1] = Keyboard.KEY_DOWN;
            keys[1][2] = Keyboard.KEY_LEFT;
            keys[1][3] = Keyboard.KEY_RIGHT;


        }
        if(Player>=3)
        {
            keys[2][0] = Keyboard.KEY_I;
            keys[2][1] = Keyboard.KEY_K;
            keys[2][2] = Keyboard.KEY_J;
            keys[2][3] = Keyboard.KEY_L;


        }
        if(Player>=4)
        {
            keys[3][0] = Keyboard.KEY_T;
            keys[3][1] = Keyboard.KEY_G;
            keys[3][2] = Keyboard.KEY_F;
            keys[3][3] = Keyboard.KEY_H;

        }

        setImage("img/snake.png");
        toMove = new Timer(75);
        size = 0;
        //snakeBodies = new LinkedList<>();
        dir=0;

    }
    private int score;
    private String name;
    private int dir; // 8 is up, 2 is down , 4 is left, 6 is right
    public int size;

    public void act()
    {
        update();
        setImage("img/snake.png");
        //if(toMove.isDone())
        //{
        //System.out.println(System.currentTimeMillis() - testingTime);
        //testingTime = System.currentTimeMillis();
        //}
        SnakeBody snakeBody = new SnakeBody(size);

        //movement and directions
        if ((couldMove(0)) && !(dir == 2))
        {
            dir = 8;
        }
        else if (couldMove(1) && !(dir == 8))
        {
            dir = 2;
        }
        else if (couldMove(2) && !(dir == 6))
        {
            dir = 4;
        }
        else if ((couldMove(3)) && !(dir == 4))
        {
            dir = 6;
        }

        if (canMove)
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

            if (this.isTouching(PointActor.class))
            {
                this.removeTouching(PointActor.class);

                size++;
                score++;
                add();
            }
        }
    }

    public void mode()
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

    public boolean couldMove(int direction)
    {
        for(int i = 0; i<Player; i++)
        {
            if(keys[i][4] != keys[i][direction])
                return false;
        }
      //  Mayflower.
        return true;
    }

    public void update()
    {
        for(int i = 0; i < Player; i++)
        {
            for(int x = 0; x < 4; x++)
            {
                if(Mayflower.isKeyPressed(keys[i][x]))
                {
                    keys[i][4] = keys[i][x];
                    break;
                }
            }
        }
    }

    public void setCanMove(boolean canMove)
    {
        this.canMove = canMove;
        testingTime = System.currentTimeMillis();
    }

}
