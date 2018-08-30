package lx.doubletetris;

import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

class Renderer extends Canvas {
    private final static int _canvasWidth = 1250;
    private final static int _canvasHeight = 750;
    private final int _border = 1;
    private final int _blockWidth = 30;
    private final int _blockHeight = 30;
    private final int _blockBorder = 3;
    private final int _arcSize = 12;
    private final int _boxWidth = GameBox._boxCol * (2 * _border + _blockWidth + _blockBorder) + _blockBorder + 3 * _border;
    private final int _boxHeight = (GameBox._boxRow - Block._blockRow) * (2 * _border + _blockWidth + _blockBorder) + _blockBorder + 3 * _border;
    private final int _boxX = 200;
    private final int _boxY = 20;
    private final int _statusWidth = 132;
    private final int _statusHeight = 45;
    private final int _statusX = _boxX + 200;
    private final int _statusY = _boxY + 200;
    
    private GraphicsContext gc = getGraphicsContext2D();

    Renderer() {
        super(_canvasWidth, _canvasHeight);
        canvasBorderRender(Color.BLACK);
        canvasMainRender();
    }

    private void canvasBorderRender(Color color) {
        gc.setStroke(color);
        gc.setLineWidth(_border);
        gc.strokeRect(0,0, _canvasWidth, _canvasHeight);
    }

