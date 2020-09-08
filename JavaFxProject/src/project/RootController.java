package project;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import basic.example.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable{
	@FXML
	TableView<Info> tableView;
	@FXML
	Button btnAdd1,btnAdd2;
	ObservableList<Info>info;
	
	
	Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage=primaryStage;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		info=FXCollections.observableArrayList();
		btnAdd2.setOnAction(new EventHandler<ActionEvent>() {//회원가입
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				handleBtnAddAction();
			}
		});
		
		btnAdd1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				handleBtnlogAction();
			}
		});
		
	}
	public void handleBtnlogAction() {
		Connection conn=DBConnection.getConnection();
		
		Stage stage=new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btnAdd1.getScene().getWindow());
		
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("AddForm.fxml"));
			Scene scene=new Scene(parent);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void handleBtnAddAction() {
		Stage stage=new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btnAdd2.getScene().getWindow());
		
		Connection conn=DBConnection.getConnection();
		
		
		try {
			Parent parent =FXMLLoader.load(getClass().getResource("AddForm.fxml"));
			Scene scene=new Scene(parent);
			stage.setScene(scene);
			stage.show();
			Button btnFormAdd=(Button) parent.lookup("#btnFormAdd");
			btnFormAdd.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					TextField txtId=(TextField) parent.lookup("#txtId");
					TextField txtPassword=(TextField) parent.lookup("#txtPassword");
					Info in=new Info(txtId.getText(),Integer.parseInt(txtPassword.getText()));
					String sql="insert into info values("+"\'"+txtId.getText()+"\'"+","+
							Integer.parseInt(txtPassword.getText())+")";
					PreparedStatement psmt;
					info.add(in);
					stage.close();
					
					try {
						psmt = conn.prepareStatement(sql);
						int r=psmt.executeUpdate();
						System.out.println(r+"건 입력되었습니다");
						System.out.println("---- end of data --");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			Button btnFormCancel=(Button)parent.lookup("#btnFormCancel");
			btnFormCancel.setOnAction(e->{
				TextField txtId=(TextField) parent.lookup("#txtId");
				TextField txtPassword= (TextField) parent.lookup("#txtPassword");
				txtId.clear();
				txtPassword.clear();
				
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
