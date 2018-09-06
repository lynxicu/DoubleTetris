package lx.doubletetris;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

// 键盘响应器类
// 继承 javafx.event.EventHandler 类
// 响应对应按键，实现游戏控制
class KeyResponder implements EventHandler<KeyEvent> {
    private GameController gc;

    // 初始化，引用 GameController 对象 gc
    KeyResponder(GameController gc_m){
        gc = gc_m;
    }

    @Override
    public void handle(KeyEvent ke_m) {
        // consume() 方法防止键盘事件继续传播
        ke_m.consume();

        // 根据对应按键调用游戏控制器
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
            case SHIFT:
                gc.blockQuickMoveDown(0);
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
            case CONTROL:
                gc.blockQuickMoveDown(1);
                break;
        }   // 根据对应按键调用游戏控制器
    }
}
