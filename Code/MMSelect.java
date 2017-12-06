import mayflower.*;

public class MMSelect extends World
{
    Object[] info;
    public MMSelect()
    {
        setBackground("img/newSnek.png");
    }

    public void act()
    {

        if(Mayflower.isKeyPressed(Keyboard.KEY_2))
            Mayflower.setWorld(new MouseWorld(true,2));
        if(Mayflower.isKeyPressed(Keyboard.KEY_3))
            Mayflower.setWorld(new MouseWorld(true,3));
        if(Mayflower.isKeyPressed(Keyboard.KEY_4))
            Mayflower.setWorld(new MouseWorld(true,4));

    }
}
