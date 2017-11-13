import mayflower.*;

public class PointActor extends Actor
{
    private int row;
    private int column;
    public PointActor()
    {
        setImage("img/wall.png");
        row = (int) Math.floor(Math.random() * 39);
        column = (int) Math.floor(Math.random() * 29);
    }

    public void act()
    {

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
