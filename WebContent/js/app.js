$(document).ready(function(){
$("#create_customer_information").hide();
$("#reserve").hide();
$("#create_payment").hide();
$("#get_customer_id").hide();
$("#get_customer_name").hide();
$("#get_customer_current").hide();
$("#get_transactions").hide();
$("#get_vacancies").hide();
$("#get_reservation").hide();

    $("#create_customer_button").click(function(){
        $("#create_customer_information").show();
    });
    $("#reserve_room_button").click(function(){
        $("#reserve").show();
    });
    $("#create_payment_button").click(function(){
        $("#create_payment").show();
    });
    $("#get_customer_id_button").click(function(){
        $("#get_customer_id").show();
    });
    $("#get_customer_name_button").click(function(){
        $("#get_customer_name").show();
    });
    $("#get_customer_current_button").click(function(){
        $("#get_customer_current").show();
    });
    $("#get_transactions_button").click(function(){
        $("#get_transactions").show();
    });
    $("#get_vacancies_button").click(function(){
        $("#get_vacancies").show();
    });
    $("#get_reservation_button").click(function(){
        $("#get_reservation").show();
    });
});

//function to Create a new Customer
$("#submit_customer_button").click(function(){
    $("#hide").click(function(){
        $("#create_customer_information").hide();
    });
	console.log('CREATE CUSTOMER');
	var data = new Object();
	data.choice = "1";
	data.fname = $("#first_name").val();
	data.lname = $("#last_name").val();
	data.number = $("#phone_number").val(); 
	data.address = $("#billing_address").val();
	data.city = $("#billing_city").val();
	data.state = $("#billing_state").val();
	data.zip = $("#billing_zip").val();
	data.checkin = $("#checkin_date").val();
	data.checkout = $("#checkout_date").val();
	$.ajax({
		type: 'POST',
        contentType: 'application/json',
        url: '/PA2',
        dataType: "json",
        data: JSON.stringify(data),
		success: function(data){
			$("#hotelHeader").html("Success!");
			alert('Customer saved successfully.');
			//var res=JSON.parse(AJAX.responseText)
			alert(data);
			//alert(res);
		},
		error: function(data,status,xhr){
			$("#hotelHeader").html("Error occurred.");
			alert(data);
			alert(status);
			alert(xhr.responseText);
		},
	});
	
});

//function to Reserve a Room
$("#submit_reserve_room_button").click(function(){
	console.log('RESERVE ROOM');
	var data = new Object();
	data.choice = "2";
	data.customerId = $("#customerIdField").val();
	data.roomNum = $("#roomNumField").val();
	$.ajax({
		type: 'POST',
        contentType: 'application/json',
        url: '/PA2',
        dataType: "json",
        data: JSON.stringify(data),
		success: function(data,status,xhr){
			alert('Room ' + roomNum + ' was reserved successfully for customer with id #' + custId + '.');
			var res=JSON.parse(AJAX.responseText)
			alert(data);
			alert(res);
		},
		error: function(data,status,xhr){
			$("#hotelHeader").html("Error occurred.");
		},
	});
	
});


//function to Create a Payment
$("#submit_payment_button").click(function(){
	console.log('CREATE PAYMENT');
	var data = new Object();
	data.choice = "3";
	data.customerId = $("#customerIdField").val();
	data.roomNum = $("#roomNumField").val();
	data.amount = $("#amountField").val();
	data.ccNum = $("#ccNumField").val();
	data.expDate = $("#expDateField").val();
	$.ajax({
		type: 'POST',
        contentType: 'application/json',
        url: '/PA2',
        dataType: "json",
        data: JSON.stringify(data),
		success: function(data,status,xhr){
			alert('Payment transaction #' + transId + ' has been successfully processed.');
			var res=JSON.parse(AJAX.responseText)
			alert(data);
			alert(res);
		},
		error: function(data,status,xhr){
			$("#hotelHeader").html("Error occurred.");
		},
	});
	
});

//function that gets the customer with the specified id and prints that customer’s information.
$("#submit_get_customer_id_button").click(function(){
	
	var id = $("#idField").val();
	data: id
	$.ajax({
		url:"/PA2",
		method:"GET",
		dataType: "json",
		success: function(data,status,xhr){
			$("#hotelHeader").html(data);
		},
		error: function(data,status,xhr){
			$("#hotelHeader").html("Error occurred.");
		},
	});
	
});

//function that gets the customer with the specified name and prints that customer’s information.
$("#submit_get_customer_name_button").click(function(){
	var data = new Object();
	data.choice = "3";
	data.id = 
	$.ajax({
		url:"/PA2",
		method:"GET",
		dataType: "json",
		success: function(data,status,xhr){
			$("#hotelHeader").html(data);
		},
		error: function(data,status,xhr){
			$("#hotelHeader").html("Error occurred.");
		},
	});
	
});

//You can get pretty much anything even other html.
$("#submit_get_customers_current_button").click(function(){
	$.get("/PA2", function(data){
		$("#hotelHeader").html(data);
	});
	
});

$("#submit_get_transactions_button").click(function(){
	$.get("/PA2", function(data){
		$("#hotelHeader").html(data);
	});
	
});

$("#submit_get_vacancies_button").click(function(){
	$.get("/PA2", function(data){
		$("#hotelHeader").html(data);
	});
	
});

$("#submit_get_reservation_button").click(function(){
	$.get("/PA2", function(data){
		$("#hotelHeader").html(data);
	});
	
});
