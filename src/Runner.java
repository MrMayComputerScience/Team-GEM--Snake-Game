
import mayflower.*;

public class Runner extends Mayflower
{
    public Runner(){
        super("Snek", 800, 600);
    }

    public void init()
    {
        //Mayflower.setFullScreen(true);

        World startingWorld = new SnakeWorld();
        Mayflower.setWorld(startingWorld);
    }

    public static void main(String[] args){
        new Runner();
    }
}