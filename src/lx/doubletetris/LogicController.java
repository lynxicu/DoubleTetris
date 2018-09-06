/*
 * ********* 注意，该部分代码逻辑较为混乱
 */

package lx.doubletetris;

import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.paint.Color;

// 逻辑控制器类
// 实现 ControllerInterface 接口
// 储存基本游戏信息，完成游戏各项操作
class LogicController implements ControlInterface {
    private GameBox box;
    private Block[] block;
    private ScoreCounter sc;
    private int step;
    private Timer t;

    @Override
    public void start() {
        box = new GameBox();
        block = new Block[2];
        block[0] = new Block(0);
        block[1] = new Block(1);
        block[0].setBlockXY(randomX(0), 0);
        block[1].setBlockXY(randomX(1), 0);
        sc = new ScoreCounter();
        step = sc.getStep();
        t = new Timer();
        startTimer(t, step);
    }

    @Override
    public void pause() {
        if (!GameController.getIsPause()) {
            stopTimer();
            pauseRender();
        }
        else {
            reRender();
            t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    startTimer(t, step);
                }
            }, step);
        }
    }

    @Override
    public void exit() {
        stopTimer();
        gameOverRender();
        GameController.setGameOver();
    }

    @Override
    public void blockRotate(int player_m) {
        int[] xy = {block[player_m].getX(), block[player_m].getY()};

        if (isRotatable(xy, player_m)) {
            block[player_m].setBlockXY(xy[0], xy[1]);
            block[player_m].rotate();
            reRender();
        }
    }

    @Override
    public void blockMoveLeft(int player_m) {
        if (isLeftMovable(player_m)) {
            block[player_m].moveLeft();
            reRender();
        }
    }

    @Override
    public void blockMoveRight(int player_m) {
        if (isRightMovable(player_m)) {
            block[player_m].moveRight();
            reRender();
        }
    }

    @Override
    public void blockMoveDown(int player_m) {
        if (isDownMovable(player_m)) {
            block[player_m].moveDown();
            reRender();
        }
    }

    @Override
    public void blockQuickMoveDown(int player_m) {
        int j = GameBox._boxRow - block[player_m].getY();

        for (int i = 0; i < j; ++i) {
            blockMoveDown(player_m);
        }
    }

    // 检测方块是否能旋转
    private boolean isRotatable(int[] xy_m, int player_m) {
        boolean isRotatale = true;
        int[][] blockTmp = block[player_m].getBlockClone();
        Block.rotate(blockTmp);
        int moveX = 0;
        int moveY = 0;

        if (isOutLeftRight(blockTmp, xy_m[0])) {
            /*
             * 如果方块旋转后没有进行左对齐，需要启用该段代码，向右调整方块防止左越界检测数据溢出
             */
            /*int i;

            if (xy_m[0] < 0) {
                i = 1;
            }
            else {
                i = -1;
            }   */

            do {
                --moveX; // 下一行代码启用时禁用该行，下一行代码禁用时启用该行
                //moveX += i;   // 如果方块旋转后没有进行对齐，需要启用该行代码替换上一行代码，向右调整方块防止左越界检测数据溢出
                xy_m[0] += moveX;
            } while (isOutLeftRight(blockTmp, xy_m[0]));
        }

        if (isOutBottom(blockTmp, xy_m[1])) {
            do {
                --moveY;
                xy_m[1] += moveY;
            } while (isOutBottom(blockTmp, xy_m[1]));
        }

        int playerCheck = Math.abs(player_m - 1);
        int[][] boxTmp = box.getBoxClone();
        GameBox.setBlock(boxTmp, blockTmp, xy_m[0], xy_m[1]);
        GameBox.setBlock(boxTmp, block[playerCheck].getBlock(), block[playerCheck].getX(), block[playerCheck].getY());

        if (isCollision(boxTmp))
            isRotatale = false;

        return isRotatale;
    }

    // 检测方块是否能左移
    private  boolean isLeftMovable(int player_m) {
        boolean isLeftMovable = true;

        if (isOutLeftRight(block[player_m].getBlock(), block[player_m].getX() - 1)) {
            isLeftMovable = false;
        }

        if (isLeftMovable) {
            int playerCheck = Math.abs(player_m - 1);
            int[][] boxTmp = box.getBoxClone();
            GameBox.setBlock(boxTmp, block[player_m].getBlock(), block[player_m].getX() - 1, block[player_m].getY());
            GameBox.setBlock(boxTmp, block[playerCheck].getBlock(), block[playerCheck].getX(), block[playerCheck].getY());

            if (isCollision(boxTmp)) {
                isLeftMovable = false;
            }
        }

        return isLeftMovable;
    }

    // 检测方块是否能右移
    private boolean isRightMovable(int player_m) {
        boolean isRightMovable = true;

        if (isOutLeftRight(block[player_m].getBlock(), block[player_m].getX() + 1)) {
            isRightMovable = false;
        }

        if (isRightMovable) {
            int playerCheck = Math.abs(player_m - 1);
            int[][] boxTmp = box.getBoxClone();
            GameBox.setBlock(boxTmp, block[player_m].getBlock(), block[player_m].getX() + 1, block[player_m].getY());
            GameBox.setBlock(boxTmp, block[playerCheck].getBlock(), block[playerCheck].getX(), block[playerCheck].getY());

            if (isCollision(boxTmp)) {
                isRightMovable = false;
            }
        }

        return isRightMovable;
    }

    // 检测方块是否能下落
    private boolean isDownMovable(int player_m) {
        boolean isDownMovable = true;

        if (isOutBottom(block[player_m].getBlock(), block[player_m].getY() + 1)) {
            isDownMovable = false;
        }

        if (isDownMovable) {
            int playerCheck = Math.abs(player_m - 1);
            int[][] boxTmp = box.getBoxClone();
            GameBox.setBlock(boxTmp, block[player_m].getBlock(), block[player_m].getX(), block[player_m].getY() + 1);
            GameBox.setBlock(boxTmp, block[playerCheck].getBlock(), block[playerCheck].getX(), block[playerCheck].getY());

            if (isCollision(boxTmp)) {
                isDownMovable = false;
            }
        }

        return isDownMovable;
    }

    // 同时检测两个方块是否能下落
    private boolean isDownMovable() {
        boolean isDownMovable = true;

        if (isOutBottom(block[0].getBlock(), block[0].getY() + 1) || isOutBottom(block[1].getBlock(), block[1].getY() + 1)) {
            isDownMovable = false;
        }

        if (isDownMovable) {
            int[][] boxTmp = box.getBoxClone();
            GameBox.setBlock(boxTmp, block[0].getBlock(), block[0].getX(), block[0].getY() + 1);
            GameBox.setBlock(boxTmp, block[1].getBlock(), block[1].getX(), block[1].getY() + 1);

            if (isCollision(boxTmp)) {
                isDownMovable = false;
            }
        }

        return isDownMovable;
    }

    // 检测方块是否能放置
    private boolean isSettable(int player_m) {
        boolean isSettable = false;

        if (isOutBottom(block[player_m].getBlock(), block[player_m].getY() + 1)) {
            isSettable = true;
        }

        if (!isSettable) {
            int[][] boxTmp = box.getBoxClone();
            GameBox.setBlock(boxTmp, block[player_m].getBlock(), block[player_m].getX(), block[player_m].getY() + 1);

            if (isCollision(boxTmp)) {
                isSettable = true;
            }
        }

        return isSettable;
    }

    // 同时检测两个方块是否能放置
    private boolean isSettable() {
        boolean isSettable = false;

        if (isSettable(0) && isSettable(1)) {
            isSettable = true;
        }

        if (!isSettable) {
            if (isSettable(0)) {
                int[][] boxTmp = box.getBoxClone();
                GameBox.setBlock(boxTmp, block[0].getBlock(), block[0].getX(), block[0].getY());
                GameBox.setBlock(boxTmp, block[1].getBlock(), block[1].getX(), block[1].getY() + 1);

                if (isCollision(boxTmp)) {
                    isSettable = true;
                }
            }
            if (isSettable(1)) {
                int[][] boxTmp = box.getBoxClone();
                GameBox.setBlock(boxTmp, block[0].getBlock(), block[0].getX(), block[0].getY() + 1);
                GameBox.setBlock(boxTmp, block[1].getBlock(), block[1].getX(), block[1].getY());

                if (isCollision(boxTmp)) {
                    isSettable = true;
                }
            }
        }

        return isSettable;
    }

    // 检测新方块的坐标是否冲突
    private boolean isPathImpact(int x_m, int player_m) {
        boolean isPathImpact = false;

        if (isOutLeftRight(block[player_m].getBlock(), x_m)) {
            isPathImpact = true;
        }

        if (!isPathImpact) {
            int playerCheck = Math.abs(player_m - 1);

            if (block[playerCheck].getY() < Block._blockRow) {
                int[][] boxTmp = box.getBoxClone();
                GameBox.setBlock(boxTmp, block[player_m].getBlock(), x_m, 0);
                GameBox.setBlock(boxTmp, block[playerCheck].getBlock(), block[playerCheck].getX(), block[playerCheck].getY());

                if (isCollision(boxTmp)) {
                    isPathImpact = true;
                }
            }
        }

        return isPathImpact;
    }

    // 检测方块是否超出左右边界
    private boolean isOutLeftRight(int[][] block_m, int x_m) {
        boolean isOutLeftRight = false;

        if (x_m < 0) {
            x_m = Math.abs(x_m);

            for (int col = 0; col < x_m; ++col) {
                for (int row = 0; row < Block._blockRow; ++row) {
                    if (0 != block_m[row][col]) {
                        isOutLeftRight = true;
                        break;
                    }
                }
            }
        }
        else if (x_m > GameBox._boxCol - Block._blockCol) {
            x_m = GameBox._boxCol - x_m;

            for (int col = Block._blockCol - 1; col >= x_m; --col) {
                for (int row = 0; row < Block._blockRow; ++row) {
                    if (0 != block_m[row][col]) {
                        isOutLeftRight = true;
                        break;
                    }
                }
            }
        }

        return isOutLeftRight;
    }

    // 检测方块是否超出下边界
    private boolean isOutBottom(int[][] block_m, int y_m) {
        boolean isOutBottom = false;

        if (y_m > GameBox._boxRow - Block._blockRow) {
            y_m = GameBox._boxRow - y_m;

            for (int row = Block._blockRow - 1; row >= y_m; --row) {
                for (int col = 0; col < Block._blockCol; ++col) {
                    if (0 != block_m[row][col]) {
                        isOutBottom = true;
                        break;
                    }
                }
            }
        }

        return isOutBottom;
    }

    // 检测方块是否碰撞
    private boolean isCollision(int[][] box_m) {
        boolean isCollision = false;

        for (int row = 0; row < GameBox._boxRow; ++row) {
            for (int col = 0; col < GameBox._boxCol; ++col) {
                if (box_m[row][col] > 1) {
                    isCollision = true;
                }
            }
        }

        return isCollision;
    }

    // 随机生成新方块的 x 坐标
    private int randomX(int player_m) {
        int x;

        do {
            x = ((int) (Math.random() * (GameBox._boxCol)));
        } while (isPathImpact(x, player_m));

        return x;
    }

    // 启动定时器控制游戏
    private void startTimer(Timer t_m, int step_m) {
        t_m.schedule(new TimerTask() {
            @Override
            public void run() {
                boolean isOver = false;
                int[] player = null;

                // 检测方块是否能放置，并进行放置操作
                if (isSettable()) {
                    player = new int[]{0, 1};
                }
                else if (isSettable(0)) {
                    player = new int[]{0};
                }
                else if (isSettable(1)) {
                    player = new int[]{1};
                }   //

                // 方块放置后生成新方块
                if (null != player) {
                    for (int i : player) {
                        box.setBlock(block[i].getBlock(), block[i].getX(), block[i].getY());

                        if (block[i].getY() >= Block._blockRow) {
                            block[i].newBlock(i);
                            block[i].setBlockXY(randomX(i), 0);
                            reRender();
                        } else {
                            isOver = true;
                            this.cancel();
                            exit();
                        }
                    }
                }   //

                if (!isOver) {
                    // 方块下落
                    if (isDownMovable()) {
                        block[0].moveDown();
                        block[1].moveDown();
                    }
                    else if (isDownMovable(0) && !isDownMovable(1)) {
                        block[0].moveDown();
                    }
                    else if (!isDownMovable(0) && isDownMovable(1)) {
                        block[1].moveDown();
                    }   //

                    reRender();
                    //消除方块，统计得分，调整游戏速度
                    int line = box.clear();

                    if (0 != line) {
                        reRender();
                        sc.count(line);
                        int stepTmp = sc.getStep();

                        if (stepTmp != step_m) {
                            this.cancel();
                            stopTimer();
                            t = new Timer();
                            startTimer(t, stepTmp);
                        }
                    }   //
                }
            }
        }, 0, step_m);
    }

    // 停止定时器
    private void stopTimer() {
        t.cancel();
        t.purge();
    }

    // 重绘 Box 和 Block，重绘方块预览界面，重绘记分板
    private void reRender() {
        GameController.reRender(box.getBox(), block[0].getBlock(), block[0].getX(), block[0].getY(), block[0].getColor(), block[1].getBlock(), block[1].getX(), block[1].getY(), block[1].getColor());
        GameController.blockPreviewRerender(block[0].getBlocks(), block[0].getColors(), 0);
        GameController.blockPreviewRerender(block[1].getBlocks(), block[1].getColors(), 1);
        GameController.scoreBoardRender(sc.getScore(), sc.getLine(), sc.getLevel(), Color.GRAY);
    }

    // 绘制游戏暂停界面
    private void pauseRender() {
        GameController.pauseRender(box.getBox(), block[0].getBlock(), block[0].getX(), block[0].getY(), block[1].getBlock(), block[1].getX(), block[1].getY());
        Color[] colors = {Color.GRAY, Color.GRAY, Color.GRAY};
        GameController.blockPreviewRerender(block[0].getBlocks(), colors, 0);
        GameController.blockPreviewRerender(block[1].getBlocks(), colors, 1);
        GameController.scoreBoardRender(sc.getScore(), sc.getLine(), sc.getLevel(), Color.GREEN);
    }

    // 绘制游戏结束界面
    private void gameOverRender() {
        GameController.gameOverRender(box.getBox(), block[0].getBlock(), block[0].getX(), block[0].getY(), block[1].getBlock(), block[1].getX(), block[1].getY());
        Color[] colors = {Color.RED, Color.RED, Color.RED};
        GameController.blockPreviewRerender(block[0].getBlocks(), colors, 0);
        GameController.blockPreviewRerender(block[1].getBlocks(), colors, 1);
        GameController.scoreBoardRender(sc.getScore(), sc.getLine(), sc.getLevel(), Color.RED);
    }
}

