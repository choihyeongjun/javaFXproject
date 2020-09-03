package basic.control.chart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChartExample extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		HBox hbox=FXMLLoader.load(getClass().getResource("Chart.fxml"));
		Scene scene=new Scene(hbox);
		arg0.setScene(scene);
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
