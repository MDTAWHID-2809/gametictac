/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoktoe;

import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Md Tawhid
 */
public class FXMLDocumentController implements Initializable {
    //boolean variable to maintain x and y one after another
    public boolean x=true;
    
    @FXML
    private Button b1;
    @FXML
    private Button b8;
    @FXML
    private Button b7;
    @FXML
    private Button b6;
    @FXML
    private Button b5;
    @FXML
    private Button b4;
    @FXML
    private Button b3;
    @FXML
    private Button b2;
    @FXML
    private Button b9;
    //label to set who win
    @FXML
    private Label lbl;
    //variable to stop game when someone win
    public boolean lock=false;
    //variable which track when there is no button available and no win then it stop to hold the game
    public int countpress=0;
    //2d array to hold all the button
    public Button Array[][]=new Button[3][3];
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Array[0][0]=b1;
         Array[0][1]=b2;
          Array[0][2]=b3;
           Array[1][0]=b4;
            Array[1][1]=b5;
             Array[1][2]=b6;
              Array[2][0]=b7;
               Array[2][1]=b8;
                Array[2][2]=b9;
    }    
    // method to reset everything
    public void reset(){
        Button Array[][]=new Button[3][3];
        Array[0][0]=b1;
         Array[0][1]=b2;
          Array[0][2]=b3;
           Array[1][0]=b4;
            Array[1][1]=b5;
             Array[1][2]=b6;
              Array[2][0]=b7;
               Array[2][1]=b8;
                Array[2][2]=b9;
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        Array[i][j].setText(" ");
                    }
                }
                 lbl.setText(" ");
                 lock=false;
                 countpress=0;
                 
    }
    //method that is the main core of that game which is track if someone is winning or not
    @FXML
    public void inputx_y(ActionEvent event){
      //if no is win and still button is available then it allow us to press next button
     if(lock==false&& countpress !=9) {
        //track the which event is occuring means which button is pressing
        EventObject evo = new EventObject(event.getSource());
        Object obj = evo.getSource();
        Button btnMirror = (Button)obj;
        //check if the button is already pressded
        if(btnMirror.getText().equals("X")||btnMirror.getText().equals("O")){
        }
        //otherwise alow to press
        else{
          //X is true then this the turn of X
          if(x==true){
            btnMirror.setText("X");
            x=false;
            //each time we press button increament the countpress
            countpress++;
          }
          else{
            btnMirror.setText("O");
            x=true;
            countpress++;
          }
       }
        
     //part to check matching 00 01 02, 10 11 12 , 20 21 22
        for(int i=0;i<3;i++){
            String s="";
            for(int j=0;j<3;j++){
                 s+=Array[i][j].getText();
               }
            if(s.equals("XXX")){
                lbl.setText("X win");
                lock=true;
                
            }
            else  if(s.equals("OOO")){
                lbl.setText("O win");
                 lock=true;
               
            }
        }
        //part to check matching 00 10 20, 01 11 21 ,02 12 22
        for(int j=0;j<3;j++){
            String s="";
            for(int i=0;i<3;i++){
                 s+=Array[i][j].getText();
               }
            if(s.equals("XXX")){
                lbl.setText("X win");
                lock=true;
                
            }
            else  if(s.equals("OOO")){
                lbl.setText("O win");
                 lock=true;
               
            }
        }
       
       //part to if matching 00 11 22
        String k="";
        for(int i=0;i<3;i++){
           
            k+=Array[i][i].getText();
        }
         if(k.equals("XXX")){
              
               lbl.setText("X win");
                lock=true;
         }
         else if(k.equals("OOO")){
              
               lbl.setText("O win");
                 lock=true;
         }
         
         
        String p=Array[0][2].getText()+Array[1][1].getText()+Array[2][0].getText();
        if(p.equals("XXX")){
             
                lbl.setText("X win");
                 lock=true;
           }
        else if(p.equals("OOO")){
             
                lbl.setText("O win");
                 lock=true;
           }
     }
   }
 }

     
       
    

