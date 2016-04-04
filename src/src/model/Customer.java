/*
 * COMP 6302 - Web Services / Internet
 * PA1: Hotel Reservation System
 * Marc Badrian and Hien Vo - Due 3/5/16
 * 
 */

package src.model;

public class Customer {

	private int customer_id;
	private String first_name;
	private String last_name;
	private String phone_number;
	private String billing_address;
	private String billing_city;
	private String billing_state;
	private String billing_zip;
	private String checkin_date;
	private String checkout_date;
	
	// getter methods
	public int getId() {
		return customer_id;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public String getNumber() {
		return phone_number;
	}
	
	public String getBillingAddress() {
		return billing_address;
	}
	
	public String getBillingCity() {
		return billing_city;
	}
	
	public String getBillingState() {
		return billing_state;
	}
	
	public String getBillingZip() {
		return billing_zip;
	}
	
	public String getCheckinDate() {
		return checkin_date;
	}
	
	public String getCheckoutDate() {
		return checkout_date;
	}

	// setter methods
	//public void setCustomerId(int customer_id) {
	//	this.customer_id = customer_id;
	//}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public void setNumber(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public void setBillingAddress(String billing_address) {
		this.billing_address = billing_address;
	}
	
	public void setBillingCity(String billing_city) {
				this.billing_city = billing_city;
	}
	
	public void setBillingState(String billing_state) {
				this.billing_state = billing_state;
	}
	
	public void setBillingZip(String billing_zip) {
				this.billing_zip = billing_zip;
	}
	
	public void setCheckIn(String checkin_date) {
		this.checkin_date = checkin_date;
	}
	
	public void setCheckOut(String checkout_date) {
		this.checkout_date = checkout_date;
	}
	
}
