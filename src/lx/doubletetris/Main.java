package lx.doubletetris;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// 程序主类
// 继承 javafx.application.Application 类
// 创建 JavaFX 应用程序基本骨架，展示场景，获取控制焦点
public class Main extends Application{
    public static void main(String[] args) {
        // 通过 Application 类定义的 launch() 方法启动 JavaFX 程序
        launch(args);   //
    }

    /**
     * JavaFX 应用程序必须是 javafx.application 包中 Application 类的子类。
     * Application 类定义了三个可被重写的方法，在 launch() 方法之后被调用。
     * 三个方法按执行顺序分别为 init(), start(), stop().
     * 其中 start() 为 abstract 方法必须进行重写。
     */

    public void start(Stage mainStage) {
        // 创建 Render 绘制器对象 re、GameController 游戏控制器对象 gc、KeyResponder 键盘相响应器对象 kr
        Renderer re = new Renderer();
        GameController gc = new GameController(re);
        KeyResponder kr = new KeyResponder(gc);   //

        /*
         * JavaFX 应用程序至少有一个 Stage（舞台） 和 一个 Scene（场景） 对象。
         * 要创建 JavaFX 程序，至少要在一个 Stage 中添加一个 Scene 对象。
         * Stage 是顶级容器，所有 JavaFX 程序都能自动访问一个 Stage 对象，这个对象称为 mainStage（主舞台）。
         * Scene 是组成场景元素的容器。
         */

        // 设置 mainStage 的标题和初始窗体口样式（StageStyle.TRANSPARENT 即隐藏窗体样式）
        mainStage.setTitle("Double Tetris");
        mainStage.initStyle(StageStyle.TRANSPARENT);   //

        /*
         * Scene 中的单独元素称为节点。
         * 节点可以由一组节点组成，节点可以有子节点。
         * 节点的集合构成整个场景。
         * 节点构成的场景具有树状结构，场景中存在根节点（顶级节点）。
         * 所有节点的基类是 Node 类，Parent、Group、Region、Control 等类派生自 Node 类。
         */

        // 创建 Group 对象 rootGroup，将 Canvas 绘制的对象添加到 Group 中
        Group rootGroup = new Group();
        rootGroup.getChildren().add(re);   //

        // 创建 Scene 对象 mainScene，将 Scene 添加到 mainStage 中，show() 方法显示 mainStage 和其中的 mainScene
        Scene mainScene = new Scene(rootGroup);
        mainStage.setScene(mainScene);
        mainStage.show();   //

        // rootGroup 请求焦点，添加键盘监听器 kr 到 rootGroup 中
        rootGroup.requestFocus();
        rootGroup.setOnKeyReleased(kr);   //
    }
}
