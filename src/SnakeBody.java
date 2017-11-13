import mayflower.Actor;

public class SnakeBody extends Actor
{
    private int life;
    public SnakeBody(int size)
    {
        setImage("img/snake.png");
        life = size;
    }
    @Override
    public void act()
    {
        life--;
        if(life <= 0)
            getWorld().removeObject(this);
    }
}
