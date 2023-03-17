package Controller;

import Data.JDBCutil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;


import static java.awt.Color.*;

public class LoginController implements Initializable {
    @FXML
    private Label label_thongbao;

    @FXML
    private TextField TxtUser;

    @FXML
    private PasswordField TxtPass;

    @FXML
    private Button btn_SignIn;

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
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/View/MainView.fxml")));
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }

            }
        }
    }

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
    }

    //we gonna use string to check for status
    private String logIn() {
        String status = "Success";
        String MemID = TxtUser.getText();
        String ManLoginPass = TxtPass.getText();
        if(MemID.isEmpty() || ManLoginPass.isEmpty()) {
            setLabel_thongbao(Color.valueOf("#990000"), "Empty credentials");
            status = "Error";
        } else {
            //query
            String sql = "SELECT * FROM ManagerLogin Where MemID = ? and  ManLoginPass= ?";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, MemID);
                preparedStatement.setString(2, ManLoginPass);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    setLabel_thongbao(Color.valueOf("#990000"), "Enter Correct Email/Password");
                    status = "Error";
                } else {
                    setLabel_thongbao(Color.valueOf("#00CC00"), "Login Successful..Redirecting..");
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
