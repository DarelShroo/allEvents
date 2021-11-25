module dad.allevents {
    requires javafx.controls;
    requires javafx.fxml;


    opens dad.allevents to javafx.fxml;
    exports dad.allevents;
    exports dad.allevents.controller;
    opens dad.allevents.controller to javafx.fxml;
    exports dad.allevents.controller.viewmultiple;
    opens dad.allevents.controller.viewmultiple to javafx.fxml;
}