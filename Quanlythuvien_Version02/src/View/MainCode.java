package View;

import Controller.MyController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainCode extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
/*
        try{
            // link đg dẫn source code chạy giao diện MainVirew.fxml
            Parent root = FXMLLoader.load(MainCode.class.getResource("MainView.fxml"));
            // hoặc viết gọn:  Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

            // chạy kích thước hiển th giao diện
            Scene scene = new Scene(root);

            // dẫn link file css
           // scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());


            // hiển thị giao diện lên cửa sổ chính, này tự this.setVissible(true) bên swing
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
*/

        try {
            // link đg dẫn file đuôi .fxml vào .fxml như là swing jfraem vậy còn controller đi theo gióng như chức năng khởi tạo tính năng cho chtrinh
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
            //load sourd code kịch bản của file .fxml vào
            MyController myController = new MyController();
            // lk gắn kịch bản vào file  .fxml
            loader.setController(myController);

            // load tên thẻ pane bên giao diện bên thiết kế scenbuilder vào để nó hiểu và chạy đc code
            Pane root = loader.load();

            // tạo kích thước hển thị giao diện
            Scene scene = new Scene(root);

            // hiển thị giao diện lên cửa sổ chính, này tự this.setVissible(true) bên swing
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
