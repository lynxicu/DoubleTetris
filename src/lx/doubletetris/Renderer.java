package lx.doubletetris;

import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

class Renderer extends Canvas {
    private final static int _canvasWidth = 1200;
    private final static int _canvasHeight = 760;//zanding
    private final int _canvasBorder = 1;
    private final int _blockWidth = 30;
    private final int _blockHeight = 30;
    private final int _arcSize = 10;
    private final int _border = 2;
    private final int _boxWidth = GameBox._boxCol * (_blockWidth + _border + 1) + _border + 1;
    private final int _boxHeight = (GameBox._boxRow - Block._blockRow) * (_blockWidth + _border + 1) + _border + 1;
    private final int _boxX = 200;
    private final int _boxY = 32;
    private final int _statusBarWidth = 132;
    private final int _statusBarHeight = 45;
    private final int _statusBarX = _boxX + 100;
    private final int _statusBarY = _boxY + 100;
    
    private GraphicsContext gc = getGraphicsContext2D();

    Renderer() {
        super(_canvasWidth, _canvasHeight);
        canvasBorderRender(Color.BLACK);
        canvasMainRender();
    }

    private void canvasBorderRender(Color color) {
        gc.setStroke(color);
        gc.setLineWidth(_canvasBorder);
        gc.strokeRect(0,0, _canvasWidth, _canvasHeight);
    }

