package sample;
import mayflower.World;

public class gameScreen extends World
{
    private world map;

    //initilizes the game
    public gameScreen(world x)
    {
        setBackground("H:/TechApps/SnakeGame/Team-GEM--Snake-Game/src/sample/.idea/pictures/background.png");
        map = x;

    }







    @Override
    public void act() {
        //moves kitty/ninja

        for (int r = 0; r < map.getHeight(); r++)
        {
            for (int c = 0; c < map.getWidth(); c++)
            {

                    removeObject(map.getD2()[c][r]);
                    int c2 = (c * 128) + 64;
                    int r2 = (r * 128);
                    addObject(map.getD2()[c][r], r2, c2);


            }
        }
    }
}
