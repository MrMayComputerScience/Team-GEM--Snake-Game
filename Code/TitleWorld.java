import mayflower.*;

public class TitleWorld extends World
{
    Object[] info;
    private Actor singlePlayer;
    private Actor multiplayer;
    public TitleWorld()
    {
        setBackground("img/newSnek.png");
        Actor singlePlayer = new Label("Single Player");

        addObject(singlePlayer,300,400);
        Label multiplayer = new Label("MultiPlayer");
        multiplayer.setColor(Color.ORANGE);
        addObject(multiplayer,300,300);

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
        if(Mayflower.isKeyPressed(Keyboard.KEY_H))
        {
            System.out.println("h");
            Mayflower.setWorld(new HighScore());
        }
    }
}