    private void canvasMainRender() {
        gc.setStroke(Color.RED);
        gc.setLineWidth(_border);
        gc.strokeRoundRect(100, 199, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(100, 232, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(100, 265, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(133, 265, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.setStroke(Color.ORANGERED);
        gc.strokeRoundRect(166, 364, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(199, 331, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(199, 364, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(232, 364, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.setStroke(Color.GOLD);
        gc.strokeRoundRect(100, 496, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(133, 496, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(166, 496, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(199, 496, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.setStroke(Color.LIME);
        gc.strokeRoundRect(331, 298, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(364, 298, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(364, 331, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(397, 331, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.setStroke(Color.AQUA);
        gc.strokeRoundRect(232, 232, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(232, 265, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(265, 232, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(265, 265, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.setStroke(Color.BLUE);
        gc.strokeRoundRect(265, 463, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(298, 397, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(298, 430, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(298, 463, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.setStroke(Color.PURPLE);
        gc.strokeRoundRect(397, 463, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(397, 496, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(430, 496, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(430, 529, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.setStroke(Color.LIGHTCORAL);
        gc.strokeRoundRect(727, 364, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(760, 364, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(793, 364, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(793, 397, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.setStroke(Color.LIGHTSALMON);
        gc.strokeRoundRect(529, 199, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(529, 232, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(562, 199, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(595, 199, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.setStroke(Color.ORANGE);
        gc.strokeRoundRect(892, 430, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(892, 463, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(925, 430, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(925, 463, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.setStroke(Color.YELLOWGREEN);
        gc.strokeRoundRect(859, 166, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(859, 199, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(859, 232, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(859, 265, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.setStroke(Color.LIGHTSEAGREEN);
        gc.strokeRoundRect(430, 100, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(463, 100, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(463, 133, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(496, 100, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.setStroke(Color.LIGHTSKYBLUE);
        gc.strokeRoundRect(496, 430, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(529, 397, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(529, 430, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(562, 397, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.setStroke(Color.MEDIUMPURPLE);
        gc.strokeRoundRect(991, 331, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(991, 364, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(1024, 298, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(1024, 331, _blockWidth, _blockHeight, _arcSize, _arcSize);

        gc.setStroke(Color.SLATEGRAY);
        int[] empty = {
                (int)(Math.random() * 30),
                (int)(Math.random() * 30),
                (int)(Math.random() * 30),
                (int)(Math.random() * 30),
                (int)(Math.random() * 30)
        };

        for (int i = 0; i < 30; ++i) {
            if (i != empty[0] && i != empty[1] && i != empty[2])
                gc.strokeRoundRect(100 + i * (_blockWidth + _border), 600, _blockWidth, _blockHeight, _arcSize, _arcSize);
            if (i != empty[3] && i != empty[4])
                gc.strokeRoundRect(100 + i * (_blockWidth + _border), 633, _blockWidth, _blockHeight, _arcSize, _arcSize);
        }

        Timer t = new Timer();

        t.schedule(new TimerTask() {
            boolean isDisplay = true;

            @Override
            public void run() {
                if (!GameController.getIsStart()) {
                    if (isDisplay) {
                        isDisplay = false;
                        gc.setFill(Color.WHITE);
                        gc.fillRect(64, 32, 300, 80);
                        gc.setFill(Color.BLACK);
                        gc.setFont(Font.font(32));
                        gc.fillText("Double Tetris\n   双人俄罗斯方块", 64, 64);
                        gc.setFont(Font.font(24));
                        gc.fillText("按 Enter 键开始游戏\n按 I 键查看帮助信息", 600, 300);
                    }
                    else {
                        isDisplay = true;
                        gc.setFill(Color.WHITE);
                        gc.fillRect(64, 32, 300, 80);
                        gc.fillRect(600, 276, 220, 60);
                        gc.setFill(Color.BLACK);
                        gc.setFont(Font.font(32));
                        gc.fillText("   Double Tetris\n双人俄罗斯方块", 64, 64);
                    }
                }
                else
                    cancel();
            }
        }, 0, 300);
    }

    void startRender() {
        canvasBorderRender(Color.SLATEGRAY);
        gc.setFill(Color.WHITE);
        gc.fillRect(_canvasBorder, _canvasBorder, _canvasWidth - 2 * _canvasBorder, _canvasHeight - 2 * _canvasBorder);
        boxBorderRender(Color.SLATEGRAY);
    }

    void boxBorderRender(Color color_m) {
        gc.setStroke(color_m);
        gc.setLineWidth(_border);
        gc.strokeRoundRect(_boxX, _boxY, _boxWidth, _boxHeight, _arcSize, _arcSize);
    }

    void boxRender(int[][] box_m, Color color_m) {
        gc.setFill(Color.WHITE);
        gc.fillRect(_boxX + _border, _boxY + _border, _boxWidth - 2 * _border, _boxHeight - 2 * _border);
        gc.setStroke(Color.SLATEGRAY);
        gc.setLineWidth(_border);

        for (int row = Block._blockRow; row < GameBox._boxRow; ++row)
            for (int col = 0; col < GameBox._boxCol; ++col)
                if (1 == box_m[row][col])
                    gc.strokeRoundRect(_boxX + _border + col * (_blockWidth + _border + 1), _boxY + _border + (row - Block._blockRow) * (_blockHeight + _border + 1), _blockWidth, _blockHeight, _arcSize, _arcSize);
    }

    void blockRender(int[][] block_m, int x_m, int y_m, Color color_m) {
        gc.setStroke(color_m);
        gc.setLineWidth(_border);

        for (int row = 0; row < Block._blockRow; ++row)
            for (int col = 0; col < Block._blockCol; ++col)
                if (1 == block_m[row][col] && row + y_m >= Block._blockRow)
                    gc.strokeRoundRect(_boxX + _border + (col + x_m) * (_blockWidth + _border + 1), _boxY + _border + (row + y_m - Block._blockRow) * (_blockHeight + _border + 1), _blockWidth, _blockHeight, _arcSize, _arcSize);
    }

    void blockPreviewRender(int[][][] blocks_m, Color[] colors_m) {

    }

    void scoreBoardRender() {

    }

    void pauseRender() {
        canvasBorderRender(Color.GREEN);
        boxBorderRender(Color.GREEN);
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(_border);
        gc.strokeRoundRect(_statusBarX, _statusBarY, _statusBarWidth, _statusBarHeight, _arcSize, _arcSize);
        gc.setFill(Color.WHITE);
        gc.fillRect(_statusBarX + _border, _statusBarY + _border, _statusBarWidth - 2 * _border, _statusBarHeight - 2 * _border);
        gc.setFill(Color.GREEN);
        gc.setFont(Font.font(32));
        gc.fillText("游戏暂停", _statusBarX + _border, _statusBarY + _border + 32);
    }

    void gameOverRender() {
        canvasBorderRender(Color.RED);
        boxBorderRender(Color.RED);
        gc.setStroke(Color.RED);
        gc.setLineWidth(_border);
        gc.strokeRoundRect(_statusBarX, _statusBarY, _statusBarWidth, _statusBarHeight, _arcSize, _arcSize);
        gc.setFill(Color.WHITE);
        gc.fillRect(_statusBarX + _border, _statusBarY + _border, _statusBarWidth - 2 * _border, _statusBarHeight - 2 * _border);
        gc.setFill(Color.RED);
        gc.setFont(Font.font(32));
        gc.fillText("游戏结束", _statusBarX + _border, _statusBarY + _border + 32);
    }

    void helpInfo() {
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Help Info");
        info.setHeaderText("按 Enter 键开始游戏\n按 P 键暂停/恢复游戏\n按 Esc 键退出游戏");
        info.setContentText(
            "Player 1:\n按 A 键向左移动方块\n按 D 键向右移动方块\n按 W 键旋转方块\n按 S 键加速方块\n" +
            "Player 2:\n按 ← 键向左移动方块\n按 → 键向右移动方块\n按 ↑ 键旋转方块\n按 ↓ 键加速方块");
        info.show();
    }
}
