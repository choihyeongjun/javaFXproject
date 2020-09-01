package basic.container.eventhandle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EventHandlerExample extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		BorderPane root=FXMLLoader.load(getClass().getResource("Root.fxml"));
		
		Scene scene=new Scene(root);
		arg0.setScene(scene);
		arg0.show();
	}

}