// 盒子类
// 储存游戏盒子中的方块信息
class GameBox {
    final static int _boxRow = 20 + Block._blockRow;
    final static int _boxCol = 24;

    private int[][] box;

    // 初始化盒子
    GameBox() {
        box = new int[_boxRow][_boxCol];
    }

    // 获取可修改的盒子信息（即 Box 二维数组的引用）
    int[][] getBox() {
        return box;
    }

    // 获取盒子信息副本
    int[][] getBoxClone() {
        int[][] boxTmp = new int[_boxRow][_boxCol];

        for (int row = 0; row < _boxRow; ++row) {
            System.arraycopy(box[row], 0, boxTmp[row], 0, _boxCol);
        }

        return boxTmp;
    }

    // 放置方块
    void setBlock(int[][] block_m, int x_m, int y_m) {
        setBlock(box, block_m, x_m, y_m);
    }

    // 静态方法，放置方块，实现不同参数的方块放置
    static void setBlock(int[][] box_m, int[][] block_m, int x_m, int y_m) {
        for (int row = 0; row < Block._blockRow; ++row) {
            for (int col = 0; col < Block._blockCol; ++col) {
                if (1 == block_m[row][col]) {
                    box_m[y_m + row][x_m + col] += 1;
                }
            }
        }
    }

