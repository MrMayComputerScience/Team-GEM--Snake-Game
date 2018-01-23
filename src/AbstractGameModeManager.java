import java.util.List;

abstract class AbstractGameModeManager
{
    List<SnakeActor> snakes;
    SnakeWorld World;

    public List<SnakeActor> getSnakes() {
        return snakes;
    }

    public SnakeActor getSnake(int index)
    {
        return snakes.get(index);
    }

    public SnakeWorld getWorld() {
        return World;
    }

    public void addSnakes(SnakeActor snake) {
        snakes.add(snake);
    }

    public void setWorld(SnakeWorld world) {
        World = world;
    }
    public abstract void process(String action);
}
