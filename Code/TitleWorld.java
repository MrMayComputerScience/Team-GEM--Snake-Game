import mayflower.*;

public class TitleWorld extends World
{
    public static String skin;
    public static MayflowerImage img;
    Object[] info;
    public TitleWorld()
    {
        setBackground("img/newSnek.png");
    }

    public void act()
    {
        if(Mayflower.isKeyPressed(Keyboard.KEY_R))
        {
            System.out.println("r");
            Mayflower.setWorld(new SnakeWorld(false,1));
        }
        if(Mayflower.isKeyPressed(Keyboard.KEY_M))
        Mayflower.setWorld(new multiplayerSelect());

        if(Mayflower.isKeyPressed(Keyboard.KEY_N))
            Mayflower.setWorld(new MMSelect());

        if(Mayflower.isKeyPressed(Keyboard.KEY_H))
        {
            System.out.println("h");
            Mayflower.setWorld(new HighScore());
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
