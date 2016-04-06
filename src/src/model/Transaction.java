/*
 * COMP 6302 - Web Services / Internet
 * PA1: Hotel Reservation System
 * Marc Badrian and Hien Vo - Due 3/5/16
 * 
 */

package src.model;

public class Transaction {
	
	private int id;
	private int customer_id;
	private int room_number;
	private double amount;
	private String cc_number;
	private String expiration_date;
	
	// getter methods
	public int getId() {
		return id;
	}
	
	public int getCustomerId() {
		return customer_id;
	}
	
	public int getRoomNumber() {
		return room_number;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getCCNumber() {
		return cc_number;
	}
	
	public String getExpDate() {
		return expiration_date;
	}

	// setter methods
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCustId(int customer_id) {
		this.customer_id = customer_id;
	}
	
	public void setRoomNumber(int room_number) {
		this.room_number = room_number;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setCreditCardNum(String cc_number) {
		this.cc_number = cc_number;
	}
	
	public void setExpDate(String expiration_date) {
		this.expiration_date = expiration_date;
	}

}