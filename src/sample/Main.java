package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("驾考试题管理系统");
        Scene scene = new Scene(root, 800, 800);
        scene.getStylesheets().add(this.getClass().getResource("display.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);//关闭放大
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
