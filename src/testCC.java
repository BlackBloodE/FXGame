import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

public class testCC extends Application {



    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();


        Group circles = new Group();
        javafx.scene.shape.Path path = new javafx.scene.shape.Path();
        for (int i = 0; i < 10 ; i++){
            Circle circle = new Circle(50+i,50,50, Color.web("black"));
            //circle.setStrokeType(StrokeType.OUTSIDE);
            //circle.setStroke(Color.web("white", 0.16));
            //circle.setStrokeWidth(4);
            circles.getChildren().add(circle);
        }
        root.getChildren().add(circles);
        Scene scene = new Scene(root, 1280, 720);
        primaryStage.setScene(scene);
        path.getElements().add(new MoveTo(640, 20));
        path.getElements().add(new LineTo(640, 500.0f));
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(400));//设置持续时间4秒
        pt.setPath(path);//设置路径
        pt.setNode(circles);//设置物体
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//设置周期性，无线循环
        pt.setCycleCount(Timeline.INDEFINITE);
        //pt.setAutoReverse(true);//自动往复
        pt.play();//启动动画




        primaryStage.show();

    }
    public static void main(String[] args)
    {
        launch(args);
    }
}

