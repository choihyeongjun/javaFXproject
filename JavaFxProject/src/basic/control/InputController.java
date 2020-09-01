package basic.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InputController implements Initializable{
	@FXML
	TextField txtTitle;
	@FXML
	PasswordField txtPassword;
	@FXML
	ComboBox<String> comboPublic;
	@FXML
	DatePicker dataExit;
	@FXML
	TextArea txtContent;
	@FXML
	Button btnReg,btnCancel;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//txtTitle.setText("여러분 모두다 안녕하세요요");
		//comboPublic.setValue("public");
		btnReg.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				handleBtnRegAction();
			}
			
		});
	}
	public void handleBtnRegAction() {
		if(txtTitle.getText()==null || txtTitle.getText().equals("")) {
			//팝업 타이틀 등록.
			showPopup("타이틀입력해라");
		}else if(txtTitle.getText()==null|| txtPassword.getText().equals("")) {
			showPopup("비밀번호입력해라");
		}
		else if(comboPublic.getValue()==null || comboPublic.getValue().equals("")) {
			showPopup("공개여부 지정해라");
		}else if (dataExit.getValue()==null)
			showCustomDialog("날짜를 입력하세요");
	}
	public void showCustomDialog(String sg) {
		Stage stage=new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btnReg.getScene().getWindow());
		AnchorPane ap=new AnchorPane();
		ap.setPrefSize(400, 150);
		ImageView iv=new ImageView();
		iv.setImage(new Image("images/dialog-info.png"));
		iv.setFitWidth(50);
		iv.setFitHeight(50);
		iv.setLayoutX(15);
		iv.setLayoutY(15);
		iv.setPreserveRatio(true);
		Button btnOk=new Button("확인");
		btnOk.setLayoutX(336);
		btnOk.setLayoutY(104);
		btnOk.setOnAction((e)->stage.close());
		Label label=new Label(sg);
		label.setLayoutX(87);
		label.setLayoutY(33);
		label.setPrefSize(290, 15);
		ap.getChildren().addAll(iv,btnOk,label);
		
		Scene scene=new Scene(ap);
		stage.setScene(scene);
		stage.show();
		
		
		
	}
	public void showPopup(String msg) {
		HBox hbox=new HBox();
		hbox.setStyle("-fx-background-color: black;-fx-background-radius: 20");
		hbox.setAlignment(Pos.CENTER);
		ImageView iv=new ImageView();
		iv.setImage(new Image("/images/dialog-info.png"));
		Label label=new Label();
		label.setText(msg);
		label.setStyle("-fx-text-fill:yellow;");
		hbox.getChildren().addAll(iv,label);
		
		Popup pop=new Popup();
		pop.getContent().add(hbox);
		pop.setAutoHide(true);
		pop.show(btnReg.getScene().getWindow());
	}

}
