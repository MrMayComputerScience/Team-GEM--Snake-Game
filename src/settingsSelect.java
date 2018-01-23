import mayflower.*;

public class settingsSelect extends World
{
    private Properties settings;

    private Label play;
    private Label mode;
    private Label ThemeS;
    private Label ThemeW;
    private Label Portal;

    public settingsSelect(Properties p)
    {
        settings = p;

        play = new Label("Players", 50, Color.WHITE);
        mode = new Label("Gamemode", 50, Color.WHITE);
        ThemeS = new Label("Snake Theme", 50, Color.WHITE);
        ThemeW = new Label("Wall Theme", 50, Color.WHITE);
        Portal = new Label("Portals", 50, Color.WHITE);

        addObject(play, 320, 20 );
        addObject(mode, 280, 170 );
        addObject(ThemeS, 240, 320);
        addObject(ThemeW, 260, 470);
        addObject(Portal,260,520);
    }

    @Override
    public void act()
    {
        if(Mayflower.mouseClicked(play))
        {
            settings.setPlayers( Mayflower.ask("How many are playing?") );
        }
        if(Mayflower.mouseClicked(Portal))
        {
            settings.setPortals( Mayflower.ask("Do you want portals?") );
        }
        if(Mayflower.mouseClicked(mode))
        {
            settings.setMode(Mayflower.ask("How do you want to play?" + "\n"
                    + "Enter \"B\" for Bit collect Mode" + "\n"
                    + "Enter \"A\" for Always Grow Mode" + "\n"
                    + "Enter \"T\" for Twitch Mode"));

            while( !settings.getMode().equals("B") && !settings.getMode().equals("A") && !settings.getMode().equals("T"))
            {
                settings.setMode(Mayflower.ask("That is not a valid input. Try again." + "\n"
                        + "How do you want to play?" + "\n"
                        + "Enter \"B\" for Bit collect Mode" + "\n"
                        + "Enter \"A\" for Always Grow Mode" + "\n"
                        + "Enter \"T\" for Twitch Mode"));
            }
        }
        if(Mayflower.mouseClicked(ThemeS))
        {
            settings.setSnakeTheme( Mayflower.ask("How do you want the snake(s) to look?") );
        }
        if(Mayflower.mouseClicked(ThemeW))
        {
            settings.setWallTheme( Mayflower.ask("How do you want the walls to look?") );
        }

        if(Mayflower.isKeyPressed(Keyboard.KEY_T))
        {
            Mayflower.setWorld(new TitleWorld(settings));
        }

    }
}
