import mayflower.Actor;
public class SnakeBody extends Actor
{
    private int time;
    public SnakeBody(int x)
    {
        time = x;
    }
    public void time(int x)
    {
        time += x;
    }
    @Override
    public void act()
    {
        time--;
    }
}
