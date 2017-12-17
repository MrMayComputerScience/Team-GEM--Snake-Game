import mayflower.*;

public class MMSelect extends World
{
    Object[] info;
    private Properties prop;
    public MMSelect(Properties p)
    {
        setBackground("img/newSnek.png");
        prop = p;
    }

    public void act()
    {

        if(Mayflower.isKeyPressed(Keyboard.KEY_2))
            Mayflower.setWorld(new MouseWorld(2,prop));
        if(Mayflower.isKeyPressed(Keyboard.KEY_3))
            Mayflower.setWorld(new MouseWorld(3,prop));
        if(Mayflower.isKeyPressed(Keyboard.KEY_4))
            Mayflower.setWorld(new MouseWorld(4,prop));

    }
}
