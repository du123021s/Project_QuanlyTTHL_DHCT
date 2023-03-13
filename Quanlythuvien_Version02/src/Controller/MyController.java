package Controller;

import View.MainCode;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MyController implements Initializable {

    //subPane_Header tên cu giao diện khi ấn plus (+) sẽ chuyển qua
    @FXML
    private AnchorPane subPane_Header;

    // khởi tạo tên id cho smenu nguon
    @FXML
    private AnchorPane subMenu_Option;

    // khởi tạo  tên id cho sub pane HomePage
    @FXML
    private AnchorPane Pane_Home;

    // khởi tạo tên id cho submenu_Student
    @FXML
    private AnchorPane Pane_Student;
    //khởi tạo tên cho Pane_menuBook
    @FXML
    private AnchorPane Pane_BookManager;





    //btn_add chính là tên code của nút "+" khi ấn chuyển giao diện
    @FXML
    private JFXButton btn_add;

    // tạo nút chuyển quay lại
    @FXML
    private JFXButton btn_back;

    // thiết lập tên id nút nguồn
    @FXML
     private JFXButton btn_Option;

    // thiết tên nút quay lại của sub menu nguồn
    @FXML
    private JFXButton btn_option_back;
    // thiết lập tên các nút JFX button HomePage
    @FXML
    private JFXButton btn_HomePage;
    // thiết lập tên các nút JFX button Student
    @FXML
    private JFXButton btn_Student;
    // khởi tạo tên JFXbuuton: nút BookManager
    @FXML
    private JFXButton btn_Book;



    // xây dựng method xử lý ẩn hiện các sub menu nguồn, menu header...
    @FXML
    void chuyenGiaoDien_Header(ActionEvent event) {
        if(event.getSource() == btn_add){
            // khi ấn nút giao diện submenu sẽ chạy
            subPane_Header.setVisible(true);
            // toFront gigiuspchuyeenr sang giao diện ở phía trước
             subPane_Header.toFront();
        }else if(event.getSource() == btn_back){
            subPane_Header.setVisible(false);
            /*Main_View.toFront();*/
        }else if(event.getSource() == btn_Option){
            if(subMenu_Option.visibleProperty().getValue() == true){
                subMenu_Option.setVisible(false);
            }else {
                subMenu_Option.setVisible(true);
            }

            /*giải thích về thuộc tính VisibleProperty:
            *1/Thuộc tính "visible" trong Java là một thuộc tính của một đối tượng (object)
            *2/Thuộc tính này quy định trạng thái hiển thị của đối tượng đó trên giao diện người dùng.(true: hiển thị false thì ẩn)
            *3/ Trong đoạn code trên, khi "subMenu_Option.visibleProperty().getValue() == true", nghĩa là thuộc tính "visible" của đối
            *  tượng "subMenu_Option" đang được đặt là "true", tức là đối tượng đang hiển thị trên giao diện người dùng. Do đó, nó sẽ
            * thực hiện lệnh "subMenu_Option.setVisible(false);" để ẩn menu con đó đi
            *
            * 4/ Tương tự, nếu thuộc tính "visible" của đối tượng "subMenu_Option" đang được đặt là "false", nghĩa là đối tượng đang bị
            *  ẩn trên giao diện người dùng. Khi đó, nó sẽ thực hiện lệnh "subMenu_Option.setVisible(true);" để đặt thuộc tính "visible"
            * của đối tượng này về "true", từ đó hiển thị đối tượng trở lại trên giao diện người dùng.
            *  */


            // thực hiện tiếp chức năng chuyển sub_menu: homepage và Student
        }else if(event.getSource()==btn_HomePage){
            Pane_Home.toFront();
        }else if(event.getSource() == btn_Student){
            Pane_Student.setVisible(true);
            Pane_Student.toFront();
        }else if(event.getSource() == btn_Book){
            Pane_BookManager.setVisible(true);
            Pane_BookManager.toFront();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
