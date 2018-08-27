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
        Renderer re = new Renderer();
        GameController gc = new GameController(re);
        KeyResponder kr = new KeyResponder(gc);

        mainStage.setTitle("Double Tetris");
        mainStage.initStyle(StageStyle.TRANSPARENT);

        Group rootGroup = new Group();
        rootGroup.getChildren().add(re);

        Scene mainScene = new Scene(rootGroup);
        mainStage.setScene(mainScene);
        mainStage.show();

        rootGroup.requestFocus();
        rootGroup.setOnKeyReleased(kr);
    }
}
