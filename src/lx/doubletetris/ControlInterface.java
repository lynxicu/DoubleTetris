package lx.doubletetris;

interface ControlInterface {
    void start();
    void pause();
    void exit();
    void blockRotate(int player_m);
    void blockMoveLeft(int player_m);
    void blockMoveRight(int player_m);
    void blockMoveDown(int player_m);
}
