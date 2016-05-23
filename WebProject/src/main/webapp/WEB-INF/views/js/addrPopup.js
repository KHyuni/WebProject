	
function changeValue(){
		var sido_name = $("select[name=selectBox1]").val();
		
		if(sido_name != null){
			$.ajax({
				type : "POST", 
				url : "addrSearch",
				data : {"sido_name":sido_name},
				dataType : "html", 
				error : function(request, status, error) {
			         alert("에러!!");
			         alert(request.status);
			         return;
			      }
			      , success : function(response, status, request) {
			  		 var sigungu = request.responseText;
			    	 $("#selectBox2").html(sigungu);
			      }
			});
		}
	}


function checkBtn(checkForSearch){
		if(checkForSearch == "1"){
			innerBox2.style.display='';
			innerBox3.style.display='none';
		} else if(checkForSearch == "2"){
			innerBox3.style.display='';
			innerBox2.style.display='none';
		}

} 

