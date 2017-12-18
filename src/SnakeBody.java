import mayflower.Actor;
import mayflower.Mayflower;
import mayflower.Timer;

public class SnakeBody extends Actor
{
    private int life;
    private Timer toMove;

    private Properties properties;

    public SnakeBody(Properties p, int pl, int size)
    {
        properties = p;
        toMove = new Timer(75);

        String arr[] = properties.getSnakeThemes();
        setImage( arr[pl - 1] );
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
