import mayflower.Actor;
import mayflower.Mayflower;
import mayflower.Timer;

public class SnakeBody extends Actor
{
    private int life;
    private Timer toMove;
    public SnakeBody(int size)
    {
        toMove = new Timer(75);


            setImage("img/snake.png");
            life = size;


    }
    public void test()
    {
        life--;
        if (life <= 0)
            getWorld().removeObject(this);
    }

    public void setLife(int life) {
        this.life = life;
    }
    public int getLife()
    {
        return life;
    }
    @Override
    public void act()
    {

    }
}
