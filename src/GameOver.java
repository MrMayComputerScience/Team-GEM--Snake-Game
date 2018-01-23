//new GameOver


import mayflower.*;

public class GameOver extends World
{
    private Properties properties;
    public GameOver(Properties p)
    {
        setBackground("img/gameover.png");
        Label highScore = new Label("press h to view highScores.",20);
        addObject(highScore,300,500);
        properties = p;
    }
    public GameOver(boolean multi,int player,Properties p)
    {
        setBackground("img/gameover.png");
        Label highScore = new Label("press h to view highScores.",20);
        addObject(highScore,300,500);
        Label whoWins = new Label("Player "+player+" Wins");
        if(multi)
            addObject(whoWins,300,100);
        properties = p;
    }
    public GameOver(boolean multi,String message,Properties p)
    {
        setBackground("img/gameover.png");
        Label highScore = new Label("press h to view highScores.",20);
        addObject(highScore,300,500);
        Label whoWins = new Label(message);
        if(multi)
            addObject(whoWins,300,100);
        properties = p;
    }
    public void act()
    {
        if(Mayflower.isKeyPressed(Keyboard.KEY_R))
        {

            Mayflower.setWorld(new SnakeWorld(properties));
        }
        if(Mayflower.isKeyPressed(Keyboard.KEY_T)) {Mayflower.setWorld(new TitleWorld(properties)); }
        if(Mayflower.isKeyPressed(Keyboard.KEY_H))
        {

            Mayflower.setWorld(new HighScore(properties));
        }
    }
}
