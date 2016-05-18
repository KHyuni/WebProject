window.onload = function(){
	checkBtn();
	changeValue();
	
	function changeValue(val){
		var sido_name = $("select[name=selectBox1]").val();
		
		
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

