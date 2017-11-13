/**
 * Created by s581467 on 11/7/2017.
 */
import java.util.*;

import com.sun.org.apache.xpath.internal.operations.Bool;
import mayflower.*;

public class SnakeWorld extends World {

    int[][] board = new int[40][30];

    public SnakeWorld(){
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
        board[1][1] = 1;
        SnakeActor snake = new SnakeActor();
        for(int i=0; i<board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == 1) {
                    addObject(snake, i * 20, j * 20);
                }
                if (board[i][j] == 2) {
                    addObject(new WallActor(), i * 20, j * 20);
                }
            }

        }

        List<Actor> obj = getObjects();
        PointActor point = new PointActor();

       if(!(obj.contains(point)))
        {
            board[point.getRow()][point.getCol()] = 3;
        }

        for(int i=0; i<board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == 3)
                {
                    addObject(point, i * 20, j * 20);
                }
            }

        }
    }

    public void act()
    {
        List<Actor> test = getObjects();
        Boolean point = false;
        PointActor pointActor = new PointActor();
        for(Actor t: test)
        {
            if(t.equals(pointActor))
                point = true;

        }
        //if(!point)
          //  addObject(pointActor,pointActor.getRow()*20,pointActor.getCol()*20);
    }
}
