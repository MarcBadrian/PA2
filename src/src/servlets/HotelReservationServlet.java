/*
 * COMP 6302 - Web Services / Internet
 * PA1: Hotel Reservation System
 * Marc Badrian and Hien Vo - Due 3/5/16
 * 
 */

package src.servlets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.model.Customer;
import src.model.Transaction;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class EchoServlet
 */
@WebServlet(name = "HotelReservationServlet",
description = "This is my first annotated servlet",
urlPatterns = {"/HotelReservationServlet", "/Reservations", "/Customer", "/Transactions"})
public class HotelReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//out.println(choice);
	private static final String dbName = "Hotel_Reservation_System";
	private static final MysqlConnector connector = new MysqlConnector();
	Connection conn = connector.getConnection();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public HotelReservationServlet() {
        super();
    }

    public void init() throws ServletException
    {
		connector.createDB(conn, dbName);
		connector.createCustomersTable(conn);
		connector.createRoomsTable(conn);
		connector.createTransactionsTable(conn);
		connector.populateRooms(conn);
    };

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	MysqlConnector connector = new MysqlConnector();
		Integer choice = Integer.parseInt(request.getParameter("choice"));
		PrintWriter out = response.getWriter();
		//out.println(choice);
		
		try {
			
			switch (choice) {
			case 4: 
				Integer customer_id = Integer.parseInt(request.getParameter("customer_id"));
				String info = connector.getCustomer(customer_id);
				out.println("<br>" + info);
				break;
			case 5:
				String first_name = request.getParameter("first_name");
				String last_name = request.getParameter("last_name");
				String custsByName = connector.getCustomersByName(first_name, last_name);
				out.println("\n" + custsByName);
				break;
			case 6:
				String custsCurrent = connector.getCustomersCurrent();
				out.println("\n" + custsCurrent);
				break;
			case 7:
				Integer c_id = Integer.parseInt(request.getParameter("customer_id"));
				String transactions = connector.getTransactions(c_id);
				out.println("\n" + transactions);
				break;
			case 8:
				String vacancies = connector.getVacancies();
				out.println("\n" + vacancies);
				break;
			case 9:
				String reservations = connector.getReservations();
				out.println("\n" + reservations);
				break;
			};
			} catch (Exception e) {
				System.out.println("That is not a valid entry.");
				//TODO Auto-generated catch block
				e.printStackTrace();
	};

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    	MysqlConnector connector = new MysqlConnector();
				Integer choice = Integer.parseInt(request.getParameter("choice"));

				PrintWriter out = response.getWriter();
				
				try {
					
					switch (choice) {
					case 1: 
						// 1. get received JSON data from request
				        BufferedReader cust_br = new BufferedReader(new InputStreamReader(request.getInputStream()));
				        String cust = "";
				        if(cust_br != null){
				            cust = cust_br.readLine();
				        }
				        // 2. initiate jackson mapper
				        ObjectMapper cust_mapper = new ObjectMapper();		 
				        // 3. Convert received JSON to Customer
						Customer customer = cust_mapper.readValue(cust, Customer.class);
		        		//System.out.println(customer);
						String first_name = customer.getFirstName();
						String last_name = customer.getLastName();
						boolean success = connector.insertCustomer(customer);
						int id = connector.getCustomerId(first_name, last_name);
						response.setContentType("text/html");
						if(!success){
						      out.println("<h1>" + "Error!" + "</h1>");
						      break;
						}else{
							out.println("<h1>" + "You have successfully created a new customer!" + "\n" + "Customer id: " + id  + "</h1>");
						      break;
						}
					case 2:
						int customer_id = Integer.parseInt(request.getParameter("customer_id"));
						int room_number = Integer.parseInt(request.getParameter("room_number"));
						boolean reserved = connector.reserveRoom(customer_id, room_number);

						response.setContentType("text/html");
						if(!reserved){
						      out.println("Error!");
						      break;
						}else{
							out.println("You have successfully reserved room: " + room_number + " for customer id: " + customer_id);
						      break;
						}
					case 3:
						// 1. get received JSON data from request
				        BufferedReader br_trans = new BufferedReader(new InputStreamReader(request.getInputStream()));
				        String trans = "";
				        if(br_trans != null){
				            trans = br_trans.readLine();
				        }
				        // 2. initiate jackson mapper
				        ObjectMapper trans_mapper = new ObjectMapper();		 
				        // 3. Convert received JSON to Customer
						Transaction transaction = trans_mapper.readValue(trans, Transaction.class);
						Integer cust_id = transaction.getCustomerId();
						Integer room_id = transaction.getRoomNumber();
						float amount = (float) transaction.getAmount();
						String cc_number = transaction.getCCNumber();
						String exp_date = transaction.getExpDate();
						boolean transaction_bool = connector.createPayment(cust_id, room_id, amount, cc_number, exp_date);
						int transaction_id = connector.getTransactionId(cust_id, room_id);
						response.setContentType("text/html");
						if(!transaction_bool){
						      out.println("Error!");
						      break;
						}else{
							out.println("You have successfully submitted a payment! Your transaction id number is: " + transaction_id);
						      break;
						}
					};
				} catch (Exception e) {
					System.out.println("That is not a valid entry.");
					e.printStackTrace();

				};

			}

		
	}