//new GameOver


import mayflower.*;

public class GameOver extends World
{
    public GameOver()
    {
        setBackground("img/gameover.png");
        Label highScore = new Label("press h to view highScores.",20);
        addObject(highScore,300,500);
    }
    public GameOver(boolean multi,int player)
    {
        setBackground("img/gameover.png");
        Label highScore = new Label("press h to view highScores.",20);
        addObject(highScore,300,500);
        Label whoWins = new Label("Player "+player+" Loses");
        if(multi)
            addObject(whoWins,300,100);
    }
    public void act()
    {
        if(Mayflower.isKeyPressed(Keyboard.KEY_R))
        {
            System.out.println("r");
            Mayflower.setWorld(new SnakeWorld(false,1));
        }
        if(Mayflower.isKeyPressed(Keyboard.KEY_T)) {Mayflower.setWorld(new TitleWorld()); }
        if(Mayflower.isKeyPressed(Keyboard.KEY_H))
        {
            System.out.println("h");
            Mayflower.setWorld(new HighScore());
        }
    }
}
