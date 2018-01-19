/**
 * Created by s581467 on 11/7/2017.
 */
import java.util.*;

import com.sun.org.apache.xpath.internal.operations.Bool;
import mayflower.*;

public class SnakeWorld extends World
{

    int[][] board = new int[40][30];
    private ArrayList<SnakeActor> snakes;
    Boolean multiplayer;

    private Properties properties;

    public SnakeWorld(Properties p)
    {
        properties = p;

        //Checks to see if the world is multiplayer
        int multi = Integer.parseInt(properties.getPlayers());
        multiplayer = multi > 1 ? true : false;

        //Checks the number of players
        int players = Integer.parseInt(properties.getPlayers());

        //Gets the mode to play on
        String mode = properties.getMode();

        //Creates the snake array
        snakes = new ArrayList<SnakeActor>();

        //Sets up the board and walls
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length;j++){
                board[i][j] = 0;
            }
        }
        for(int i =0;i<board.length;i++)
        {
            for(int j = 0;j<board[0].length;j++)
            {
                if(i == 0)
                    board[i][j] = 2;
                        /* if(i == 39)
                        {
                        board[i][j] = 2;
                        }*/
                if(i==39)
                {
                    board[i][j] =2;
                }

            }
        }
        for(int i = 0;i<board.length;i++)
        {
            board[i][0]=2;
            board[i][29]=2;
        }

        //Sets up snakes to be added
        SnakeActor snake1 = new SnakeActor(properties, 1);
        SnakeActor snake2 = new SnakeActor(properties,2);
        SnakeActor snake3 = new SnakeActor(properties,3);
        SnakeActor snake4 = new SnakeActor(properties,4);
        SnakeActor snake = new SnakeActor(properties);

        //Adds the snake for singleplayer
        snakes.add(snake);

        //Adds the snakes for multiplayer
        if(players>1){ snakes.add(snake1);snakes.add(snake2); }
        if(players>2){ snakes.add(snake3); }
        if(players>3){ snakes.add(snake4); }

        //Sets snake when in singleplayer
        if(!multiplayer)
        {
            board[1][1] = 1;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 1) {
                        addObject(snakes.get(0), i * 20, j * 20);
                    }
                    if (board[i][j] == 2) {
                        addObject(new WallActor(), i * 20, j * 20);
                    }
                }

            }
        }
        //Sets snake when in multiplayer
        else
        {
            board[1][1] = 1;

            board[5][5] = 3;
            spawn(snakes);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 1) {
                        //addObject(snakes.get(1), i * 20, j * 20);
                    }
                    if(board[i][j]==3);
                    //addObject(snakes.get(2),i*20,j*20);
                    if (board[i][j] == 2) {
                        addObject(new WallActor(), i * 20, j * 20);
                    }
                }

            }
        }

        if(mode.equals("B"))
        {
            List<Actor> obj = getObjects();
            PointActor point = new PointActor();
            point.spawn();
            if (!(obj.contains(point))) {
                board[point.getRow()][point.getCol()] = 3;
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 3) {
                        addObject(point, i * 20, j * 20);
                    }
                }

            }
        }

    }

    public void spawn(ArrayList<SnakeActor> list)
    {
        for(int x =1;x<list.size();x++)
        {
            if(x==1)
                addObject(list.get(x),20,20);
            if(x==2)
                addObject(list.get(x),760,20);
            if(x==3)
                addObject(list.get(x),20,560);
            if(x==4)
                addObject(list.get(x),760,560);
        }
    }
    public void act()
    {

        if(snakes.get(0).ready())
            snakes.get(0).setCanMove(true);

        if(multiplayer)
        {
            Boolean done;
            Boolean ready=false;
            for (int i = 1;i<snakes.size();i++ )
            {

                if(snakes.get(i).isTouchingSA().size()>0)
                {
                    for(int x = 0; x<snakes.get(i).isTouchingSA().size();x++)
                    {
                        snakes.remove(snakes.get(i).isTouchingSA().remove(x));
                    }
                    snakes.get(i).removeBody();
                    removeObject(snakes.get(i));
                    snakes.remove(i);
                    i--;
                }
                else if(snakes.get(i).checkDead()) {
                    snakes.get(i).removeBody();
                    removeObject(snakes.get(i));
                    snakes.remove(i);
                    i--;
                }


            }
            if(snakes.size()==2) {
                snakes.get(1).dead();
                snakes.remove(1);
            }
            else if(snakes.size()==1)
                //Mayflower.setWorld(new GameOver(true,"You suck"));
                Mayflower.setWorld(new GameOver(properties));
            ready=true;
            for(int i =1;i<snakes.size();i++)
            {
                if(snakes.get(i).ready())
                    continue;
                ready=false;
            }
            if(ready)
            {
                for(int i = 0; i<snakes.size();i++)
                {
                    snakes.get(i).setCanMove(true);
                }
            }
        }
    }

}