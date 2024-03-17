module com.alexosta.demo_003 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.alexosta.demo_003 to javafx.fxml;
    exports com.alexosta.demo_003;
}