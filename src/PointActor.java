import mayflower.*;

public class PointActor extends Actor
{
    private int row;
    private int column;
    public PointActor()
    {
        row = (int) (Math.floor(Math.random() * 38)+1);
        column = (int) (Math.floor(Math.random() * 28)+1);
        //getWorld().add(this, row * 20, column * 20);
        spawn();
    }

    public void act()
    {

    }
    public void spawn()
    {
        setImage("img/wall.png");


            row = (int) (Math.floor(Math.random() * 38)+1);
            column = (int) (Math.floor(Math.random() * 28)+1);
            World temp = getWorld();
            this.equals("a");



    }
    public boolean istouching()
    {
        return (this.getIntersectingObjects(Portal.class).size()>0);
    }
    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return column;
    }
}
