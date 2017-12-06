/**
 * Created by s581467 on 11/7/2017.
 */
import java.util.*;

import com.sun.org.apache.xpath.internal.operations.Bool;
import mayflower.*;

public class MouseWorld extends World {

    int[][] board = new int[40][30];
    private ArrayList<Mover> snakes;
    Boolean multiplayer;
    public MouseWorld(boolean m,int players)
    {
        multiplayer=m;
        snakes = new ArrayList<Mover>();
        for(int i=0; i<board.length; i++){
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

        MouseActor mouse2 = new MouseActor(2);
        MouseActor mouse3 = new MouseActor(3);
        MouseActor mouse4 = new MouseActor(4);
        SnakeActor snake = new SnakeActor(1);
        if(players>0){ snakes.add(snake);snakes.add(mouse2); }
        if(players>1){ snakes.add(mouse3); }
        if(players>2){ snakes.add(mouse4); }
        if(!m) {
            board[1][1] = 1;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 1) {
                        addObject((Actor) snakes.get(0), i * 20, j * 20);
                    }
                    if (board[i][j] == 2) {
                        addObject(new WallActor(), i * 20, j * 20);
                    }
                }

            }
        }
        else
        {
            board[1][1] = 1;

            board[5][5] = 3;
            spawn((snakes));
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 1)
                    {
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

    }
    public void spawn(ArrayList<Mover> list)
    {
        for(int x =0;x<list.size();x++)
        {
            if(x==0)
                addObject((Actor) list.get(x),20,20);
            if(x==1)
                addObject((Actor) list.get(x),760,20);
            if(x==2)
                addObject((Actor) list.get(x),20,560);
            if(x==3)
                addObject((Actor) list.get(x),760,560);
        }
    }
    public void act()
    {
        if(multiplayer) {
            Boolean ready=false;
            for (int i = 1;i<snakes.size();i++ )
            {
                if(!snakes.get(i).ready())
                    ready = true;
                else
                    ready = false;
                if(snakes.get(i).checkDead()) {
                    snakes.get(i).removeBody();
                    removeObject((Actor)snakes.get(i));
                    snakes.remove(i);
                    i--;
                }
                if(snakes.size()==2)
                    snakes.get(0).dead();
                else if(snakes.size()==1)
                    Mayflower.setWorld(new GameOver());

            }
            if(ready)
            {
                for(int i = 0; i<snakes.size();i++)
                {
                    if(snakes.get(i).equals(SnakeActor.class))
                    {
                        snakes.get(i).setCanMove(true);
                    }

                }
            }
        }
    }
}
