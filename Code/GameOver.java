//new GameOver


import mayflower.*;

public class GameOver extends World
{
    private Properties properties;

    public GameOver(Properties p)
    {
        //Setting up basics for the game over stage
        setBackground("img/gameover.png");
        Label highScore = new Label("press h to view highScores.",20);
        addObject(highScore,300,500);
        properties = p;

        //Sets up the label for winning
        int players = Integer.parseInt(properties.getPlayers());
        boolean multi = players > 1;
        String message = multi ? "Player"+players+"Wins" : "";
        Label whoWins = new Label(message);
        if(multi)
            addObject(whoWins,300,100);
    }

    public void act()
    {
        if(Mayflower.isKeyPressed(Keyboard.KEY_T))
        {
            Mayflower.setWorld(new TitleWorld(properties));
        }

        if(Mayflower.isKeyPressed(Keyboard.KEY_H))
        {
            System.out.println("h");
            Mayflower.setWorld(new HighScore(properties));
        }
    }
}
