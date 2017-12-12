import mayflower.*;

public class TitleWorld extends World
{
    //You darn kids get off of here!
    private Properties prop;

    //With the properties object
    public TitleWorld(Properties p)
    {
        setBackground("img/newSnek.png");
        Label temp = new Label("Single Player");
        temp.setColor(Color.CYAN);

        prop = p;
    }

    public void act()
    {
        if(Mayflower.isKeyPressed(Keyboard.KEY_H))
        {
            System.out.println("h");
            Mayflower.setWorld(new HighScore(prop));
        }

        if(Mayflower.isKeyPressed(Keyboard.KEY_S))
        {
            System.out.println("s");
            Mayflower.setWorld(new settingsSelect(prop));
        }

        if(Mayflower.isKeyPressed(Keyboard.KEY_P))
        {
            System.out.println("p");
            Mayflower.setWorld(new SnakeWorld(prop));
        }
    }
}
