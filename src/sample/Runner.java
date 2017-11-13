import mayflower.*;

public class Runner extends Mayflower
{
  public Runner(String title, int w, int h)

  {
    super("Snek", 800, 600);
  }
  
  public void init()
  {
    World startingWorld = new SnakeWorld();
    Mayflower.setWorld(startingWorld);
  }
  
  public static void main(String[] args)
  {
    new Runner();
  }
 
}