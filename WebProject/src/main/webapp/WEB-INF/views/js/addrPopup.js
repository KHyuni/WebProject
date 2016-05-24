	
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

function searchBtn(){
	var sido_name = $("select[name=selectBox1]").val();
	var sigungu_name = $("select[name=selectBox2]").val();
	var road_name = $("#roadName").val();
	var bonbun = $("#buildingBonbun").val();
	var bubun = $("#buildingBubun").val();
	var buildingName = $("#buildingName").val();
	var zipcode = $("#zipcode").val();

	if(buildingName == null || buildingName == ""){
		if(bonbun != null){
			$.ajax({
				type:"POST", 
				url:"addrSearch1",
				data:{"sido_name":sido_name,"sigungu_name":sigungu_name,"road_name":road_name,"buildingName":buildingName,"zipcode":zipcode},
				dataType:"html",
				error:function(){
					alert("에러!!");
				},
				success:function(data){
						$("#fullAddress").html(data);
						//해당 지역에 데이터가 없을 경우 처리 필요.
						//서초구=서초대로(O), 마포구=서초대로(X) 일 경우 기존 검색 되어진 리스트 화면에서 삭제
				}
			});
		}else{
			$.ajax({
				type:"POST", 
				url:"",
				data:{},
				dataType:"html",
				error:function(){
					
				},
				success:function(){
					
				}
			});
	    }
	}else{
		$.ajax({
			type:"POST", 
			url:"",
			data:{},
			dataType:"html",
			error:function(){
				
			},
			success:function(){
				
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

