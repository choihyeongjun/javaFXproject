package project;

import com.sun.org.apache.bcel.internal.generic.SIPUSH;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Cinfo {
	SimpleStringProperty id;
	SimpleIntegerProperty height;
	SimpleIntegerProperty weight;
	public Cinfo() {
		
	}
	public Cinfo(String id,int height,int weight) {
		this.id=new SimpleStringProperty(id);
		this.height=new SimpleIntegerProperty(height);
		this.weight=new SimpleIntegerProperty(weight);
	}
	public int getWeight() {
		return weight.get();
	}
	public void setWeight(int weight) {
		this.weight.set(weight);
	}
	
	public int getHeight() {
		return height.get();
	}
	public void setHeight(int height) {
		this.height.set(height);
	}
	
	public void setId(String id) {
		this.id.set(id);
	}
	public String getId() {
		return id.get();
	}
	
}
