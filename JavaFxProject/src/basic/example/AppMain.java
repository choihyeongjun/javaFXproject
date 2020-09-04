package basic.example;
//UI:root.fxml ,addform.fxml(추가기능),barchart.fxml(차트)

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppMain extends Application{
	
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader=new FXMLLoader(getClass().getResource("Root.fxml"));
		BorderPane root=loader.load();
		
		RootController controller=loader.getController();
		controller.setPrimaryStage(arg0);
		
		
		Scene scene=new Scene(root);
		arg0.setScene(scene);
		arg0.show();
		arg0.setResizable(false);
	}
	public static void main(String[] args) {
		launch(args);
	}

}
