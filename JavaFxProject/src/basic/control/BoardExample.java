package basic.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//UI:BoardControl.fxml
//Control: BoardController.java
//Board.java
public class BoardExample extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane ap=FXMLLoader.load(this.getClass().getResource("BoardControl.fxml"));
		Scene scene=new Scene(ap);
		arg0.setScene(scene);
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
