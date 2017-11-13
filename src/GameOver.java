import mayflower.*;

public class GameOver extends World
{
    public GameOver()
    {
        setBackground("img/gameover.png");
    }

    public void act()
    {
        if(Mayflower.isKeyPressed(Keyboard.KEY_R))
        {
            System.out.println("r");
            Mayflower.setWorld(new SnakeWorld());
        }
    }
}
