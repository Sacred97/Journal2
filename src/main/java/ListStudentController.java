import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class ListStudentController {
    private Student student;

    @FXML
    private TableView <Student> StudentTableView;

    @FXML
    TableColumn <Student, Long> idColumn;

    @FXML
    TableColumn <Student, String> nameColumn;

    @FXML
    TableColumn <Student, Date> BirthColumn;

    @FXML
    TableColumn <Student, String> Group1Column;

    @FXML
    Button CloseButton;

    private static Stage stage2 = new Stage();
    private static ListStudentController controller2 = new ListStudentController(stage2);

    public ListStudentController(Stage stage2) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListStudent.fxml"));
        controller2 = new ListStudentController(stage2);
        loader.setController(controller2);
        try {
            stage2.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void fillTableView() {
        List<Student> ListStudent = Service.students();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idAttendance"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Student"));
        BirthColumn.setCellValueFactory(new PropertyValueFactory<>("numberGroup"));
        Group1Column.setCellValueFactory(new PropertyValueFactory<>("Lesson"));
        StudentTableView.setItems(FXCollections.observableArrayList(ListStudent));
    }

    @FXML
    private void initialize() throws Exception {
        fillTableView();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
