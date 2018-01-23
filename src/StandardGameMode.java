import mayflower.Actor;
import mayflower.Mayflower;

import java.util.ArrayList;
import java.util.List;

public class StandardGameMode extends AbstractGameModeManager
{
    private Properties properties;
    private Portal portal;
    private Portal portal2;
    private String[] Actions = {"LEFT","RIGHT","UP","DOWN"};
    private PointActor point;
    private ArrayList<SnakeActor> snakes;
    private InputManager inputManager;
    private TimerActor timerActor;
    public StandardGameMode(Properties propertiesT)
    {
        snakes = new ArrayList<SnakeActor>();
        properties = propertiesT;
        int players = Integer.parseInt(properties.getPlayers());
        setWorld(new SnakeWorld(properties));
        SnakeActor snake1 = new SnakeActor(properties,1);
        SnakeActor snake2 = new SnakeActor(properties,2);
        SnakeActor snake3 = new SnakeActor(properties,3);
        SnakeActor snake4 = new SnakeActor(properties,4);
        SnakeActor snake = new SnakeActor(properties);
        snakes.add(snake);
        if (players > 1) {
            snakes.add(snake1);
            snakes.add(snake2);
        }
        if (players > 2) {
            snakes.add(snake3);
        }
        if (players > 3) {
            snakes.add(snake4);
        }
        if(propertiesT.getPortals().equals("yes"))
            Portals();
        spawn((ArrayList)getSnakes());
        point = new PointActor();
        getWorld().addObject(point,point.getRow()*20,point.getCol()*20);
        Mayflower.setWorld(getWorld());
        inputManager = new InputManager(this);
        getWorld().addObject(inputManager,0,0);
        timerActor = new TimerActor(this);
        getWorld().addObject(timerActor,0,0);
    }
    @Override
    public void process(String action)
    {
        boolean ready1=true;
        for(int i =1;i<snakes.size();i++)
        {
            if(snakes.get(i).ready())
                continue;
            ready1=false;
        }
        if(ready1)
        {
            for(int i = 0; i<snakes.size();i++)
            {
                snakes.get(i).setCanMove(true);
                timerActor.instantiate();
            }
        }
        String[] actionT = action.split("_");
        if(actionT[0].equals("Tick"))
        {
            for(SnakeActor s:snakes)
            {
                s.tick();
                s.collect();
            }

            List<Actor> obj = getWorld().getObjects();

            if(!(obj.contains(point)))
            {
                do{
                    getWorld().addObject(point,(int) (Math.floor(Math.random() * 38)+1)*20,(int) (Math.floor(Math.random() * 28)+1)*20);
                }while (point.istouching());
            }



            if(snakes.get(0).ready())
                snakes.get(0).setCanMove(true);

            if(Integer.parseInt(properties.getPlayers())>1)
            {

                for (int i = 1;i<snakes.size();i++ )
                {

                    if(snakes.get(i).isTouchingSA().size()>0)
                    {
                        for(int x = 0; x<snakes.get(i).isTouchingSA().size();x++)
                        {
                            snakes.remove(snakes.get(i).isTouchingSA().remove(x));
                        }
                        snakes.get(i).removeBody();
                        getWorld().removeObject(snakes.get(i));
                        snakes.remove(i);
                        i--;
                    }
                    else if(snakes.get(i).checkDead()) {
                        snakes.get(i).removeBody();
                        getWorld().removeObject(snakes.get(i));
                        snakes.remove(i);
                        i--;
                    }


                }
                if(snakes.size()==2) {
                    snakes.get(1).dead();
                    snakes.remove(1);
                }
                else if(snakes.size()==1)
                    Mayflower.setWorld(new GameOver(true,"You suck",properties));
            }
            /*else
            {
                if(snakes.get(0).checkDead()) {
                    snakes.get(0).removeBody();
                    snakes.get(0).remove();
                }

            }*/
        }
        if(Integer.parseInt(properties.getPlayers())>1)
        if(actionT[0].equals("P1"))
        {

            for(int i = 0; i<Actions.length;i++)
            {
                if(actionT[1].equals(Actions[i]))
                {
                    snakes.get(0).turnLeft();
                }
                if(actionT[1].equals(Actions[i]))
                {
                    snakes.get(0).turnRight();
                }
                if(actionT[1].equals(Actions[i]))
                {
                    snakes.get(0).turnUp();
                }
                if(actionT[1].equals(Actions[i]))
                {
                    snakes.get(0).turnDown();
                }
            }
        }
        else if(actionT[0].equals("P2"))
        {

        }
        else if(actionT[0].equals("P3"))
        {

        }
        else if(actionT[0].equals("P4"))
        {

        }
        else
        {

        }
    }
    public void spawn(ArrayList<SnakeActor> list)
    {
        if ((Integer.parseInt(properties.getPlayers())==1))
            getWorld().addObject(snakes.get(0), 20, 20);
        else
        for(int x =0;x<snakes.size();x++)
        {
            if(x==1)
                getWorld().addObject(list.get(x),20,20);
            if(x==2)
                getWorld().addObject(list.get(x),760,20);
            if(x==3)
                getWorld().addObject(list.get(x),20,560);
            if(x==4)
                getWorld().addObject(list.get(x),760,560);
        }
    }
    public void Portals()
    {

        if(properties.getPortals().equals("yes"))
        {
            portal = new Portal();
            portal2 = new Portal();
            getWorld().addObject(portal, (int) (Math.floor(Math.random() * 38)+1)*20, (int) (Math.floor(Math.random() * 28)+1)*20);
            getWorld().addObject(portal2, (int) (Math.floor(Math.random() * 38)+1)*20, (int) (Math.floor(Math.random() * 28)+1)*20);
            portal2.setyx(portal);
            portal.setyx(portal2);
        }
    }
}
