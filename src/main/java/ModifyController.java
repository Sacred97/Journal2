import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

   // private Student student2;

    @FXML
    ChoiceBox StudentChoiceBox;

    @FXML
    ChoiceBox groupChoiceBox;

    @FXML
    ChoiceBox lessonChoiceBox;

    @FXML
    DatePicker dataPicker;

    @FXML
    ChoiceBox stateChoiceBox;

    @FXML
    Button ListButton;

    public ModifyController(Stage stage) {
        this.stage = stage;
    }

    public void loadAction() {
        if(attendances == null){
            clearAction();
            StudentChoiceBox.setItems(FXCollections.observableArrayList("Рязапов Т.С.", "Мамедов Р.С.", "Калаев А.В", "Гильмутдинов Ш.Ф.",
                    "Копанев А.С.", "Лысов В.А", "Фазлеев Т.И."));
            groupChoiceBox.setItems(FXCollections.observableArrayList("71415","71416","71417"));
            lessonChoiceBox.setItems(FXCollections.observableArrayList("Английский язык", "Математика", "Физика"));
            stateChoiceBox.setItems(FXCollections.observableArrayList("+","-","Б"));
        } else {
            StudentChoiceBox.setItems(FXCollections.observableArrayList(attendances.getStudent()));
            groupChoiceBox.setItems(FXCollections.observableArrayList(attendances.getNumberGroup()));
            lessonChoiceBox.setItems(FXCollections.observableArrayList(attendances.getLesson()));
            dataPicker.setValue(attendances.getData().toLocalDate());
            stateChoiceBox.setItems(FXCollections.observableArrayList("+","-","Б"));
        }
    }

    @FXML
    private void saveAction() {
        String student = String.valueOf(StudentChoiceBox.getValue());
        if (String.valueOf(StudentChoiceBox.getValue()).equals("Рязапов Т.С.")){
            student = String.valueOf("14");
        } else if (String.valueOf(StudentChoiceBox.getValue()).equals("Мамедов Р.С.")){
            student = String.valueOf("15");
        }else if (String.valueOf(StudentChoiceBox.getValue()).equals("Калаев А.В")){
            student = String.valueOf("16");
        }else if (String.valueOf(StudentChoiceBox.getValue()).equals("Гильмутдинов Ш.Ф.")){
            student = String.valueOf("17");
        }else if (String.valueOf(StudentChoiceBox.getValue()).equals("Копанев А.С.")){
            student = String.valueOf("18");
        }else if (String.valueOf(StudentChoiceBox.getValue()).equals("Лысов В.А")){
            student = String.valueOf("19");
        }else if (String.valueOf(StudentChoiceBox.getValue()).equals("Фазлеев Т.И.")){
            student = String.valueOf("20");
        }
        String group = String.valueOf(groupChoiceBox.getValue());
        if (String.valueOf(groupChoiceBox.getValue()).equals("71415")){
            group=String.valueOf('1');
        } else if (String.valueOf(groupChoiceBox.getValue()).equals("71416")){
            group=String.valueOf('2');
        } else if (String.valueOf(groupChoiceBox.getValue()).equals("71417")){
            group=String.valueOf('3');
        }
        String lesson = String.valueOf(lessonChoiceBox.getValue());
        if (String.valueOf(lessonChoiceBox.getValue()).equals("Английский язык")){
            lesson=String.valueOf('1');
        } else if (String.valueOf(lessonChoiceBox.getValue()).equals("Математика")){
            lesson=String.valueOf('2');
        } else if (String.valueOf(lessonChoiceBox.getValue()).equals("Физика")){
            lesson=String.valueOf('3');
        }
        Date data = Date.valueOf(dataPicker.getValue());
        String state = String.valueOf(stateChoiceBox.getItems());
        if (String.valueOf(stateChoiceBox.getValue()).equals("+")){
            state = String.valueOf('+');
        } else if (String.valueOf(stateChoiceBox.getValue()).equals("-")){
            state = String.valueOf('-');
        } if (String.valueOf(stateChoiceBox.getValue()).equals("Б")){
            state = String.valueOf('Б');
        }
        if(attendances == null){
            attendances = new Attendances(0, student, group, lesson, data, state);
            Service.addStudent(attendances);
        } else {
           //attendances.setLesson(lesson);
            attendances.setData(data);
            attendances.setState(state);
            Service.updateStudent(attendances);
        }
        stage.close();
    }

    @FXML
    private void clearAction() {
        StudentChoiceBox.setValue(null);
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
