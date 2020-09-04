package basic.example;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class Student {
	private SimpleIntegerProperty id;
	private SimpleStringProperty name; 
	private SimpleIntegerProperty korean; 
	private SimpleIntegerProperty math; 
	private SimpleIntegerProperty english; 
	
	
	public Student() {
		
	}
	public Student(int id,String name,int korean,int math,int english) {
		this.id=new SimpleIntegerProperty(id);
		this.name=new SimpleStringProperty(name);
		this.korean=new SimpleIntegerProperty(korean);
		this.math=new SimpleIntegerProperty(math);
		this.english=new SimpleIntegerProperty(english);
	}

	public String getName() {
		return name.get();
	}
	public void setid(int id) {
		this.id.set(id);
	}
	public int getid() {
		return id.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}

	public int getKorean() {
		return korean.get();
	}

	public void setKorean(int korean) {
		this.korean.set(korean);
	}

	public int getMath() {
		return math.get();
	}

	public void setMath(int math) {
		this.math.set(math);;
	}

	public int getEnglish() {
		return english.get();
	}

	public void setEnglish(int english) {
		this.english.set(english);
	}
	
}
