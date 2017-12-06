import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.Timer;

import java.util.LinkedList;

/**
 * Created by s581467 on 11/7/2017.
 */
public class MouseActor extends Actor implements Mover
{
    private Timer toMove;
    private LinkedList<SnakeBody> snakeBodies;
    private int[] keys;
    private boolean multi;
    private int Player;
    private boolean canMove;


    /*public MouseActor()
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
    }*/


    public MouseActor(int player)
    {
        canMove = true;
        multi = true;
        keys = new int[8];
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
        setImage("img/mouse.png");
        toMove = new Timer(75);
        snakeBodies = new LinkedList<>();
    }

    public boolean ready()
    {
        return false;
    }

    public void act()
        {
            if(!multi)
            if(checkDead())
                dead();
                //movement and directions
            if(canMove)
            {
                if (((Mayflower.isKeyDown(keys[0]) || Mayflower.isKeyPressed(keys[4]))))
                {
                    setLocation(getX(), getY() - 20);
                    toMove.reset();
                }
                else if ((Mayflower.isKeyDown(keys[1]) || Mayflower.isKeyPressed(keys[5])))
                {
                    setLocation(getX(), getY() + 20);
                    toMove.reset();

                }
                else if ((Mayflower.isKeyDown(keys[2]) || Mayflower.isKeyPressed(keys[6])) )
                {
                    setLocation(getX() - 20, getY());
                    toMove.reset();
                }
                else if ((Mayflower.isKeyDown(keys[3]) || Mayflower.isKeyPressed(keys[7])))
                {
                    setLocation(getX() + 20, getY());
                    toMove.reset();

                }
            }
        }
    public void setCanMove()
    {
        this.canMove = canMove;
    }

    public boolean checkDead()
    {
        return this.isTouching(SnakeActor.class)|| this.isTouching(SnakeBody.class);
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
    public void removeBody()
    {
        for(int i = 0;i<snakeBodies.size();i++)
        {
            this.getWorld().removeObject(snakeBodies.get(i));
        }
    }

    public void dead()
    {
        if(multi)
        {
            this.removeTouching(SnakeActor.class);
        }



    }
}
