import mayflower.Actor;
import mayflower.Mayflower;
import mayflower.Timer;

public class TimerActor extends Actor
{
    private long testingTime;
    private long currentTime;
    private long speed;
    private Timer toMove;
    private AbstractGameModeManager gameModeManager;
    public TimerActor(AbstractGameModeManager abstractGameModeManager)
    {
        speed = 75000000;
        currentTime = System.nanoTime();
        gameModeManager = abstractGameModeManager;
        toMove = new Timer(75);
    }
    @Override
    public void act()
    {
        long elapsedTime = System.nanoTime()-testingTime;
        if(elapsedTime>speed) {
            gameModeManager.process("Tick");

            testingTime = System.nanoTime();
        }
    }
    public void instantiate()
    {
        testingTime = System.nanoTime();
        toMove = new Timer(75);
    }
}
