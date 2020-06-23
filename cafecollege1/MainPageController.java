/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafecollege1;

import java.io.IOException;
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
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author compaq
 */
public class MainPageController implements Initializable {

    @FXML
    private ImageView img1;
    @FXML
    private Rectangle rect;
    @FXML
    private Label label;
    @FXML
    private Button btnDash;
    @FXML
    private Button menuBtn;
    @FXML
    private Button orderBtn;
    @FXML
    private Button empBtn;
    @FXML
    private Label lb3;
    @FXML
    private Label lb4;
    @FXML
    private Label lb5;
    @FXML
    private Button btnExit;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if(event.getSource() == btnExit)
            System.exit(0);
        if(event.getSource() == btnDash){
                Stage stage = (Stage) btnExit.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        
            }
        if(event.getSource() == menuBtn){
                Stage stage = (Stage) btnExit.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("MenuCard.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        
            }
        if(event.getSource() == orderBtn){
                Stage stage = (Stage) btnExit.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("OrderNow.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        
            }
        if(event.getSource() == empBtn){
                Stage stage = (Stage) btnExit.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("Contact.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        
            }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}
