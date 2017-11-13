import mayflower.World;

public class gameScreen extends World {
    private world map;
    private snake Snake;
    //initilizes the game
    public gameScreen(world x, snake s)
    {
        map = x;
        Snake = s;
    }







    @Override
    public void act() {
        for (int r = 0; r < map.getHeight(); r++) {
            for (int c = 0; c < map.getWidth(); c++) {

                    removeObject(map.getD2()[c][r]);
                    int c2 = (c * 128) + 64;
                    int r2 = (r * 128);
                    addObject(map.getD2()[c][r], r2, c2);


            }
        }
    }
    public void move()
    {
        int x = Snake.getX();
        int y = Snake.getY();
        if(Snake.getDirection().equals("North"))
        {

        }
    }
}
