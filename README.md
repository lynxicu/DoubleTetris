# Double Tetris / 双人俄罗斯方块

简单实现了俄罗斯方块的基本游戏操作. 

图形绘制：使用 [javafx.scene.canvas](https://docs.oracle.com/javase/10/docs/api/javafx/scene/canvas/package-summary.html) 实现 2D 图形的绘制。使用Timer定时器以及触发条件进行绘制，容易出现“掉帧”的情况。 

逻辑处理：核心是使用坐标和二维数组定位下落方块，同时在二维数组中进行碰撞检测。然而，这部分代码逻辑相当混乱。

算法无力，智商归零，不知猴年马月继续填坑。_(:3」∠)_

## Environment

* JDK 8u181

* IntelliJ IDEA 2018.2 (Community Edition)

## Changlogs

* #### alpha commit -> alpha release
    
    * ###### 游戏操作基本实现
    
    * ###### 已知 bugs 列表：
    
        1. 计分存在异常
        
        1. 方块下落次序不同的碰撞检测导致方块延时下落
        
        1. 方块旋转的碰撞检测部分存在异常
        
        1. 未知情况导致游戏无法暂停
        
        1. 未知情况导致的类型转换异常：
        
        `java.lang.ClassCastException: com.sun.prism.paint.Color cannot be cast to com.sun.javafx.font.PGFont`
        
    * ###### 待实现功能列表: 
    
        - [ ] 长按移动对应按键实现方块快速移动（目前使用 setOnKeyRelease 进行键盘事件监听, 仅能实现单次按键单次移动）
        
        - [ ] 方块沿中心点旋转
        
        - [ ] 方块在界面以外时快速移动到界面内

* #### init commit

    * ###### 基本框架
    
    * ###### 测试
