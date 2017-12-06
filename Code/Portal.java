import mayflower.Actor;

public class Portal extends Actor
{
    private Portal portal2;
    public Portal(Portal portal)
    {
        portal2 = portal;
    }
    @Override
    public void act()
    {
        if(!this.getOneIntersectingObject(SnakeActor.class).equals(null))
        {

        }
    }
}
