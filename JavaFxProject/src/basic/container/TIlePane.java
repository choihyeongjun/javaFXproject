
package basic.container;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TIlePane extends Application {

	public static void main(String[] args) { // TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		TilePane tp = new TilePane();
		tp.setPrefHeight(100);
		tp.setPrefWidth(500);
		ImageView iv = new ImageView();
		ImageView iv1 = new ImageView();
		ImageView iv2 = new ImageView();
		ImageView iv3 = new ImageView();
		ImageView iv4 = new ImageView();

		iv.setImage(new Image("/images/fruit1.jpg"));
		iv1.setImage(new Image("/images/fruit2.jpg"));
		iv2.setImage(new Image("/images/fruit3.jpg"));
		iv3.setImage(new Image("/images/fruit4.jpg"));
		iv4.setImage(new Image("/images/fruit5.jpg"));

		 
		tp.getChildren().add(iv);
		tp.getChildren().add(iv1);
		tp.getChildren().add(iv2);
		tp.getChildren().add(iv3);
		tp.getChildren().add(iv4);
		Scene scene = new Scene(tp);// 스테이지인 arg0(신(컨테이너))
		arg0.setScene(scene);
		arg0.show();
		arg0.setTitle("TilePane 예제");

	}

}