    private void canvasMainRender() {
        gc.setStroke(Color.RED);
        gc.setLineWidth(_blockBorder);
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
        gc.strokeRoundRect(562, 430, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(595, 397, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(595, 430, _blockWidth, _blockHeight, _arcSize, _arcSize);
        gc.strokeRoundRect(628, 397, _blockWidth, _blockHeight, _arcSize, _arcSize);
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
                gc.strokeRoundRect(100 + i * (_blockWidth + _blockBorder), 600, _blockWidth, _blockHeight, _arcSize, _arcSize);
            if (i != empty[3] && i != empty[4])
                gc.strokeRoundRect(100 + i * (_blockWidth + _blockBorder), 633, _blockWidth, _blockHeight, _arcSize, _arcSize);
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

    void startRender(Color color_m) {
        gc.clearRect(0, 0, _canvasWidth, _canvasHeight);
        canvasBorderRender(color_m);
    }

    void boxRender(int[][] box_m, Color color_m) {
        gc.clearRect(_boxX, _boxY, _boxWidth, _boxHeight);
        gc.setStroke(color_m);
        gc.setLineWidth(_blockBorder);

        for (int row = Block._blockRow; row < GameBox._boxRow; ++row)
            for (int col = 0; col < GameBox._boxCol; ++col)
                if (1 == box_m[row][col])
                    gc.strokeRoundRect(_boxX + 2 * _border + col * (2 * _border + _blockWidth + _blockBorder) + _blockBorder, _boxY + 2 * _border + (row - Block._blockRow) * (2 * _border + _blockHeight + _blockBorder) + _blockBorder, _blockWidth, _blockHeight, _arcSize, _arcSize);
    }

    void boxBorderRender(Color color_m) {
        gc.setStroke(color_m);
        gc.setLineWidth(_border);
        gc.strokeRoundRect(_boxX, _boxY, _boxWidth, _boxHeight, _arcSize, _arcSize);
    }

    void blockRender(int[][] block_m, int x_m, int y_m, Color color_m) {
        gc.setStroke(color_m);
        gc.setLineWidth(_blockBorder);

        for (int row = 0; row < Block._blockRow; ++row)
            for (int col = 0; col < Block._blockCol; ++col)
                if (1 == block_m[row][col] && row + y_m >= Block._blockRow)
                    gc.strokeRoundRect(_boxX + 2 * _border + (col + x_m) * (2 * _border + _blockWidth + _blockBorder) + _blockBorder, _boxY + 2 * _border + (row + y_m - Block._blockRow) * (2 * _border + _blockHeight + _blockBorder) + _blockBorder, _blockWidth, _blockHeight, _arcSize, _arcSize);
    }

    void blockPreviewRender(int[][][] blocks_m, Color[] colors_m, int player_m) {
        final int[] _previewX = {30, 30 + _boxX + _boxWidth + _border};
        final int _previewY = 30;

        gc.clearRect(_previewX[player_m], _previewY, 4 * (2 * _border + _blockWidth + _blockBorder) + _blockBorder, 12 * (2 * _border + _blockHeight + _blockBorder) + _blockBorder);
        gc.setLineWidth(_blockBorder);

        for (int i = 0; i < 3; ++i) {
            gc.setStroke(colors_m[2 - i]);

            for (int row = 0; row < Block._blockRow; ++row) {
                for (int col = 0; col < Block._blockCol; ++col) {
                    if (1 == blocks_m[2 - i][row][col]) {
                        gc.strokeRoundRect(_previewX[player_m] + col * (2 * _border + _blockWidth + _blockBorder) + _blockBorder, _previewY + (row + i * 5) * (2 * _border + _blockHeight + _blockBorder) + _blockBorder, _blockWidth, _blockHeight, _arcSize, _arcSize);
                    }
                }
            }
        }
    }

    void scoreBoardRender(int score_m, int line_m, int level_m, Color color_m) {
        final int _scoreX1 = 30;
        final int _scoreX2 = 30 + _boxX + _boxWidth + _border;
        final int _scoreY = 660;
        final int _scoreWidth = 120;
        final int _scoreHeight = 30;

        gc.clearRect(_scoreX1, _scoreY, _scoreWidth, 2 * _scoreHeight);
        gc.clearRect(_scoreX2, _scoreY, _scoreWidth, 2 * _scoreHeight);
        gc.setFill(color_m);
        gc.setFont(Font.font(24));
        gc.fillText("Score: " + score_m, _scoreX1, _scoreY);
        gc.fillText("Line: " + line_m, _scoreX1, _scoreY + _scoreHeight);
        gc.fillText("Level: " + level_m, _scoreX2, _scoreY + _scoreHeight);
    }

    void pauseRender() {
        gc.setFill(Color.WHITE);
        gc.fillRect(_statusX + _border, _statusY + _border, _statusWidth - 2 * _border, _statusHeight - 2 * _border);
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(_border);
        gc.strokeRoundRect(_statusX, _statusY, _statusWidth, _statusHeight, _arcSize, _arcSize);
        gc.setFill(Color.GREEN);
        gc.setFont(Font.font(32));
        gc.fillText("游戏暂停", _statusX + _border, _statusY +  _border + 32);
    }

    void gameOverRender() {
        gc.setFill(Color.WHITE);
        gc.fillRect(_statusX + _border, _statusY + _border, _statusWidth - 2 * _border, _statusHeight - 2 * _border);
        gc.setStroke(Color.RED);
        gc.setLineWidth(_border);
        gc.strokeRoundRect(_statusX, _statusY, _statusWidth, _statusHeight, _arcSize, _arcSize);
        gc.setFill(Color.RED);
        gc.setFont(Font.font(32));
        gc.fillText("游戏结束", _statusX + _border, _statusY + _border + 32);
    }

    void helpInfo() {
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Help Info");
        info.setHeaderText("按 Enter 键开始/重新开始游戏\n按 P 键暂停/恢复游戏\n按 Esc 键退出游戏");
        info.setContentText(
            "Player 1:\n按 A 键向左移动方块\n按 D 键向右移动方块\n按 W 键旋转方块\n按 S 键向下移动方块，Shift 键加速方块\n" +
            "\nPlayer 2:\n按 ← 键向左移动方块\n按 → 键向右移动方块\n按 ↑ 键旋转方块\n按 ↓ 键向下移动方块，Ctrl 键加速方块\n" +
            "\n计分规则：\n连续消除 1 / 2 / 3 / 4 / 5 / 6 / 7 / 8 行\n" +
            "分别获得 10 / 30 / 60 / 100 / 150 / 210 / 280 / 360 分\n" +
            "等级提升 1 / 2 / 3 / 4 / 5 / 6 / 7 / 8 级\n" +
            "方块下落速度将会随等级提升，最高等级为 10 级");
        info.show();
    }
}
