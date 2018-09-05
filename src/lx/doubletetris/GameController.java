package lx.doubletetris;

import javafx.scene.paint.Color;

// 游戏控制器类
// 实现 ControllerInterface 接口
// 调用绘制器 re 完成图像绘制
// 创建 LogicController 对象 lc 完成程序游戏控制
class GameController implements ControlInterface {
    private static boolean isStart;
    private static boolean isPause;

    private static Renderer re;
    // 声明 LogicController 逻辑控制器对象 lc
    private LogicController lc;   //

    // 初始化，引用 Renderer 对象 re
    GameController(Renderer re_m){
        re = re_m;
    }

    // 静态方法，获取游戏是否开始的状态信息
    static boolean getIsStart() {
        return isStart;
    }

    // 静态方法，获取游戏是否暂停的状态
    static boolean getIsPause() {
        return isPause;
    }

    // 静态方法，设置游戏结束状态
    static void setGameOver() {
        isStart = false;
    }

    // 静态方法，重绘 Box 和 Block
    static void reRender(int[][] box_m, int[][] block0_m, int x0_m, int y0_m, Color color0_m, int[][] block1_m, int x1_m, int y1_m, Color color1_m) {
        re.startRender(Color.GRAY);
        re.boxRender(box_m, Color.SLATEGRAY);
        re.boxBorderRender(Color.GRAY);
        re.blockRender(block0_m, x0_m, y0_m, color0_m);
        re.blockRender(block1_m, x1_m, y1_m, color1_m);
    }

    // 静态方法，绘制方块预览界面
    static void blockPreviewRerender(int[][][] blocks_m, Color[] colors_m, int player_m) {
        re.blockPreviewRender(blocks_m, colors_m, player_m);
    }

    // 静态方法，绘制记分板
    static void scoreBoardRender(int score_m, int line_m, int level_m, Color color_m) {
        re.scoreBoardRender(score_m, line_m, level_m, color_m);
    }

    // 静态方法，绘制游戏暂停界面
    static void pauseRender(int[][] box_m, int[][] block0_m, int x0_m, int y0_m, int[][] block1_m, int x1_m, int y1_m) {
        re.startRender(Color.GREEN);
        re.boxRender(box_m, Color.GRAY);
        re.boxBorderRender(Color.GREEN);
        re.blockRender(block0_m, x0_m, y0_m, Color.GRAY);
        re.blockRender(block1_m, x1_m, y1_m, Color.GRAY);
        re.pauseRender();
    }

    // 静态方法，绘制游戏结束界面
    static void gameOverRender(int[][] box_m, int[][] block0_m, int x0_m, int y0_m, int[][] block1_m, int x1_m, int y1_m) {
        re.startRender(Color.RED);
        re.boxRender(box_m, Color.RED);
        re.boxBorderRender(Color.RED);
        re.blockRender(block0_m, x0_m, y0_m, Color.RED);
        re.blockRender(block1_m, x1_m, y1_m, Color.RED);
        re.gameOverRender();
    }

    @Override
    public void start() {
        if (!isStart) {
            isStart = true;
            isPause = false;
            // 每次游戏开始时创建新的 LogicController 对象
            lc = new LogicController();   //
            re.startRender(Color.GRAY);
            re.scoreBoardRender(0, 0, 1, Color.GRAY);
            lc.start();
        }
    }

    @Override
    public void pause() {
        if (isStart) {
            if (!isPause) {
                lc.pause();
                isPause = true;
            }
            else {
                lc.pause();
                isPause = false;
            }
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public void blockRotate(int player_m) {
        if (isStart && !isPause) {
            lc.blockRotate(player_m);
        }
    }

    @Override
    public void blockMoveLeft(int player_m) {
        if (isStart && !isPause) {
            lc.blockMoveLeft(player_m);
        }
    }

    @Override
    public void blockMoveRight(int player_m) {
        if (isStart && !isPause) {
            lc.blockMoveRight(player_m);
        }
    }

    @Override
    public void blockMoveDown(int player_m) {
        if (isStart && !isPause) {
            lc.blockMoveDown(player_m);
        }
    }

    @Override
    public void blockQuickMoveDown(int player_m) {
        if (isStart && !isPause) {
            lc.blockQuickMoveDown(player_m);
        }
    }

    // 弹出帮助信息
    void help() {
        if (isStart && !isPause) {
            pause();
        }

        re.helpInfo();
    }
}
