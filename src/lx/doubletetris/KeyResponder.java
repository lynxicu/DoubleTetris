package lx.doubletetris;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyResponder implements EventHandler<KeyEvent> {
    private GameController gc;

    KeyResponder(GameController gc_m){
        gc = gc_m;
    }

    @Override
    public void handle(KeyEvent ke_m) {
        ke_m.consume();

        switch (ke_m.getCode()) {
            case ENTER:
                gc.start();
                break;
            case ESCAPE:
                gc.exit();
                break;
            case P:
                gc.pause();
                break;
            case I:
                gc.help();
                break;
            case W:
                gc.blockRotate(0);
                break;
            case A:
                gc.blockMoveLeft(0);
                break;
            case D:
                gc.blockMoveRight(0);
                break;
            case S:
                gc.blockMoveDown(0);
                break;
            case UP:
                gc.blockRotate(1);
                break;
            case LEFT:
                gc.blockMoveLeft(1);
                break;
            case RIGHT:
                gc.blockMoveRight(1);
                break;
            case DOWN:
                gc.blockMoveDown(1);
                break;
        }
    }
}
