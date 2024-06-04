module org.example.DemoModul6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.DemoModul6 to javafx.fxml;
    exports org.example.DemoModul6;
}