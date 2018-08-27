package lx.doubletetris;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{
    public static void main(String[] args) {
        Application.launch();
    }

    public void start(Stage mainStage) {
        mainStage.setTitle("Double Tetris");
        mainStage.initStyle(StageStyle.TRANSPARENT);

        EventHandler event = new EventHandler();

        Group rootGroup = new Group();
        rootGroup.getChildren().add(event.renderer());

        Scene mainScene = new Scene(rootGroup);
        mainStage.setScene(mainScene);
        mainStage.show();

        rootGroup.requestFocus();
        rootGroup.setOnKeyReleased(event.responder());
    }
}
