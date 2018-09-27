import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class test2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 400);

//创建一个矩形
        final Rectangle rect = new Rectangle(0, 0, 40, 40);
        rect.setArcHeight(10);
        rect.setArcWidth(10);
        rect.setFill(Color.RED);
//将矩形作为一个Node方到Parent中
        root.getChildren().add(rect);
//创建路径
        javafx.scene.shape.Path path = new javafx.scene.shape.Path();
        path.getElements().add(new MoveTo(20, 20));
        path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
        path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
//创建路径转变
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));//设置持续时间4秒
        pt.setPath(path);//设置路径
        pt.setNode(rect);//设置物体
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//设置周期性，无线循环
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);//自动往复
        pt.play();//启动动画

        arg0.setScene(scene);
        arg0.show();




    }
}
