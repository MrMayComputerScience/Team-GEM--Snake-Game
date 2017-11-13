import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

/**
 * Created by s581467 on 11/7/2017.
 */
public class SnakeActor extends Actor {
    public SnakeActor() { setImage("img/snake.png"); }

    private int dir; // 8 is up, 2 is down , 4 is left, 6 is right
    public int size;


    public void act()
    {
        SnakeBody snakeBody = new SnakeBody(size);
        //movement and directions
        if(Mayflower.isKeyPressed(Keyboard.KEY_UP) || Mayflower.isKeyPressed(Keyboard.KEY_W)){
            dir = 8;
        }else if(Mayflower.isKeyPressed(Keyboard.KEY_DOWN) || Mayflower.isKeyPressed(Keyboard.KEY_S)){
            dir = 2;
        }else if(Mayflower.isKeyPressed(Keyboard.KEY_LEFT) || Mayflower.isKeyPressed(Keyboard.KEY_A)){
            dir = 4;
        }else if(Mayflower.isKeyPressed(Keyboard.KEY_RIGHT) || Mayflower.isKeyPressed(Keyboard.KEY_D)){
            dir = 6;
        }
        if(dir == 8)
        {
            add(snakeBody,getX(),getY());
            setLocation(getX(),getY()-20);
        }else if(dir == 2)
        {
            add(snakeBody,getX(),getY());
            setLocation(getX(),getY()+20);
        }else if(dir == 4)
        {
            add(snakeBody,getX(),getY());
            setLocation(getX()-20,getY());
        }else if(dir == 6)
        {
            add(snakeBody,getX(),getY());
            setLocation(getX()+20,getY());
        }

        if(this.isTouching(PointActor.class))
        {
            this.removeTouching(PointActor.class);
            PointActor pointActor = new PointActor();
            getWorld().addObject(pointActor,pointActor.getRow()*20,pointActor.getCol()*20);
            size++;
        }

    }
    public boolean add(Actor actor,int x, int y)
    {
        getWorld().addObject(actor,x,y);
        return true;
    }
    public boolean dead()
    {
        if(this.isTouching(SnakeActor.class))
        {
            return true;
        }
        else return false;
    }
}
