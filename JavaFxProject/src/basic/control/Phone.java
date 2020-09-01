package basic.control;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Phone {
	StringProperty model;
	IntegerProperty price;
	
	public void setModel(String model) {
		this.model.set(model);
	}

	public String getModel() {
		return this.model.get();
	}
	public void setPrice(int price) {
		this.price.set(price);
	}
	public int getPrice() {
		return this.price.get();
	}
	
}
