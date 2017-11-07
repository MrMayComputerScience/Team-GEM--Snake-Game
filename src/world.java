import mayflower.Actor;

public class world extends Actor
{
    private Actor[][] d2;



    public world()
    {
        d2 = new Actor[6][10];
        for(int x=0;x<10;x++)
        {

        }


    }

    @Override
    public void act()
    {

    }

    public int getHeight()
    {
        return d2[0].length;
    }
    public int getWidth()
    {
        return d2.length;
    }
    public Actor[][] getD2()
    {
        return d2;
    }
    public void removed2(Actor x)
    {
        for(int r = 0; r<6;r++)
        {
            for(int c = 0;c<10;c++)
            {
                if(d2[r][c] != null)
                    if(d2[r][c].equals(x))
                       d2[r][c] = null;
            }
        }
    }

}
