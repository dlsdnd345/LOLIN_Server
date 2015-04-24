

$( document ).ready(function() {

	//푸시
	sendPush();
	
});


/**
 * 푸시
 */
function sendPush(){
	
	$(".push").click(function() {
		  
		var message = $("#inputPushMessage").val();
		
		console.log("message  : " +message);

		
		$.ajax({
            url: "/gcm/sendAll",
            type: 'GET',
            data: { 
            	message : message
            },
            dataType: 'json',
            success: function(data){
            
            	alert(data["data"]);	
            },
            error: function(xhr, status, error) {
            	alert('오류가 발생 했습니다.');
           }// end
        });// end ajax
		
		
	});
	
}