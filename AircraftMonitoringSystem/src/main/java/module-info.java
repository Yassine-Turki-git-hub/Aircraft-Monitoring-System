module com.aircraft.aircraftmonitoringsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.aircraft.aircraftmonitoringsystem to javafx.fxml;
    exports com.aircraft.aircraftmonitoringsystem;
}