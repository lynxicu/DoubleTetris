package lx.doubletetris;

import javafx.scene.paint.Color;

class GameController implements ControlInterface {
    private static boolean isStart;
    private static boolean isPause;

    private static Renderer re;
    private static LogicController lc;

    GameController(Renderer re_m, LogicController lc_m){
        re = re_m;
        lc = lc_m;
    }

    static boolean getIsStart() {
        return isStart;
    }

    static boolean getIsPause() {
        return isPause;
    }

    static void setGameOver() {
        isStart = false;
        re.gameOverRender();
    }

    static void reRender(int[][] box_m, int[][] block0_m, int x0_m, int y0_m, Color color0_m, int[][] block1_m, int x1_m, int y1_m, Color color1_m) {
        re.boxRender(box_m, Color.SLATEGRAY);
        re.blockRender(block0_m, x0_m, y0_m, color0_m);
        re.blockRender(block1_m, x1_m, y1_m, color1_m);
    }

    static void previewRerender() {

    }

    private void blockRender(int[][] block_m, int x_m, int y_m, Color color_m) {
        re.blockRender(block_m, x_m, y_m, color_m);
    }

    private void blockPreviewRender(int[][][] blocks_m,Color[] colors_m) {
        re.blockPreviewRender(blocks_m, colors_m);
    }

    @Override
    public void start() {
        isStart = true;
        re.startRender();
        lc.start();
    }

    @Override
    public void pause() {
        if (isStart) {
            isPause = !isPause;
            lc.pause();
            if (isPause) {
                re.pauseRender();
            } else {
                //re.boxRender();
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
