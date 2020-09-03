package basic.control.chart;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import basic.common.ConnectionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;

public class ChartController implements Initializable{
	@FXML
	PieChart pieChart;
	@FXML
	BarChart barChart;
	@FXML
	AreaChart areaChart;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ObservableList<Data>list=FXCollections.observableArrayList();
		list.add(new PieChart.Data("AWT", 10));
		list.add(new PieChart.Data("Swing",30));
		list.add(new PieChart.Data("SWT", 25));
		list.add(new PieChart.Data("JavaFx", 35));
		pieChart.setData(list);
		
		XYChart.Series<String, Integer>list1=new XYChart.Series<>();
		list1.setName("남자다잉");
		list1.setData(getSeries1());
		barChart.getData().add(list1);
		XYChart.Series<String, Integer>list2=new XYChart.Series<>();
		list2.setName("요자");
		list2.setData(getSeries2());
		barChart.getData().add(list2);
		//areachart
		XYChart.Series<String, Integer>s1=new XYChart.Series<>();
		s1.setName("온도");
		s1.setData(getSeries3());
		areaChart.getData().add(s1);
		XYChart.Series<String, Integer>s2=new XYChart.Series<>();
		s2.setName("Covid19");
		s2.setData(getSeries4());
		areaChart.getData().add(s2);
		
	}
	public ObservableList<XYChart.Data<String, Integer>> getSeries1() {
		ObservableList<XYChart.Data<String, Integer>>list=FXCollections.observableArrayList();
		list.add(new XYChart.Data<String,Integer>("2015",60));
		list.add(new XYChart.Data<String,Integer>("2016",80));
		list.add(new XYChart.Data<String,Integer>("2017",20));
		list.add(new XYChart.Data<String,Integer>("2018",95));
		return list;
	}
	public ObservableList<XYChart.Data<String, Integer>> getSeries2() {
		ObservableList<XYChart.Data<String, Integer>>list=FXCollections.observableArrayList();
		list.add(new XYChart.Data<String,Integer>("2015",30));
		list.add(new XYChart.Data<String,Integer>("2016",15));
		list.add(new XYChart.Data<String,Integer>("2017",40));
		list.add(new XYChart.Data<String,Integer>("2018",65));
		return list;
	}
	public ObservableList<XYChart.Data<String, Integer>> getSeries3() {
		Connection conn=ConnectionDB.getDB();
		String sql="select * from receipt";
		ObservableList<XYChart.Data<String, Integer>>list=FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new XYChart.Data<>
				(rs.getString("receipt_month"),rs.getInt("receipt_qty")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public ObservableList<XYChart.Data<String, Integer>> getSeries4() {
		ObservableList<XYChart.Data<String, Integer>>list=FXCollections.observableArrayList();
		
		list.add(new XYChart.Data<String,Integer>("09",5));
		list.add(new XYChart.Data<String,Integer>("10",7));
		list.add(new XYChart.Data<String,Integer>("11",12));
		list.add(new XYChart.Data<String,Integer>("12",20));
		return list;
	}
	public void method1() {
		
	}
	
}
