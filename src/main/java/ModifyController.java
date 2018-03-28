import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class ModifyController {

    private Stage stage;

    private Attendances attendances;


    @FXML
    TextField studentTextField;

    @FXML
    ChoiceBox groupChoiceBox;

    @FXML
    ChoiceBox lessonChoiceBox;

    @FXML
    DatePicker dataPicker;

    @FXML
    ChoiceBox stateChoiceBox;

    public ModifyController(Stage stage) {
        this.stage = stage;
    }

    public void loadAction() {
        if(attendances == null){
            clearAction();
        } else {
            studentTextField.setText(attendances.getStudent());
            groupChoiceBox.setItems(FXCollections.observableArrayList("71415", "71416", "71417"));
            lessonChoiceBox.setItems(FXCollections.observableArrayList("Английский язык", "Математика", "Физика"));
            dataPicker.setValue(attendances.getData().toLocalDate());
            stateChoiceBox.setItems(FXCollections.observableArrayList("+", "-", "Б"));
        }
    }

    @FXML
    private void saveAction() {
        String student = studentTextField.getText();
        Long group = Long.valueOf(String.valueOf(groupChoiceBox.getItems()));
        String lesson = String.valueOf(lessonChoiceBox.getItems());
        Date data = Date.valueOf(dataPicker.getValue());
        String state = String.valueOf(stateChoiceBox.getItems());
        if(attendances == null){
            attendances = new Attendances(0, student, group, lesson, data, state);
            Service.addStudent(attendances);
        } else {
            attendances.setStudent(student);
            attendances.setNumberGroup(group);
            attendances.setLesson(lesson);
            attendances.setData(data);
            attendances.setState(state);
            Service.updateStudent(attendances);
        }
        stage.close();
    }

    @FXML
    private void clearAction() {
        studentTextField.clear();
        groupChoiceBox.setValue(null);
        lessonChoiceBox.setValue(null);
        dataPicker.setValue(LocalDate.now());
        stateChoiceBox.setValue(null);
    }

    private LocalDate convertDateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public Attendances getAttendances() {
        return attendances;
    }

    public void setAttendances(Attendances attendances) {
        this.attendances = attendances;
    }



}
