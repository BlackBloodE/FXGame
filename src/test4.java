import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class test4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1280, 720);

//创建一个矩形
        Group circles = new Group();
        for (int i = 0; i < 10 ; i++){
            Circle circle = new Circle(25 , Color.web("while"));
            circles.getChildren().add(circle);
        }
        root.getChildren().add(circles);

        final Circle cc = new Circle(25);
//        rect.setArcHeight(10);
//        rect.setArcWidth(10);
        cc.setFill(Color.RED);
//将矩形作为一个Node方到Parent中
        root.getChildren().add(cc);
//创建路径
        javafx.scene.shape.Path path = new javafx.scene.shape.Path();
        path.getElements().add(new MoveTo(640, 20));
        path.getElements().add(new LineTo(640, 500.0f));
        //path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
//创建路径转变
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(400));//设置持续时间4秒
        pt.setPath(path);//设置路径
        pt.setNode(cc);//设置物体
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//设置周期性，无线循环
        pt.setCycleCount(Timeline.INDEFINITE);
        //pt.setAutoReverse(true);//自动往复
        pt.play();//启动动画

        arg0.setScene(scene);
        arg0.show();




    }
}