    // 消除盒子中满足条件的方块，获取一次消除的行数
    int clear() {
        int clearRow = 0;

        for (int row = _boxRow - 1; row >= 0; --row) {
            boolean isFull = true;

            for (int col = 0; col < _boxCol; ++col) {
                if (0 == box[row][col]) {
                    isFull = false;
                    break;
                }
            }

            if (isFull) {
                for (int moveRow = row; moveRow > 0; --moveRow) {
                    System.arraycopy(box[moveRow - 1], 0, box[moveRow], 0, _boxCol);
                }

                ++row;
                ++clearRow;
            }
        }

        return clearRow;
    }
}

// 方块类
// 储存方块信息
class Block {
    final static int _blockRow = 4;
    final static int _blockCol = 4;

    private BlockSet blockSet;
    private int[][][] block;
    private Color[] color;
    private int x;
    private int y;

    // 初始化方块
    Block(int player_m) {
        blockSet = new BlockSet();
        block = new int[3][_blockRow][_blockCol];
        block[0] = blockSet.getBlock((int)(Math.random() * BlockSet._blockAmount));
        block[1] = blockSet.getBlock((int)(Math.random() * BlockSet._blockAmount));
        block[2] = blockSet.getBlock((int)(Math.random() * BlockSet._blockAmount));
        color = new Color[3];
        color[0] = blockSet.getBlockColor((int)(Math.random() * BlockSet._blockColorAmount[player_m]), player_m);
        color[1] = blockSet.getBlockColor((int)(Math.random() * BlockSet._blockColorAmount[player_m]), player_m);
        color[2] = blockSet.getBlockColor((int)(Math.random() * BlockSet._blockColorAmount[player_m]), player_m);
    }

