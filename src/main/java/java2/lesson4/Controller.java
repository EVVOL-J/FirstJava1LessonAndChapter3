package java2.lesson4;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

        @FXML
        private Label label;

        public void initialize() {
            String javaVersion = System.getProperty("java.version");
            String javafxVersion = System.getProperty("javafx.version");
            label.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");
            Thread.onSpinWait();

        }
    }

