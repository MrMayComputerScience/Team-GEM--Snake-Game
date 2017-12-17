import mayflower.*;

public class multiplayerSelect extends World
{
    Object[] info;
    private Properties prop;
    public multiplayerSelect(Properties p)
    {
        prop = p;
        setBackground("img/newSnek.png");
    }

    public void act()
    {

        if(Mayflower.isKeyPressed(Keyboard.KEY_2))
            Mayflower.setWorld(new SnakeWorld(prop));
        if(Mayflower.isKeyPressed(Keyboard.KEY_3))
            Mayflower.setWorld(new SnakeWorld(prop));
        if(Mayflower.isKeyPressed(Keyboard.KEY_4))
            Mayflower.setWorld(new SnakeWorld(prop));

    }
}
