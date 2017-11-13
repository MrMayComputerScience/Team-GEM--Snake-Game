import mayflower.*;

public class SquareActor extends Actor
{
  public SquareActor()
  {
    setImage("Square.png");
  }
  
  public void act()
  {
    //check if this is touching the Circle actor
    if(isTouching(CircleActor.class))
    {
      //get a reference to the circle actor
      CircleActor circle = getOneIntersectingObject(CircleActor.class);
      
      //increase the score of the circle actor
      circle.incPoints(1);
      
      //remove this Square from the world
      getWorld().removeObject(this);
    }
  }
}