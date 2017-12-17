import mayflower.Actor;

public class Portal extends Actor
{
    private int y;
    private int x;
    public Portal()
    {
        setImage("img/wall.png");
    }

    public void setyx(Portal portal)
    {
        y=portal.getY();
        x=portal.getX();
    }
    public void act()
    {
        SnakeActor temp = getOneIntersectingObject(SnakeActor.class);
        if(temp !=null)
        {
            temp.setLocation(x,y);
            temp.portal();

        }
    }
}
