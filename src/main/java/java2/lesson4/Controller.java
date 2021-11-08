package java2.lesson4;


import javafx.fxml.FXML;
import javafx.scene.control.*;


public class Controller {
    private CollectionsPerson collectionsPerson;

    @FXML
    private Label userInfo;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField textField;

    @FXML
    private ListView userList;

    @FXML
    private Button sendButton;





    public void initialize() {
        collectionsPerson=new CollectionsPerson();
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        userInfo.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");
        textField.setOnAction(actionEvent -> sendMessage());
        sendButton.setOnAction(actionEvent -> sendMessage());
        userList.setItems(collectionsPerson.getPersonList());




    }
    public void sendMessage() {
        textArea.appendText(textField.getText()+"\n");
        textField.clear();
    }

    @FXML
    public void newInfo() {
        userInfo.setText(String.valueOf(userList.getSelectionModel().getSelectedItems()));
    }
}

