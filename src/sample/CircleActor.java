import mayflower.*;

public class CircleActor extends Actor
{
  private int speed; //how many pixels this Circle moves
  private int score;
  
  public CircleActor()
  {
    speed = 10;
    setImage("Circle.png");
  }
  
  public void act()
  {
    //Move this Circle based on which arrow keys are being pressed
    if(Mayflower.isKeyDown(Keyboard.KEY_LEFT))
    {
      setLocation(getX()-speed, getY());
    }
    if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT))
    {
      setLocation(getX()+speed, getY());
    }
    if(Mayflower.isKeyDown(Keyboard.KEY_UP))
    {
      setLocation(getX(), getY()-speed);
    }
    if(Mayflower.isKeyDown(Keyboard.KEY_DOWN))
    {
      setLocation(getX(), getY()+speed);
    }
  }
  
  public void incPoints(int amnt)
  {
    score += amnt;
  }
  
  public int getScore()
  {
    return score;
  }
}