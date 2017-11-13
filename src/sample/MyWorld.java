import mayflower.*;

public class MyWorld extends World
{
  public MyWorld()
  {

  }
  public void act()
  {
    showText("Score: " + circle.getScore(), 10, 10);
  }
}