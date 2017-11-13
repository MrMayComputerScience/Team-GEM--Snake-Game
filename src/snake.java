import mayflower.Actor;
import mayflower.Keyboard;

public class snake extends Actor
{
    private String direction;
    private Keyboard keyboard;
    private int y;
    private int x;
    public snake()
    {
        y = 0;
        x=0;
    }
    public String getDirection()
    {
        return direction;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void act()
    {

    }
}
