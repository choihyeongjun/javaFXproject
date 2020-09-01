package basic.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//UI:view.fxml
//control:view controller.java 
//p.909
public class ViewExample extends Application{
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane root=FXMLLoader.load(getClass().getResource("view.fxml"));
		Scene scene=new Scene(root);
		arg0.setScene(scene);
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
