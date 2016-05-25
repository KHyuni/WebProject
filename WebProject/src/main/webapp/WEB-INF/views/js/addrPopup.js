	
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
	
	if(buildingName == null || buildingName == ""){	//도로명주소 검색
		if(road_name == null || road_name == ""){
			alert('시/도, 시/군/구, 도로명 또는 건물명은 필수 입니다.');
			return;
		}else{
			if(bonbun == null || bonbun == ""){	//도로명주소[지번이 없을 경우]	
				alert("지번 없을 경우 : "+bonbun + " " +bubun);
				$.ajax({
					type:"POST", 
					url:"addrSearch1",
					data:{"sido_name":sido_name,"sigungu_name":sigungu_name,"road_name":road_name,"bonbun":bonbun,"bubun":bubun,"buildingName":buildingName,"zipcode":zipcode},
					dataType:"html",
					error:function(){
						alert("에러!!");
					},
					success:function(data){
						$("#fullAddress").html(data);
					}
				});
			}else{			    //도로명주소[지번이 있을 경우]
				alert("지번 있을 경우 : "+bonbun + " " +bubun);
				$.ajax({
					type:"POST", 
					url:"addrSearch1",
					data:{"sido_name":sido_name,"sigungu_name":sigungu_name,"road_name":road_name,"bonbun":bonbun,"bubun":bubun,"buildingName":buildingName,"zipcode":zipcode},
					dataType:"html",
					error:function(){
						alert("에러!!");
					},
					success:function(data){
						$("#fullAddress").html(data);
					}
				});	
		    }
		}
	}else if(buildingName != null){
		alert("건물명으로 검색~!!");//건물명 검색
		$.ajax({
			type:"POST", 
			url:"addrSearch3",
			data:{"sido_name":sido_name,"sigungu_name":sigungu_name,"buildingName":buildingName},
			dataType:"html",
			error:function(){
				alert("에러~!!")
			},
			success:function(data){
				alert('성공');
				$("#fullAddress").html(data);
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

