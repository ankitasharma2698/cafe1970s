/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafecollege1;

import ECUtils.GUIValidator;
import cafebean.Login;
import cafedao.LoginDAO;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author compaq
 */
public class LoginController implements Initializable {
    GUIValidator g= new GUIValidator();
    
    @FXML
    private ImageView img;
    @FXML
    private TextField usertxt;
    @FXML
    private PasswordField passwd;
    @FXML
    private Label label;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnExit;

    /**
     * Initializes the controller class.
     */
 @Override
    public void initialize(URL url, ResourceBundle rb) {
//        g.addNameValidator(usertxt);
//        g.addPassValidator(passwd);
    } 
 
    @FXML
    @SuppressWarnings({"CallToPrintStackTrace", "StringEquality"})
    private void handleButtonAction(ActionEvent event) throws IOException {
        if(event.getSource() == btnExit)
            System.exit(0);
        if(event.getSource() == btnLogin){
             try {
//                if (g.validateAll()) {
                if (!(usertxt.getText().isEmpty() && usertxt.getText().isEmpty())) {    
                    Login u1;
                    u1 = LoginDAO.validate(usertxt.getText(), passwd.getText());
                    if (u1 != null) {
                        LoginDAO.registerUser(usertxt.getText(),passwd.getText());
                        Stage stage = (Stage) btnLogin.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        //stage.setMaximized(true);
                        stage.show();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid user name or password!");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }                
            }
    
         }
    }

