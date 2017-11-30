import mayflower.*;

public class multiplayerSelect extends World
{
    Object[] info;
    public multiplayerSelect()
    {
        setBackground("img/newSnek.png");
    }

    public void act()
    {

        if(Mayflower.isKeyPressed(Keyboard.KEY_2))
            Mayflower.setWorld(new SnakeWorld(true,2));
        if(Mayflower.isKeyPressed(Keyboard.KEY_3))
            Mayflower.setWorld(new SnakeWorld(true,3));
        if(Mayflower.isKeyPressed(Keyboard.KEY_4))
            Mayflower.setWorld(new SnakeWorld(true,4));

    }
}