    // 更新方块
    void newBlock(int player_m) {
        block[0] = block[1];
        block[1] = block[2];
        block[2] = blockSet.getBlock((int)(Math.random() * BlockSet._blockAmount));
        color[0] = color[1];
        color[1] = color[2];
        color[2] = blockSet.getBlockColor((int)(Math.random() * BlockSet._blockColorAmount[player_m]), player_m);
    }

    // 设置方块坐标
    void setBlockXY(int x_m, int y_m) {
        x = x_m;
        y = y_m;
    }

    // 获取可修改的当前方块信息（即 Block[] 二维数组的引用）
    int[][] getBlock() {
        return block[0];
    }

    // 获取可修改的方块组信息（即 Block 三维数组的引用）
    int[][][] getBlocks() {
        return block;
    }

    // 获取当前方块信息副本
    int[][] getBlockClone() {
        int[][] blockTmp = new int[_blockRow][_blockCol];

        for (int row = 0; row < _blockRow; ++row) {
            System.arraycopy(block[0][row], 0, blockTmp[row], 0, _blockCol);
        }

        return blockTmp;
    }

    // 获取当前方块的颜色信息
    Color getColor() {
        return color[0];
    }

    // 获取方块组的颜色信息
    Color[] getColors() {
        return color;
    }

