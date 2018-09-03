package lx.doubletetris;

// 接口类
// 游戏基本操作接口
interface ControlInterface {
    // 游戏开始
    void start();
    // 游戏暂停
    void pause();
    // 游戏退出/结束
    void exit();
    // 方块旋转
    void blockRotate(int player_m);
    // 方块左移
    void blockMoveLeft(int player_m);
    // 方块右移
    void blockMoveRight(int player_m);
    // 方块下落
    void blockMoveDown(int player_m);
    // 方块快速下落
    void blockQuickMoveDown(int player_m);
}
