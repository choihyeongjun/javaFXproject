package project;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Info {
	SimpleStringProperty id;
	SimpleIntegerProperty password;
	
	public Info() {
		
	}
	public Info(String id,int password) {
		this.id=new SimpleStringProperty(id);
		this.password=new SimpleIntegerProperty(password);
	}
	public String getId() {
		return id.get();
	}
	public void setId(String id) {
		this.id.set(id);
	}
	
	public void setPassword(int password) {
		this.password.set(password);
	}
	public int getPassword() {
		return password.get();
	}
}
