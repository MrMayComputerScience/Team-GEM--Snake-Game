//Stores all of the variables that are needed to create a game...
public class Properties
{
    private String players;
    private String mode;
    private String[] themeS;
    private String themeW;
    private String portals;
    private int winner;
    public Properties()
    {
        players = "1";
        mode = "B";
        themeS = new String[]{"img/snake.png", "img/snake.png", "img/snake.png", "img/snake.png"};
        themeW = "img/wall.png";
        portals = "no";
        winner = 0;
    }

    public Properties(String p, String m, String[] s, String w,String por)
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
    public void setSnakeTheme(String tS, int p)
    {
        themeS[p] = tS;
    }

    public String[] getSnakeThemes()
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
    public int getWinner()
    {
        return winner;
    }
    public void setWinner(int i)
    {
        winner = i;
    }
}
