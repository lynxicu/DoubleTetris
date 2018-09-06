## Changelogs

* #### alpha 6 commit

    * ###### 小修小补

* #### alpha 5 commit -> alpha 5 release

    * ###### 修改 Shift / Ctrl 键控制方块快速下落的逻辑
    
    * ###### 添加代码注释

* #### alpha 4 commit

    * ###### 添加 Shift / Ctrl 键控制方块快速下落
    
    * ###### Bug List：
    
        - [ ] 反复重新开始游戏导致程序卡死或定时器无限循环（定时器间隔低于 10 ms 可复现）

* #### alpha 3 commit -> alpha 3 release

    * ###### 修改定时器的方块下落和放置逻辑
    
    * ###### Bug List：
    
        - [x] （_已修复 / alpha 4 commit_）游戏暂停后再次恢复会立即对所有方块进行一次移动
    
        - [x] （_重新提交 / alpha 4 commit_）极端情况下反复重新开始游戏导致程序卡死或定时器无限循环
    
        - [ ] 由于反复重新开始游戏后未知情况导致的 javafx 无法绘制，缓冲区溢出（定时器间隔低于 10 ms 可复现）：
        
        `java.nio.BufferOverFlowException`
        
        - [ ] 由于反复重新开始游戏后未知情况导致的类型转换异常 （正常情况下有几率复现）：
        
        `java.lang.ClassCastException: com.sun.javafx.font.PrismFont cannot be cast to com.sun.prism.paint.Paint`
        
        `java.lang.ClassCastException: com.sun.prism.paint.Color cannot be cast to com.sun.javafx.font.PGFont`
        
        `java.lang.ClassCastException: com.sun.prism.paint.Color cannot be cast to java.lang.String`
        
        - [ ] 由于反复重新开始游戏后未知情况导致的 javafx 异常（正常情况下有几率复现）：
        
        `java.lang.InternalError: Unrecognized PGCanvas token: 68`
        
    * ###### Hope List: 
    
        - [ ] 添加音效与背景音乐（8 Bit）（_大坑待填_）

* #### alpha 2 commit

    * ###### 小修小补

* #### alpha commit -> alpha release
    
    * ###### 游戏操作基本实现
    
    * ###### Bug List：
    
        - [x] （_已修复 / alpha 3 commit_）计分存在异常
        
        - [x] （_已修复 / alpha 3 commit_）方块下落次序不同的碰撞检测导致方块延时下落
        
        - [ ] 方块旋转的碰撞检测部分存在异常
        
        - [x] （_已修复 / alpha 3 commit_）未知情况导致游戏无法暂停
        
        - [x] （_重新提交 / alpha 3 commit_）未知情况导致的类型转换异常：
        
        `java.lang.ClassCastException: com.sun.prism.paint.Color cannot be cast to com.sun.javafx.font.PGFont`
        
    * ###### Hope List: 
    
        - [x] （_未实现，已替换功能 / alpha 5 commit_）长按移动对应按键实现方块快速移动（目前使用 setOnKeyRelease 进行键盘事件监听, 仅能实现单次按键单次移动）
        
        - [ ] 方块沿中心点旋转
        
        - [ ] 方块在界面以外时快速移动到界面内

* #### init commit

    * ###### 基本框架
    
    * ###### 测试
