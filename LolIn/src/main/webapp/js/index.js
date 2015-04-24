

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
            	
            	if(isOk){
            		location.href = "/push";
            	}else{
            		alert("비밀번호 , 아이디가 틀렸습니다.");
            	}
            	
            },
            error: function(xhr, status, error) {
            	alert(error);
           }// end
        });// end ajax
		
		
	});
	
}