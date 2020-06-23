/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafecollege1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author compaq
 */
public class MenuCardController implements Initializable {

    @FXML
    private AnchorPane img;
    @FXML
    private Label label1;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Button btnBack;
    @FXML
    private Label label2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnBack) {
            try {
                Stage stage = (Stage)btnBack.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
