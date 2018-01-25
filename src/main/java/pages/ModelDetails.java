package pages;

public class ModelDetails {
private String name;
private String price;
private String storageSpace;

public ModelDetails(String name,String price, String storageSpace) {
	this.name= name;
	this.price = price;
	this.storageSpace = storageSpace;
}

public ModelDetails(String name, String price) {
	super();
	this.name = name;
	this.price = price;
}

public String getStorageSpace() {
	return storageSpace;
}

public void setStorageSpace(String storageSpace) {
	this.storageSpace = storageSpace;
}

public void setName(String name) {
	this.name= name;
}

public void setPrice(String price) {
	this.price = price;
}
public String getName() {
	return name;
	
}

public String getPrice() {
	return price;
	
}

public String toString() {
	return "Name of Largest Model is: " + name + " And the Price of Largest Model is: " + price;
	
}
}
