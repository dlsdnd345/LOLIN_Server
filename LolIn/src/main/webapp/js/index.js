

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
            	var isOk = data["data"];
            	
            	console.log(data["data"]);
            	
            	if(isOk){
            		location.href = "/push";
            	}else{
            		alert("비밀번호 , 아이디가 틀렸습니다.");
            	}
            	
            },
            error: function(xhr, status, error) {
            	toastr.error('오류가 발생 했습니다.');
           }// end
        });// end ajax
		
		
	});
	
}