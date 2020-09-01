package basic.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ButtonController implements Initializable{
	@FXML ToggleGroup group;
	@FXML ImageView radioImageView,checkImageView;
	@FXML RadioButton rad1,rad2,rad3;
	@FXML
	CheckBox chk1,chk2;
	@FXML
	Button btnExit;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				
				if(newValue!=null && oldValue!=null) {
				System.out.println(oldValue.getUserData());
				System.out.println(newValue.getUserData());
				radioImageView.setImage(new Image("/images/"+ newValue.getUserData().toString()+".png"));
				}
			}
			
		});
		rad1.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				// TODO Auto-generated method stub
				System.out.println("rad1 clicked");
			}
			
		});
		rad2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				
				System.out.println("rad2 clicked");
			}
			
		});
		rad3.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				// TODO Auto-generated method stub
				System.out.println("rad3 clicked");
			}
			
		});
			
			
		chk1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				handleChkAction();
			}
			
		});
		chk2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				handleChkAction();
			}
			
		});
		btnExit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Platform.exit();
			}
			
		});
		
	}//end of intialize
	public void handleChkAction() {
		String imgName="";
		if(chk1.isSelected() && chk2.isSelected()) {
			imgName="geek-glasses-hair.gif";
		}else if(chk1.isSelected()) {
			imgName="geek-glasses.gif";
		}else if(chk2.isSelected()) {
			imgName="geek-hair.gif";
		}
		else {
			imgName="geek.gif";
		}
		checkImageView.setImage(new Image("/images/"+imgName));
	}
}//end of class
