package lx.doubletetris;

import javafx.scene.paint.Color;

class GameController implements ControlInterface {
    private static boolean isStart;
    private static boolean isPause;

    private static Renderer re;
    private LogicController lc;

    GameController(Renderer re_m){
        re = re_m;
    }

    static boolean getIsStart() {
        return isStart;
    }

    static boolean getIsPause() {
        return isPause;
    }

    static void setGameOver() {
        isStart = false;
    }

    static void reRender(int[][] box_m, int[][] block0_m, int x0_m, int y0_m, Color color0_m, int[][] block1_m, int x1_m, int y1_m, Color color1_m) {
        re.startRender(Color.GRAY);
        re.boxRender(box_m, Color.SLATEGRAY);
        re.boxBorderRender(Color.GRAY);
        re.blockRender(block0_m, x0_m, y0_m, color0_m);
        re.blockRender(block1_m, x1_m, y1_m, color1_m);
    }

    static void blockPreviewRerender(int[][][] blocks_m, Color[] colors_m, int player_m) {
        re.blockPreviewRender(blocks_m, colors_m, player_m);
    }

    static void scoreBoardRender(int score_m, int line_m, int level_m, Color color_m) {
        re.scoreBoardRender(score_m, line_m, level_m, color_m);
    }

    static void pauseRender(int[][] box_m, int[][] block0_m, int x0_m, int y0_m, int[][] block1_m, int x1_m, int y1_m) {
        re.startRender(Color.GREEN);
        re.boxRender(box_m, Color.GRAY);
        re.boxBorderRender(Color.GREEN);
        re.blockRender(block0_m, x0_m, y0_m, Color.GRAY);
        re.blockRender(block1_m, x1_m, y1_m, Color.GRAY);
        re.pauseRender();
    }

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
            lc = new LogicController();
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
            } else {
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
        if (isStart && !isPause)
            lc.blockRotate(player_m);
    }

    @Override
    public void blockMoveLeft(int player_m) {
        if (isStart && !isPause)
            lc.blockMoveLeft(player_m);
    }

    @Override
    public void blockMoveRight(int player_m) {
        if (isStart && !isPause)
            lc.blockMoveRight(player_m);
    }

    @Override
    public void blockMoveDown(int player_m) {
        if (isStart && !isPause)
            lc.blockMoveDown(player_m);
    }

    void help() {
        if (isStart && !isPause)
            pause();

        re.helpInfo();
    }
}
