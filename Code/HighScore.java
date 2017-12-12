
import mayflower.*;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class HighScore extends World
{
    private Properties properties;

    public HighScore(Properties p)
    {
        properties = p;

        RainbowLabel highScores = new RainbowLabel("HighScores",40);
        addObject(highScores,300,25);
        Label title = new Label("Press t to return to title page.",40);
        addObject(title,100,500);
        int x = 300;
        int y = 500;
        ArrayList<String> scores= new ArrayList<String>();
        try {
            Scanner in = new Scanner(new FileReader("score.txt"));
            StringBuilder sb = new StringBuilder();
            while(in.hasNext())
            {
                scores.add(in.next());
            }
            in.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        //sorting by number
        Collections.sort(scores, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return extractInt(o1) - extractInt(o2);
            }

            int extractInt(String s) {
                String num = s.replaceAll("\\D", "");
                // return 0 if no digits found
                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
        });

        for(int i = 0;i<scores.size();i++)
        {
            Label label =new Label(scores.get(i),30);
            addObject(label,x,y-40);
            y = y-40;
        }
    }
    @Override
    public void act()
    {
        if(Mayflower.isKeyPressed(Keyboard.KEY_T))
        {
            System.out.println("t");
            Mayflower.setWorld(new TitleWorld(properties));
        }
    }
}
