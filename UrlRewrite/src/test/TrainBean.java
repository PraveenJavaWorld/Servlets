package test;
import java.io.*;
@SuppressWarnings("serial")
public class TrainBean implements Serializable{
	private String number,name,fstation,lstation,availability;
	public TrainBean(){}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFstation() {
		return fstation;
	}
	public void setFstation(String fstation) {
		this.fstation = fstation;
	}
	public String getLstation() {
		return lstation;
	}
	public void setLstation(String lstation) {
		this.lstation = lstation;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	

}
