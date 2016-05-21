	
function changeValue(val){
		var sido_name = $("select[name=selectBox1]").val();
		
		if(sido_name != null || sido_name.equals("")){
			alert("시/도 : "+sido_name);
			$.ajax({
				type : "POST", 
				url : "/addrSearch",
				data : {"sido_name":sido_name},
				success : function(data){
					alert('success()');
				/*	$("#selectBox2").each(function(){
							$("#selectBox2 option:eq(0)").remove();
					});
					$("#selectBox2").append("<option value=''>::도시선택::</option>");*/
					
/*					for(var idx=0; idx<data.length; idx++){
						$("#selectBox2").append("<option value=""+data")
					}*/
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

