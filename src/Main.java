import javafx.application.Application;
import javafx.stage.Stage;
import mayflower.*;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        new Mayflower("Lab 3", 1024, 768,true) {
            @Override
            public void init() {
                setWorld(new gameScreen(new world(), new snake()));
            }
        };
    }


    public static void main(String[] args) {
        launch(args);
    }
}
