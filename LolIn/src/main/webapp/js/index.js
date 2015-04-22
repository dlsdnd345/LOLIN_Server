

$( document ).ready(function() {

	//로그인
	login();
	
});


/**
 * 로그인
 */
function login(){
	
	$(".login").click(function() {
		  
		var email = $("#inputEmail").val();
		var password = $("#inputPassword").val();
		
		console.log("email  : " +email);
		console.log("password  : " +password);
		
		$.ajax({
            url: "/login/submit",
            type: 'GET',
            data: { 
            	userId : email,
            	password : password
            },
            dataType: 'json',
            success: function(data){
            	console.log(data);
            },
            error: function(xhr, status, error) {
                 
           }// end
        });// end ajax
		
		
	});
	
}