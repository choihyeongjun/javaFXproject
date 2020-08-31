package basic;




import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		HBox hbox=new HBox();//컨테이너.
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(10);
		
		TextField tField=new TextField();
		tField.setPrefWidth(200.0);
		Button btn=new Button();
		btn.setText("확인");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				Platform.exit();
				
			}
		});
		//컨테이너에 컨트롤 달기
		hbox.getChildren().add(tField);
		hbox.getChildren().add(btn);
		Scene scene=new Scene(hbox);
		arg0.setScene(scene);
		arg0.show();
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
