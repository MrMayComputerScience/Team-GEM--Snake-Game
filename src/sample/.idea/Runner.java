import mayflower.*;

public class Runner extends Mayflower
{
  public Runner(String title, int w, int h)
  {
    super(title, w, h);
  }
  
  public void init()
  {
    setWorld(new MyWorld());
  }
  
  public static void main(String[] args)
  {
    new Runner("IntelliJ Demo", 800, 600);
  }
 
}