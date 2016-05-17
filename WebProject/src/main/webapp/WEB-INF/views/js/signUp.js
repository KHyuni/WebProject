jQuery(function($){
	var re_id = /^.*(?=.{6,16})(?=.*[0-9])(?=.*[a-zA-Z]).*$/i;	//아이디 영문,숫자 조합 6~16자리 체크
	var re_id1 = /[\s,!,@,#,$,%,^,&,*,?,_,~]/gi;	//아이디 특수 문자 불가
	var re_pw = /([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/gi;	//비밀번호 영문,특수문자 조합
	var re_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; // 이메일 검사식
	var form = $('#frm');
	var userId = $('#userId');
	var userPwd = $('#userPwd');
	var userPwd1 = $('#userPwd1');
	var userName = $('#userName');
	var userGender = $("input:radio[name='userGender']:radio[value='남자']").attr("checked",true);
	var userAddr1 = $('#userAddr1');
	var userAddr2 = $('#userAddr2');
	var userPhone = $('#userPhone');
	var userEmail = $('#userEmail');
	
	
	$('#userId').blur(function(){
		$.ajax({
			type : "POST",
			url : "idCheck",
			data : {
				"userId" : $('#userId').val()
			}, 
			success : function(data){
				if($.trim(data) == "YES"){
					if($('#userId').val().length < 6){
						$('#idChkMsg').html('<b style="font-size:11px;color:red">아이디는 반드시 6자리 이상이여야 합니다.</b>');
					}else if(re_id.test(userId.val()) != true){
						$('#idChkMsg').html('<b style="font-size:11px;color:red">영문,숫자 조합 6자리 이상이여야 합니다.</b>');
					}else if(re_id1.test(userId.val()) == true){
						$('#idChkMsg').html('<b style="font-size:11px;color:red">특수 문자 및 공백은 허용되지 않습니다.</b>');
					}else{
						$('#idChkMsg').html('<b style="font-size:11px;color:blue">입력하신 아이디는 사용 가능합니다.</b>');
					}	
				}else if($.trim(data) == "NO"){
					$('#idChkMsg').html('<b style="font-size:11px;color:red">이미 존재하는 아이디 입니다.</b>');	
				}else{
					$('#idChkMsg').html('<b style="font-size:11px;color:red">아이디가 입력되지 않았습니다.</b>');
				}
			}
		});
	});
	
	$('.searchAddr').click(function(){
		window.open('addrPopup', '_blank', 'width=650, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no');
	});
	
	form.submit(function(){
		if(re_id.test(userId.val()) != true) {
			alert('다시 한 번 아이디를 확인 하여 주시기 바랍니다.');
			userId.focus();
			return false;
		} else if(re_id1.test(userId.val()) == true) {
			alert('아이디에는 특수문자가 허용되지 않습니다.');
			userId.focus();
			return false;
		}
		  else if(re_pw.test(userPwd.val()) != true) {
			alert('비밀번호를 6자리 이상 영문, 숫자, 특수문자 \n조합으로 입력 하셔야 합니다.');
			userPwd.focus();
			return false;
		} else if(jQuery(userPwd1).val() != jQuery(userPwd).val()) {
			alert('비밀번호가 같지 않습니다. 다시 확인 하여 주십시요.');
			userPwd1.focus();
			return false;
		} else if(jQuery(userName).val() == null || jQuery(userName).val() == '') {
			alert('이름을 입력해 주세요.');
			userName.focus();
			return false;
		} else if(jQuery(userAddr1).val() == null || jQuery(userAddr1).val() == '') {
			alert('주소를 입력해 주세요.');
			userAddr1.focus();
			return false;
		} else if(jQuery(userAddr2).val() == null || jQuery(userAddr2).val() == '') {
			alert('나머지 주소를 입력해 주세요.');
			userAddr2.focus();
			return false;
		} else if(jQuery(userPhone).val() == null || jQuery(userPhone).val() == '') {
			alert('전화번호를 입력하지 않았거나,\n유효하지 않은 번호를 입력 하였습니다.');
			userPhone.focus();
			return false;
		} else if(re_email.test(userEmail.val()) != true) {
			alert('이메일 주소가 올바르지 않습니다.');
			userEmail.focus();
			return false;
		}
	});
});