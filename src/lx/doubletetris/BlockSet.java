package lx.doubletetris;

import javafx.scene.paint.Color;

class BlockSet {
    final static int _blockAmount = 28;
    final static int _blockColorAmount[] = {7, 7};

    private int block[][][] = {
        /*
            I 型方块
         */
        {
            {1,0,0,0},
            {1,0,0,0},
            {1,0,0,0},
            {1,0,0,0}
        }, {
            {1,1,1,1},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
        }, {   // 重复方块 平衡概率
            {1,0,0,0},
            {1,0,0,0},
            {1,0,0,0},
            {1,0,0,0}
        }, {
            {1,1,1,1},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
        },
        /*
            J 型方块
         */
        {
            {0,1,0,0},
            {0,1,0,0},
            {1,1,0,0},
            {0,0,0,0}
        }, {
            {1,0,0,0},
            {1,1,1,0},
            {0,0,0,0},
            {0,0,0,0}
        }, {
            {1,1,0,0},
            {1,0,0,0},
            {1,0,0,0},
            {0,0,0,0}
        }, {
            {1,1,1,0},
            {0,0,1,0},
            {0,0,0,0},
            {0,0,0,0}
        },
        /*
            L 型方块
         */
        {
            {0,0,1,0},
            {1,1,1,0},
            {0,0,0,0},
            {0,0,0,0}
        }, {
            {1,0,0,0},
            {1,0,0,0},
            {1,1,0,0},
            {0,0,0,0}
        }, {
            {1,1,0,0},
            {0,1,0,0},
            {0,1,0,0},
            {0,0,0,0}
        }, {
            {1,1,1,0},
            {1,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
        },
        /*
            O 型方块
         */
        {
            {1,1,0,0},
            {1,1,0,0},
            {0,0,0,0},
            {0,0,0,0}
        }, {   // 重复方块 平衡概率
            {1,1,0,0},
            {1,1,0,0},
            {0,0,0,0},
            {0,0,0,0}
        }, {
            {1,1,0,0},
            {1,1,0,0},
            {0,0,0,0},
            {0,0,0,0}
        }, {
            {1,1,0,0},
            {1,1,0,0},
            {0,0,0,0},
            {0,0,0,0}
        },
        /*
            S 型方块
         */
        {
            {0,1,1,0},
            {1,1,0,0},
            {0,0,0,0},
            {0,0,0,0}
        }, {
            {1,0,0,0},
            {1,1,0,0},
            {0,1,0,0},
            {0,0,0,0}
        }, {   // 重复方块 平衡概率
            {0,1,1,0},
            {1,1,0,0},
            {0,0,0,0},
            {0,0,0,0}
        }, {
            {1,0,0,0},
            {1,1,0,0},
            {0,1,0,0},
            {0,0,0,0}
        },
        // T 型方块
        {
            {0,1,0,0},
            {1,1,0,0},
            {0,1,0,0},
            {0,0,0,0}
        }, {
            {0,1,0,0},
            {1,1,1,0},
            {0,0,0,0},
            {0,0,0,0}
        }, {
            {1,0,0,0},
            {1,1,0,0},
            {1,0,0,0},
            {0,0,0,0}
        }, {
            {1,1,1,0},
            {0,1,0,0},
            {0,0,0,0},
            {0,0,0,0}
        },
        /*
            Z 型方块
         */
        {
            {0,1,0,0},
            {1,1,0,0},
            {1,0,0,0},
            {0,0,0,0}
        }, {
            {1,1,0,0},
            {0,1,1,0},
            {0,0,0,0},
            {0,0,0,0}
        }, {   // 重复方块 平衡概率
            {0,1,0,0},
            {1,1,0,0},
            {1,0,0,0},
            {0,0,0,0}
        }, {
            {1,1,0,0},
            {0,1,1,0},
            {0,0,0,0},
            {0,0,0,0}
        }
    };

    private Color blockColor[][] = {
        {
            Color.RED,
            Color.ORANGERED,
            Color.GOLD,
            Color.LIME,
            Color.AQUA,
            Color.BLUE,
            Color.PURPLE
        },
        {
            Color.LIGHTCORAL,
            Color.LIGHTSALMON,
            Color.ORANGE,
            Color.YELLOWGREEN,
            Color.LIGHTSEAGREEN,
            Color.LIGHTSKYBLUE,
            Color.MEDIUMPURPLE
        }
    };

    int[][] getBlock(int index_m) {
        int[][] blockTmp = new int[Block._blockRow][Block._blockCol];

        for (int row = 0; row < Block._blockRow; ++row) {
            System.arraycopy(block[index_m][row], 0, blockTmp[row], 0, Block._blockCol);
        }

        return blockTmp;
    }

    Color getBlockColor(int index_m, int player_m) {
        return blockColor[player_m][index_m];
    }
}
