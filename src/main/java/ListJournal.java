import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;
import java.util.List;

public class ListJournal {

    @FXML
    private TableView <Attendances> attendanceTableView;

    @FXML
    private TableColumn<Attendances, Long> idAttendanceColumn;

    @FXML
    private TableColumn<Attendances, String> StudentColumn;

    @FXML
    private TableColumn<Attendances, Long> GroupColumn;

    @FXML
    private TableColumn<Attendances, String> LessonColumn;

    @FXML
    private TableColumn<Attendances, Date> DataColumn;

    @FXML
    private TableColumn<Attendances, String> StateColumn;

    @FXML
    private Button editButton;

    private void fillTableView() {
        List<Attendances> ListJournal = Service.selectUsers();
        idAttendanceColumn.setCellValueFactory(new PropertyValueFactory<>("idAttendance"));
        StudentColumn.setCellValueFactory(new PropertyValueFactory<>("Student"));
        GroupColumn.setCellValueFactory(new PropertyValueFactory<>("numberGroup"));
        LessonColumn.setCellValueFactory(new PropertyValueFactory<>("Lesson"));
        DataColumn.setCellValueFactory(new PropertyValueFactory<>("Data"));
        StateColumn.setCellValueFactory(new PropertyValueFactory<>("State"));
        attendanceTableView.setItems(FXCollections.observableArrayList(ListJournal));
        editButton.setDisable(ListJournal.isEmpty());

    }

    @FXML
    private void initialize() throws Exception {
        fillTableView();
    }
}
