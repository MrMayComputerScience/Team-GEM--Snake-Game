import mayflower.*;

public class TitleWorld extends World
{
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
<<<<<<< HEAD
            if(prop.getMode().equals("M"))
                Mayflower.setWorld(new MouseWorld(0,prop));
            else
=======
            System.out.println("r");
>>>>>>> 8fae832e9e7d966f019aacf0f40882f3d8b1f326
            Mayflower.setWorld(new SnakeWorld(prop));
        }
        if(Mayflower.isKeyPressed(Keyboard.KEY_M))
            Mayflower.setWorld(new multiplayerSelect(prop));

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
