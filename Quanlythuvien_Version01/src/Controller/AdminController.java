package Controller;

import Data.JDBCutil;
import Model.ReaderModel;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.converter.StringConverter;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class AdminController implements Initializable {

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
    // nút logut của menu option
    @FXML
    private JFXButton btn_LogOut;


    // định nghi các nút button trong giao diện student manager
    @FXML
    private Button btn_ReaderLogin;

    @FXML
    private Button btn_ReaderTable;

    @FXML
    private AnchorPane subPane_Reader;

    @FXML
    private AnchorPane subPane_ReaderLogin;


    //tableview javafx
    @FXML
    private TableView<ReaderModel> table_reader;

    @FXML
    private TableColumn<ReaderModel,String> column_ID;
    @FXML
    private TableColumn<ReaderModel,String> column_EmpID;
    @FXML
    private TableColumn<ReaderModel,String> column_Name;
    @FXML
    private TableColumn<ReaderModel,String> column_Gender;
    @FXML
    private TableColumn<ReaderModel, Date> column_Birth;
    @FXML
    private TableColumn<ReaderModel,String> column_Address;
    @FXML
    private TableColumn<ReaderModel, Integer> column_Phone;
    @FXML
    private TableColumn<ReaderModel,Date> column_RDate;
    @FXML
    private TableColumn<ReaderModel,Date> column_DDate;
    @FXML
    private TableColumn<ReaderModel,String> column_Barcode;


    // combobox
    @FXML
    private ComboBox<String> combobox_Gender;
    // thiết lập các trường items để sổ ra khi click vào combobox
    ObservableList<String> typeList = FXCollections.observableArrayList("Male", "Female");

    // định nghĩa tên  datePicker
    @FXML
    private DatePicker datePicker1;
    @FXML
    private DatePicker datePicker2;
    @FXML
    private DatePicker datePicker3;




    // xây dựng method xử lý ẩn hiện các sub menu nguồn, menu header...chuyển đổi qua lại các giao diện
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
            // code ntn để lúc nào chạy ctrinh đầu tiên cũng sẽ load Anchopane HomePage trc tiên
            Pane_Home.toFront();
        }else if(event.getSource() == btn_Student){
            Pane_Student.setVisible(true);
            Pane_Student.toFront();
        }else if(event.getSource() == btn_Book){
            Pane_BookManager.setVisible(true);
            Pane_BookManager.toFront();
        }
    }



    // method xử lý các nut của menu Option
    @FXML
    void LogoutAction(ActionEvent event) {
        if (event.getSource() == btn_LogOut) {
            //login her
                try {
                    Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/View/Log_In.fxml")));
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
        }
    }




    // xây dựng chuyển giao diện trong Anchopane studentManager
    @FXML
    void changeButtonStudentManagement(ActionEvent event) {
       if(event.getSource()==btn_ReaderTable){
           subPane_Reader.setVisible(true);
           subPane_Reader.toFront();
       }else if(event.getSource()==btn_ReaderLogin){
           subPane_ReaderLogin.setVisible(true);
           subPane_ReaderLogin.toFront();
       }
    }




    /* xây dựng method load sql table Reader trong sql lên giao diện javafx*/
     // lấy dl từ sql
   public ObservableList<ReaderModel> AddReaderTable(){
        ObservableList<ReaderModel> ListData = FXCollections.observableArrayList();
         Connection conect = JDBCutil.ketnoi_JDBC();

        try{
            String sql = "select * from Reader";
            PreparedStatement prepare = conect.prepareStatement(sql);
             ResultSet rs = prepare.executeQuery();
            while(rs.next()){
                // hàm này load dl trực tiếp tử sq
//                ReaderModel readerModel = new ReaderModel(
//                        rs.getString("ReaderID"), rs.getString("EmpID"),
//                        rs.getString("ReaderName"), rs.getDate("DateOfBirth"),
//                        rs.getString("ReaderGender"), rs.getString("ReaderAddress"),
//                        rs.getInt("ReaderPhone"),
//                        rs.getDate("RegistrationDate"), rs.getDate("DeadlineDate"),
//                        rs.getString("ReaderBarCode"), rs.getString("ReaderImage")
//                );
                ReaderModel readerModel = new ReaderModel();

                readerModel.setReaderid(rs.getString("ReaderID"));
                readerModel.setEmpid(rs.getString("EmpID"));
                readerModel.setReadername(rs.getString("ReaderName"));
                readerModel.setBirth(rs.getDate("DateOfBirth"));
                readerModel.setGender(rs.getString("ReaderGender"));
                readerModel.setAddress(rs.getString("ReaderAddress"));
                readerModel.setPhone(rs.getInt("ReaderPhone"));
                readerModel.setRegistrationdate(rs.getDate("RegistrationDate"));
                readerModel.setDeadlinedate(rs.getDate("DeadlineDate"));
                readerModel.setBarcode(rs.getString("ReaderBarCode"));


                ListData.add(readerModel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       return ListData;
   }

      // load dl từ sql đưa lên table view

    private ObservableList<ReaderModel> ListshowData;
   public void showReaderTable(){
       // hàm này nhận dl từ sql thiết đặt cho readerModel ở các hàm get set
       ListshowData = AddReaderTable();
       column_ID.setCellValueFactory(new PropertyValueFactory<>("readerid"));
       column_EmpID.setCellValueFactory(new PropertyValueFactory<>("empid"));
       column_Name.setCellValueFactory(new PropertyValueFactory<>("readername"));
       column_Birth.setCellValueFactory(new PropertyValueFactory<>("birth"));
       column_Gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
       column_Address.setCellValueFactory(new PropertyValueFactory<>("address"));
       column_Phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
       column_RDate.setCellValueFactory(new PropertyValueFactory<>("registrationdate"));
       column_DDate.setCellValueFactory(new PropertyValueFactory<>("deadlinedate"));
       column_Barcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));

       table_reader.setItems(ListshowData);
   }
    /* kết thúc method load sql table Reader*/




    /*xây dựng method selctItem_Reader -> load khi ấn chọ data hiển thị lên các textfiled...*/
    public void selectItem_Reader(){

    }
    /*end method selectItem_Reader*/




    /*
     * Trong JavaFX, Initializable là một interface được sử dụng để khởi tạo các thành phần giao diện người dùng sau khi chúng đã được tạo ra.
     *  Interface này chứa một phương thức duy nhất initialize() được gọi khi tất cả các thành phần của giao diện người dùng đã được tạo.Khi một
     * đối tượng của một lớp điều khiển (controller class) được tạo, nó được liên kết với một tệp FXML và được tạo ra bằng cách sử dụng
     * FXMLLoader. Sau khi tất cả các thành phần được tạo ra, phương thức initialize() được gọi. thực hiện các thao tác khởi tạo trước khi cửa sổ hoặc
     *  màn hình được hiển thị cho người dùng. Bên trong phương thức initialize(), bạn có thể thực hiện các thao tác khởi tạo đối tượng, thiết lập dữ liệu
     *  ban đầu, gắn các xử lý sự kiện và các thao tác khởi tạo khác.
     * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /* Tạo StringConverter để chuyển đổi giá trị DatePicker thành chuỗi theo định dạng yyyy-MM-dd*/
        javafx.util.StringConverter<LocalDate> converter = new   javafx.util.StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };

        // Đặt StringConverter cho DatePicker
        datePicker1.setConverter(converter);
        datePicker2.setConverter(converter);
        datePicker3.setConverter(converter);
        /*kết thúc chuyển đổi datePicker*/


        /*load showReaderTable() đưa dl lên table,,,method initilize() gọi showReaderTable() và thực hiện các thao tác khởi tạo
        trước khi cửa sổ hoặc màn hình được hiển thị cho người dùng*/
        showReaderTable();

        // add combobox lên giao diện
        combobox_Gender.setItems(typeList);

    }
   /*end method initialize()*/



}
/*end program*/
