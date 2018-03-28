import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
    private Button addButton;

    @FXML
    private Button editButton;

    private static Stage stage = new Stage();
    private static ModifyController controller = new ModifyController(stage);

    public ListJournal() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Modify.fxml"));
        controller = new ModifyController(stage);
        loader.setController(controller);
        stage.setOnShown(event -> controller.loadAction());
        stage.setScene(new Scene(loader.load()));
    }

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

    @FXML
    private void addButtonAction() {
        controller.setAttendances(null);
        stage.showAndWait();
        fillTableView();
    }

    @FXML
    private void editButtonAction() {
        Attendances attendances = attendanceTableView.getSelectionModel().getSelectedItem();
        if(attendances != null){
            controller.setAttendances(attendances);
            stage.showAndWait();
            fillTableView();
        }
    }

}


