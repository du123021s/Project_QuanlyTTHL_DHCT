package Controller;

import Data.JDBCutil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.Node;

import java.awt.*;
import java.awt.event.MouseEvent;
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

import static java.awt.Color.*;

public class LoginController implements Initializable {
    @FXML
    private Label label_thongbao;

    @FXML
    private TextField TxtUser;

    @FXML
    private TextField TxtPass;

    @FXML
    private Button btn_Signin;

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

        if (event.getSource() == btn_Signin) {
            //login here
            if (logIn().equals("Success")) {
                try {
                    Stage stage = (Stage)((Node) event.getSource()).getScence().getWindow();
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
            label_thongbao.setTextFill(color.red);
            label_thongbao.setText("Server Error : Check");
        } else {
            label_thongbao.setTextFill(color.GREEN);
            label_thongbao.setText("Server is up : Good to go");
        }
    }

    //we gonna use string to check for status
    private String logIn() {
        String status = "Success";
        String MemID = TxtUser.getText();
        String ManLoginPass = TxtPass.getText();
        if(MemID.isEmpty() || ManLoginPass.isEmpty()) {
            setLabel_thongbao(color.red, "Empty credentials");
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
                    setLabel_thongbao(color.red, "Enter Correct Email/Password");
                    status = "Error";
                } else {
                    setLabel_thongbao(color.GREEN, "Login Successful..Redirecting..");
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
