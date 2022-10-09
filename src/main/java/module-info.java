module com.daniel1898.petproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.daniel1898.petproject to javafx.fxml;
    exports com.daniel1898.petproject;
}