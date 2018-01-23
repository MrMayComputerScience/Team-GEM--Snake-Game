//Stores all of the variables that are needed to create a game...
public class Properties
{
    private String players;
    private String mode;
    private String themeS;
    private String themeW;
    private String portals;
    public Properties()
    {
        players = "1";
        mode = "B";
        themeS = "img/snake.png";
        themeW = "img/wall.png";
        portals = "no";
    }

    public Properties(String p, String m, String s, String w,String por)
    {
        players = p;
        mode = m;
        themeS = s;
        themeW = w;
        portals = por;
    }

    public String getPortals() {
        return portals;
    }
    public void setPortals(String p)
    {
        portals = p;
    }

    //For the number of players
    public void setPlayers(String p)
    {
        players = p;
    }

    public String getPlayers()
    {
        return players;
    }

    //For the mode to play
    public void setMode(String m)
    {
        mode = m;
    }

    public String getMode()
    {
        return mode;
    }

    //For the snake in the Stage
    public void setSnakeTheme(String tS)
    {
        themeS = tS;
    }

    public String getSnakeTheme()
    {
        return themeS;
    }

    //For the wall in the Stage
    public void setWallTheme(String tW)
    {
        themeW = tW;
    }

    public String getWallTheme()
    {
        return themeW;
    }
}
