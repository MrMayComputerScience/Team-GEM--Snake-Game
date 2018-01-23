import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.Timer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InputManager extends Actor
{
<<<<<<< HEAD
    private AbstractGameModeManager gameModeManager;
    private HashMap<Integer,String> map;
=======
    private Timer toMove;
    private AbstractGameModeManager gameModeManager;
    private HashMap<Integer,String> map;
    private long testingTime;
    private long currentTime;
>>>>>>> 8fae832e9e7d966f019aacf0f40882f3d8b1f326

    public InputManager(AbstractGameModeManager gameModeManager1)
    {
        map = new HashMap<>();
        gameModeManager = gameModeManager1;

        map.put(Keyboard.KEY_W,"P1_UP");
        map.put(Keyboard.KEY_S,"P1_DOWN");
        map.put(Keyboard.KEY_A,"P1_LEFT");
        map.put(Keyboard.KEY_D,"P1_RIGHT");

        map.put(Keyboard.KEY_UP,"P2_UP");
        map.put(Keyboard.KEY_DOWN,"P2_DOWN");
        map.put(Keyboard.KEY_LEFT,"P2_LEFT");
        map.put(Keyboard.KEY_RIGHT,"P2_RIGHT");

        map.put(Keyboard.KEY_I,"P3_UP");
        map.put(Keyboard.KEY_K,"P3_DOWN");
        map.put(Keyboard.KEY_J,"P3_LEFT");
        map.put(Keyboard.KEY_L,"P3_RIGHT");

        map.put(Keyboard.KEY_T,"P4_UP");
        map.put(Keyboard.KEY_G,"P4_DOWN");
        map.put(Keyboard.KEY_H,"P4_LEFT");
        map.put(Keyboard.KEY_F,"P4_RIGHT");
<<<<<<< HEAD
=======

        toMove = new Timer(75);
        testingTime = System.currentTimeMillis();
>>>>>>> 8fae832e9e7d966f019aacf0f40882f3d8b1f326
    }
    @Override
    public void act()
    {
        Set<Integer> keys =map.keySet();
        for(Integer s:keys) {
            if (Mayflower.isKeyPressed(s))
            {
                gameModeManager.process(map.get(s));
            }
        }

    }
}
