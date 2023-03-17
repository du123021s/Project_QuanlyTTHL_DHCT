package Controller;

import Data.JDBCutil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ComboBox;


public class LoginController implements Initializable {
    @FXML
    private Label label_thongbao;

    @FXML
    private TextField TxtUser;

    @FXML
    private PasswordField TxtPass;

    @FXML
    private Button btn_SignIn;


    // tạo combobox: lựa chọn mức độk đăng nhập user hay admin
    @FXML
    private ComboBox<String> combo_UserType;

    // thiết lập các trường items để sổ ra khi click vào combobox
    ObservableList<String> userTypeList = FXCollections.observableArrayList("Reader", "Admin");


    /// --
    Connection con =null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;



    // contructor

    public LoginController() {
       con = JDBCutil.ketnoi_JDBC();
    }


    @FXML
    public void handleButtonAction(MouseEvent event) {

        if (event.getSource() == btn_SignIn) {
            //login here
            if (logIn().equals("Success")) {
                try {
                    Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();

                    //Lấy giá trị của combobox
                    String userType = combo_UserType.getValue().toString();

                    Scene scene;
                    if (userType.equals("Reader")) { // Kiểm tra loại tài khoản từ giá trị combobox vừa lấy
                         scene = new Scene(FXMLLoader.load(getClass().getResource("/View/Reader.fxml")));
                    } else {
                        scene = new Scene(FXMLLoader.load(getClass().getResource("/View/Admin.fxml")));
                    }

                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }

            }
        }
    }



/*
* Trong JavaFX, Initializable là một interface được sử dụng để khởi tạo các thành phần giao diện người dùng sau khi chúng đã được tạo ra.
*  Interface này chứa một phương thức duy nhất initialize() được gọi khi tất cả các thành phần của giao diện người dùng đã được tạo.Khi một
* đối tượng của một lớp điều khiển (controller class) được tạo, nó được liên kết với một tệp FXML và được tạo ra bằng cách sử dụng
* FXMLLoader. Sau khi tất cả các thành phần được tạo ra, phương thức initialize() được gọi.
* */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (con == null) {
            label_thongbao.setTextFill(javafx.scene.paint.Paint.valueOf("#990000"));
            label_thongbao.setText("Server Error : Check");
        } else {
            label_thongbao.setTextFill(javafx.scene.paint.Paint.valueOf("#00CC00"));
            label_thongbao.setText("Server is up : Good to go");
        }

        // thiết lập các Item vừa khởi tạo cho vào combobox vữa tạo là combo_UserType ở interface initialize
        combo_UserType.setItems(userTypeList);
    }




    //Xây dựng method login
    private String logIn() {

        String userType = combo_UserType.getValue();
        String sql="";


        String status = "Success";
        String UserName = TxtUser.getText();
        String PassWord = TxtPass.getText();
        if(UserName.isEmpty() || PassWord.isEmpty()) {
            setLabel_thongbao(Color.valueOf("#990000"), "không được để trống UserName và PassWord!");
            status = "Error";
        } else {

            if(userType.equals("Reader")) {
                sql = "SELECT * FROM ReaderLogin WHERE ReaderID = ? AND ReadPass = ?";
            } else if(userType.equals("Admin")) {
                sql = "SELECT * FROM ManagerLogin WHERE MemID = ? AND ManLoginPass = ?";
            }
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, UserName);
                preparedStatement.setString(2, PassWord);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    setLabel_thongbao(Color.valueOf("#990000"), "lỗi đăng nhập: vui lòng kiểm tra UserName và Password của bạn!");
                    status = "Error";
                } else {
                    setLabel_thongbao(Color.valueOf("#00CC00"), "Yeah! mật khẩu và tên đăng nhập khớp rồi");
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }

        return status;
    }

    private void setLabel_thongbao(Color color, String text) {
        label_thongbao.setTextFill(color);
        label_thongbao.setText(text);
        System.out.println(text);
    }



}
