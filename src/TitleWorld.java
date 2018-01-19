import mayflower.*;

public class TitleWorld extends World
{
    /*
        TODO:
        1. Add a "How to Play" page with controls and instructions
    */

    public static String skin;
    public static MayflowerImage img;
    private Properties prop;
    public TitleWorld(Properties p)
    {
        setBackground("img/newSnek.png");



        prop = p;
    }

    public void act()
    {

        if(Mayflower.isKeyPressed(Keyboard.KEY_R))
        {
            if(prop.getMode().equals("M"))
                Mayflower.setWorld(new MouseWorld(0,prop));
            else
            Mayflower.setWorld(new SnakeWorld(prop));
        }

        if(Mayflower.isKeyPressed(Keyboard.KEY_N))
            Mayflower.setWorld(new MMSelect(prop));

        if(Mayflower.isKeyPressed(Keyboard.KEY_H))
        {
            System.out.println("h");
            Mayflower.setWorld(new HighScore(prop));
        }
        if(Mayflower.isKeyPressed(Keyboard.KEY_I))
        {
            System.out.println("s");
            Mayflower.setWorld(new settingsSelect(prop));
        }
        if(Mayflower.isKeyPressed(Keyboard.KEY_S))
        {
            System.out.println("s");
            skin = Mayflower.ask("Enter Skin File Path");
            img = new MayflowerImage(skin);
            img.scale(20,20);
        }
    }
}
