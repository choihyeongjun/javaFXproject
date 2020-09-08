package basic.example;

import java.awt.Event;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.yedam.database.DBConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable{
	@FXML
	TableView<Student> tableView;
	@FXML
	Button btnAdd,btnBarChart,btnAdd1;
	
	ObservableList<Student>list;
	
	//list.add("dd",123,111,111);
	Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage=primaryStage;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		TableColumn<Student,?>tc=tableView.getColumns().get(0);//첫번째 칼럼.
		tc.setCellValueFactory(new PropertyValueFactory<>("id"));
		tc=tableView.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("name"));
		tc=tableView.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("korean"));
		tc=tableView.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("math"));
		tc=tableView.getColumns().get(4);
		tc.setCellValueFactory(new PropertyValueFactory<>("english"));
		//성적저장.
		
		
		list=FXCollections.observableArrayList();
		btnAdd1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				list=getStList();
				tableView.setItems(list);
			}
		});
		tableView.setItems(list);
		
		//추가버튼.
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				handleBtnAddAction();
			}
		});
		//차트 버튼.
		btnBarChart.setOnAction(e->handleBtnChartAction());
		
		
		tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println(event);
				if(event.getClickCount()==2) {
					int selectedId=tableView.getSelectionModel().getSelectedItem().getId();
					handleDoubleClickAction(selectedId);
					
				}
			}
			
		});
		
	}//end of 초기화
	public void handleDoubleClickAction(int id) {
		Stage stage=new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);
		
		AnchorPane ap=new AnchorPane();
		ap.setPrefSize(210,230);
		Label lid,lKorean,lMath,lEnglish,lname;
		TextField tid,tName,tKorean,tMath,tEnglish;
		
		lname=new Label("이름");
		lname.setLayoutX(35);
		lname.setLayoutY(45);
		
		
		lid=new Label("아이디");
		lid.setLayoutX(35);
		lid.setLayoutY(20);
		
		lKorean=new Label("국어");
		lKorean.setLayoutX(35);
		lKorean.setLayoutY(73);
		
		lMath=new Label("수학");
		lMath.setLayoutX(35);
		lMath.setLayoutY(99);
		
		lEnglish=new Label("영어");
		lEnglish.setLayoutX(35);
		lEnglish.setLayoutY(132);
		
		
		tid=new TextField();
		tid.setPrefWidth(110);
		tid.setLayoutX(72);
		tid.setLayoutY(15);
		
		
		
		tName=new TextField();
		tName.setPrefWidth(110);
		tName.setLayoutX(72);
		tName.setLayoutY(43);
		
		//tName.setText();
		tName.setEditable(false);
		
		tKorean=new TextField();
		tKorean.setPrefWidth(110);
		tKorean.setLayoutX(72);
		tKorean.setLayoutY(69);
		
		tMath=new TextField();
		tMath.setPrefWidth(110);
		tMath.setLayoutX(72);
		tMath.setLayoutY(95);
		
		tEnglish=new TextField();
		tEnglish.setPrefWidth(110);
		tEnglish.setLayoutX(72);
		tEnglish.setLayoutY(128);
		
		Button btnUpdate=new Button("수정");
		btnUpdate.setLayoutX(85);
		btnUpdate.setLayoutY(184);
		btnUpdate.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getClickCount()==1) {
				
					
					
					
					stage.close();
				}
			}
			
		});
		
		btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
			Connection conn=DBConnection.getConnection();
			
			
			@Override
			public void handle(ActionEvent event) {
				 {
					{
						for(int i=0;i<list.size();i++) {
							if(list.get(i).getId()==id) {
								Student student=new Student(id,tName.getText(),Integer.parseInt(tKorean.getText()),
										Integer.parseInt(tMath.getText()),Integer.parseInt(tEnglish.getText()));
								
								list.set(i,student);
							}
						}
						
						
						
						
						String sql="update new_st set "
								+"korean="+Integer.parseInt(tKorean.getText())+","+
								"math="+Integer.parseInt(tMath.getText())+","+"english="+Integer.parseInt(tEnglish.getText())
								+" where id="+tid.getText();
						System.out.println(sql);
						try {
							PreparedStatement psmt=conn.prepareStatement(sql);
							int r=psmt.executeUpdate();
							System.out.println(r+"건 입력되었습니다");
							
						}
						catch(SQLException e) {
							e.printStackTrace();
						}
								
					
					}
				}
			}
		});
		//이름 기준으로 국어점수 ,수학,영어 화면에 입력해주기
		for(Student stu:list) {
			if(stu.getId()==id) {
				tid.setText(String.valueOf(id));
				tName.setText(String.valueOf(stu.getName()));
				tMath.setText(String.valueOf(stu.getMath()));
				tKorean.setText(String.valueOf(stu.getKorean()));
				tEnglish.setText(String.valueOf(stu.getEnglish()));
			}
		}
		
		ap.getChildren().addAll(btnUpdate,tid,tName,tKorean,tMath,tEnglish,lname,lid,lKorean,lMath,lEnglish);
		Scene scene=new Scene(ap);
		stage.setScene(scene);
		stage.show();
	}
	
	public ObservableList<Student> getStList() {
		Connection conn=DBConnection.getConnection();
		ObservableList<Student> sts=FXCollections.observableArrayList();
		try {
		String sql="select * from new_st";
		PreparedStatement pstmt=conn.prepareStatement("select * from new_st");
		ResultSet rs=pstmt.executeQuery();
		int idx=0;
		while(rs.next()) {
			Student st=new Student(rs.getInt("id"),rs.getString("name"),
					rs.getInt("Korean"),rs.getInt("English"),
					rs.getInt("Math"));
			int id=rs.getInt("id");
			st.setId(id);
			String name=rs.getString("name");
			st.setName(name);
			int Korean=rs.getInt("Korean");
			st.setKorean(Korean);
			int English=rs.getInt("English");
			st.setEnglish(English);
			int Math=rs.getInt("Math");
			st.setMath(Math);
			sts.add(st);
			
		}
		System.out.println("---- end of data --");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return sts;
	}
	
	
	
	public void handleBtnChartAction() {
		Stage stage=new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);
		try {
			Parent chart =FXMLLoader.load(getClass().getResource("BarChart.fxml"));
			Scene scene=new Scene(chart);
			stage.setScene(scene);
			stage.show();
			
			Button btnClose=(Button)chart.lookup("#btnClose");
			btnClose.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					if(event.getClickCount()==1)
						stage.close();
				}
				
			});
		
			//chart 가져와서 series를 추가해야한다.
			
			BarChart barChart=(BarChart) chart.lookup("#barChart");
			
			
			//수학
			
			XYChart.Series<String, Integer> seriesM=new XYChart.Series<String, Integer>();
			
			seriesM.setName("수학");
			ObservableList<XYChart.Data<String, Integer>> mathList=FXCollections.observableArrayList();
			for(int i=0;i<list.size();i++) {
				mathList.add(new XYChart.Data<>(list.get(i).getName(),
						list.get(i).getKorean()));
			}
			seriesM.setData(mathList);
			barChart.getData().add(seriesM);
			
			//국어 category
			XYChart.Series<String, Integer> seriesK=new XYChart.Series<String, Integer>();
			
			seriesK.setName("국어");
			ObservableList<XYChart.Data<String, Integer>> koreanList=FXCollections.observableArrayList();
			for(int i=0;i<list.size();i++) {
				koreanList.add(new XYChart.Data<>(list.get(i).getName(),
						list.get(i).getKorean()));
			}
			
			seriesK.setData(koreanList);
			barChart.getData().add(seriesK);
			
			
			//영어
			
			XYChart.Series<String, Integer> seriesE=new XYChart.Series<String, Integer>();
			
			seriesE.setName("영어");
			ObservableList<XYChart.Data<String, Integer>> engList=FXCollections.observableArrayList();
			for(int i=0;i<list.size();i++) {
				engList.add(new XYChart.Data<>(list.get(i).getName(),
						list.get(i).getKorean()));
			}
			seriesE.setData(engList);
			barChart.getData().add(seriesE);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//
	
	
	//추가화면 보여주는 작업.
	public void handleBtnAddAction() {
		Stage stage=new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btnAdd.getScene().getWindow());//나중에 추가..설명.
		
		try {
			Parent parent =FXMLLoader.load(getClass().getResource("AddForm.fxml"));
			Scene scene=new Scene(parent);
			stage.setScene(scene);
			stage.show();
			//추가 컨트롤 사용하기.
			Button btnFormAdd=(Button) parent.lookup("#btnFormAdd");
			btnFormAdd.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					TextField txtId=(TextField) parent.lookup("#txtId");
					TextField txtName=(TextField) parent.lookup("#txtName");
					TextField txtKorean= (TextField) parent.lookup("#txtKorean");
					TextField txtMath=(TextField) parent.lookup("#txtMath");
					TextField txtEnglish=(TextField) parent.lookup("#txtEnglish");
					Student student=new Student(Integer.parseInt(txtId.getText()), txtName.getText(),Integer.parseInt(txtKorean.getText()),
							Integer.parseInt(txtMath.getText()),
							Integer.parseInt(txtEnglish.getText())  );
					
					list.add(student);
					//추가화면 닫기.
					stage.close();
				}
			});
			Button btnFormCancel=(Button)parent.lookup("#btnFormCancel");
			btnFormCancel.setOnAction(e->{
				TextField txtName=(TextField) parent.lookup("#txtName");
				TextField txtKorean= (TextField) parent.lookup("#txtKorean");
				TextField txtMath=(TextField) parent.lookup("#txtMath");
				TextField txtEnglish=(TextField) parent.lookup("#txtEnglish");
				txtName.clear();
				txtKorean.clear();
				txtMath.clear();
				txtEnglish.clear();
			});
		
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
