import mayflower.*;

public class snakeSelect extends World
{
    private Properties settings;

    private Label p1;
    private Label p2;
    private Label p3;
    private Label p4;

    public snakeSelect(Properties p)
    {
        settings = p;

        p1 = new Label("Player 1", 50, Color.WHITE);
        p2 = new Label("Player 2", 50, Color.WHITE);
        p3 = new Label("Player 3", 50, Color.WHITE);
        p4 = new Label("Player 4", 50, Color.WHITE);

        addObject(p1, 320, 20 );
        addObject(p2, 320, 170 );
        addObject(p3, 320, 320);
        addObject(p4, 320, 470);
    }

    @Override
    public void act()
    {
        if(Mayflower.mouseClicked(p1))
        {
            settings.setSnakeTheme( Mayflower.ask("How do you want this snake to look?"), 0 );
        }
        if(Mayflower.mouseClicked(p2))
        {
            settings.setSnakeTheme( Mayflower.ask("How do you want this snake to look?"), 1 );
        }
        if(Mayflower.mouseClicked(p3))
        {
            settings.setSnakeTheme( Mayflower.ask("How do you want this snake to look?"), 2 );
        }
        if(Mayflower.mouseClicked(p4))
        {
            settings.setSnakeTheme( Mayflower.ask("How do you want this snake to look?"), 3 );
        }

        if(Mayflower.isKeyPressed(Keyboard.KEY_I))
        {
            Mayflower.setWorld(new settingsSelect(settings));
        }

    }
}

