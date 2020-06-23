/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafecollege1;

import ECUtils.GUIValidator;
import cafebean.Orders;
import cafedao.MenuDAO;
import cafedao.OrderDAO;
import java.awt.HeadlessException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author compaq
 */
public class OrderNowController implements Initializable {
GUIValidator v1 = new GUIValidator();
//        Orders updt = new Orders();

    @FXML
    private ImageView img;
    @FXML
    private Label label;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtQty;
    @FXML
    private TextField txtAmount;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnPay;
    @FXML
    private ComboBox<String> cmbFood;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
//        v1.addRequiredValidator(txtFood);
//        v1.addRequiredValidator(txtPrice);
//        v1.addRequiredValidator(txtQty);
        cmbFood.getItems().addAll(MenuDAO.getMenuItem());     
        
            
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnBack) {
            try {
                int ch = JOptionPane.showConfirmDialog(null, "R u sure , to cancel and go back");
                    if (ch == 0) {
                        JOptionPane.showMessageDialog(null, "Order Cancelled!!");           
                        Stage stage = (Stage)btnBack.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                    }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        if (event.getSource() == btnPay){
            try{            
                Orders odr = new Orders("", cmbFood.getValue(),
                            Double.valueOf(txtPrice.getText()), 
                            Integer.parseInt(txtQty.getText()),
                            Double.valueOf(txtPrice.getText())*
                              Double.valueOf(txtQty.getText()));
               
//                JOptionPane.showMessageDialog(null, " "+odr.getId()+"::"+odr.getF_name()
//                        +"::"+odr.getQuantity()+"::"+odr.getAmount());
              
                 
                OrderDAO.insert(odr);
                JOptionPane.showMessageDialog(null, "Done!!");
                Stage stage = (Stage)btnBack.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();                    
            } 
            catch (Exception e) {
             e.printStackTrace();
        }
        }
    }
    @FXML
    private void findPrice(ActionEvent event) {
        txtPrice.setText(MenuDAO.getItemPrice(cmbFood.getValue()).toString());
    }


    @FXML
    private void calculateAmount(ActionEvent event) {
        Integer qty = Integer.valueOf(txtQty.getText());
        double fprice = MenuDAO.getItemPrice(cmbFood.getValue())*qty;
        txtAmount.setText(""+fprice);  
        
    }

    }
    

