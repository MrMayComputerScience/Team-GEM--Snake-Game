import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

public class WallActor extends Actor
{
    public WallActor()
    {
        setImage("img/wall.png");
    }

    public void act()
    {
        if(this.isTouching(SnakeActor.class))
        {
            this.removeTouching(SnakeActor.class);
            GameOver over = new GameOver();
            Mayflower.setWorld(over);
        }
    }
}