    // 获取当前方块 x 坐标
    int getX() {
        return x;
    }

    // 获取当前方块 y 坐标
    int getY() {
        return y;
    }

    // 旋转当前方块
    void rotate() {
        rotate(block[0]);
    }

    // 静态方法，旋转方块，实现不同参数的方块旋转
    static void rotate(int[][] block_m) {
        int length = block_m.length;

        // 顺时针 90 度旋转二维数组
        for (int row = 0; row < length / 2; ++row) {
            int pos = length - row - 1;

            for (int col = row; col < pos; ++col) {
                int tmp = block_m[row][col];
                block_m[row][col] = block_m[pos - col + row][row];
                block_m[pos - col + row][row] = block_m[pos][pos - col + row];
                block_m[pos][pos - col + row] = block_m[col][pos];
                block_m[col][pos] = tmp;
            }
        }   //

        // 在方块旋转后进行左对齐
        int emptyLine = 0;

        for (int row = 0; row < _blockRow - 1; ++row) {
            boolean isEmpty = true;

            for (int col = 0; col < _blockCol; ++col) {
                if (1 == block_m[row][col]) {
                    isEmpty = false;
                    break;
                }
            }

            if (isEmpty) {
                ++emptyLine;
            }
            else {
                break;
            }
        }

        if (0 != emptyLine) {
            for (int row = 0; row < _blockRow - emptyLine; ++row) {
                System.arraycopy(block_m[row + emptyLine], 0, block_m[row], 0, _blockCol);
            }

            for (int row = _blockRow - 1; row >= _blockRow - emptyLine; --row) {
                System.arraycopy(new int[_blockCol], 0, block_m[row], 0, _blockCol);
            }
        }

        emptyLine = 0;

        for (int col = 0; col < _blockCol - 1; ++col) {
            boolean isEmpty = true;

            for (int row = 0; row < _blockRow; ++row) {
                if (1 == block_m[row][col]) {
                    isEmpty = false;
                    break;
                }
            }

            if (isEmpty) {
                ++emptyLine;
            }
            else {
                break;
            }
        }

        if (0 != emptyLine) {
            for (int col = 0; col < _blockCol - emptyLine; ++col) {
                for (int row = 0; row < _blockRow; ++row) {
                    block_m[row][col] = block_m[row][col + emptyLine];
                }
            }

            for (int col = _blockRow - 1; col >= _blockCol - emptyLine; --col) {
                for (int row = 0; row < _blockRow; ++row) {
                    block_m[row][col] = 0;
                }
            }
        }   // 在方块旋转后进行左对齐
    }

    // 当前方块向左移动 1 格
    void moveLeft() {
        x -= 1;
    }

    // 当前方块向右移动 1 格
    void moveRight() {
        x += 1;
    }

    // 当前方块向下移动 1 格
    void moveDown() {
        y += 1;
    }
}

// 计分类
// 储存得分信息，计算得分，调整游戏速度
class ScoreCounter {
    private int score;
    private int line;
    private int level;
    private int step;

    // 初始化得分信息与游戏速度信息
    ScoreCounter() {
        score = 0;
        line = 0;
        level = 1;
        step = 1000;
    }

    // 获取得分
    int getScore() {
        return score;
    }

    // 获取消除行数
    int getLine() {
        return line;
    }

    // 获取等级
    int getLevel() {
        return level;
    }

    // 获取游戏速度
    int getStep() {
        return step;
    }

    // 计算得分与调整游戏速度
    void count(int line_m) {
        line += line_m;
        score += 5 * (line_m * line_m + line_m);   // 分数计算公式：5 * (n * n + n)

        if (level < 10) {
            level += line_m;
        }
        else if (level > 10) {
            level = 10;
        }

        step = 1100 - level * 100;
    }
}
