
//function to Create a new Customer
$("#submitCustomerButton").click(function(){
	console.log('CREATE CUSTOMER');
	var data = new Object();
	data.fname = $("#fnameField").val();
	data.lname = $("#lnameField").val();
	data.number = $("#numberField").val(); 
	data.address = $("#addressField").val();
	data.city = $("#cityField").val();
	data.state = $("#stateField").val();
	data.zip = $("#zipField").val();
	data.checkin = $("#checkinField").val();
	data.checkout = $("#checkoutField").val();
	$.ajax({
		type: 'POST',
        contentType: 'application/json',
        url: '/PA2',
        dataType: "json",
        data: JSON.stringify(data),
		success: function(data,status,xhr){
			alert('Customer saved successfully.');
			var res=JSON.parse(AJAX.responseText)
			alert(data);
			alert(res);
		},
		error: function(data,status,xhr){
			$("#hotelHeader").html("Error occurred.");
		},
	});
	
});

//function to Reserve a Room
$("#reserveRoomButton").click(function(){
	console.log('RESERVE ROOM');
	var data = new Object();
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
$("#createPaymentButton").click(function(){
	console.log('CREATE PAYMENT');
	var data = new Object();
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
$("#getCustomerButton").click(function(){
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

//You can get pretty much anything even other html.
$("#getCurrentCustomersButton").click(function(){
	$.get("/PA2", function(data){
		$("#hotelHeader").html(data);
	});
	
});

//You can even grab other javascript files using getScript
$("#deleteTodoButton").click(function(){
	var id = $("#idField").val();
	$.ajax({
		url:"/Lab4/Todo",
		method:"DELETE",
		dataType: "json",
		success: function(data,status,xhr){
			$("#todoHeader").html(data);
		},
		error: function(data,status,xhr){
			$("#todoHeader").html("Error. Why? Whhyyyyy??");
		},
		data: id
	});

});

//Helper function to serialize all the form fields into a JSON string
function formToJSON() {
    return JSON.stringify({
        "id": $('#id').val(),
        "msg": $('#msg').val(),
        });
}