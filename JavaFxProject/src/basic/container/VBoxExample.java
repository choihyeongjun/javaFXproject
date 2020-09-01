package basic.container;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxExample extends Application{

	public static void main(String[] args) {
		Application.launch(args);//하면 스타트 호출
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		VBox root=new VBox();
		root.setPadding(new Insets(10,10,10,10));
		ImageView iv=new ImageView();
		iv.setFitWidth(200.0);
		iv.setPreserveRatio(true);
		iv.setImage(new Image("/images/fruit1.jpg"));
		
		HBox hbox=new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(20.0);
		Button btnPrev=new Button();
		btnPrev.setText("이전");
		Button btnNext=new Button();
		btnNext.setText("다음");
		HBox.setHgrow(btnNext, Priority.ALWAYS);
		btnNext.setMaxWidth(Double.MAX_VALUE);
		hbox.getChildren().add(btnPrev);
		hbox.getChildren().add(btnNext);
		VBox.setMargin(hbox, new Insets(10));
		//이벤트 핸들러를 해당 컨트롤에 등록.
		
		btnPrev.setOnAction(new EventHandler<ActionEvent>() {
			int i=1;

			@Override
			public void handle(ActionEvent ae) {
				if(i==0) {
					i=9;
				}
				iv.setImage(new Image("/images/fruit"+i-- +".jpg"));
				
			}
			
		});
		btnNext.setOnAction(new EventHandler<ActionEvent>() {
			int i=1;

			@Override
			public void handle(ActionEvent ae) {
				if(i==10) {
					i=1;
				}
				iv.setImage(new Image("/images/fruit"+i++ +".jpg"));
				
			}
			
		});
		
		root.getChildren().add(iv);
		root.getChildren().add(hbox);
		Scene scene=new Scene(root);//스테이지인 arg0(신(컨테이너))
		arg0.setScene(scene);
		arg0.show();
		arg0.setTitle("VBox 예제");
		
		
	}

}
