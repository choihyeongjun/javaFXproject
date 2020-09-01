package basic.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//UI
//controller
public class ButtonExample extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		BorderPane root=FXMLLoader.load(getClass().getResource("Button.fxml"));
		
		Scene scene=new Scene(root);
		arg0.setScene(scene);
		arg0.show();
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
