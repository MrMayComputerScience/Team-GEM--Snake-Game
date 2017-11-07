
import mayflower.*;

public class Lab5Runner extends Mayflower
{
    public Lab5Runner()
    {
        super("test",800,600);

    }

    public Lab5Runner(String title, int width, int height) {
        super(title, width, height);
    }

    @Override
    public void init()
    {
        Mayflower.setWorld(new gameScreen(new world(), new snake()));
    }
    public static void main(String[] args) {
        new Main();
    }
}
