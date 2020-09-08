package project;

import project.RootController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Pmain extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader=new FXMLLoader(getClass().getResource("root.fxml"));
		AnchorPane root=loader.load();
		
		RootController controller=loader.getController();
	
		
		
		Scene scene=new Scene(root);
		arg0.setScene(scene);
		arg0.show();
		arg0.setResizable(false);
	}

}
