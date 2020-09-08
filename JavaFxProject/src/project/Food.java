package project;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Food {
	SimpleStringProperty id;
	SimpleStringProperty day;
	List<String> eat=new ArrayList<>();
	SimpleIntegerProperty cal;
	public Food(String id,String day,List<String> eat,int cal) {
		this.id=new SimpleStringProperty(id);
		this.day=new SimpleStringProperty(day);
		this.eat.addAll(eat);
		this.cal=new SimpleIntegerProperty(cal);
	}
	public Food() {
		
	}
	public void setId(String id) {
		this.id.set(id);
	}
	public String getId() {
		return id.get();
	}
	public void setDay(String day) {
		this.day.set(day);
	}
	public String getDay() {
		return day.get();
	}
	public void setCal(int cal) {
		this.cal.set(cal);
	}
	public int getCal() {
		return cal.get();
	}
	
	
	
}
