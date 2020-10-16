<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
    <link rel="stylesheet" type="text/css" href="../css/common.css">
</head>

<body>
<div class="section"></div>
<main>
	<div style="text-align:center;">
        <img class="responsive-img" style="width: 250px;" src="https://i.imgur.com/ax0NCsK.gif" />
        <div class="section"></div>

        <div class="section"></div>

        <div class="container">
            <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE; width: 305px;">
                <form class="col s12" method="post" action="<%=request.getContextPath() %>/join/emailSend">
                    <div class='row'>
                        <div class='col s12'>
                        </div>
                    </div>

                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate' type='email' name='email' id='email'/>
                            <label for='email'>이메일</label>
                        </div>
                    </div>

                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate' type='password' name='password' id='password' />
                            <label for='password'>비밀번호</label>
                        </div>
                    </div>
                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate' type='text' name='phoneNum' id='phoneNum' />
                            <label for='phoneNum'>핸드폰번호</label>
                        </div>
                    </div>

                    <br/>
					<div style="text-align:center;">
                        <div class='row'>
                            <button type='submit' name='btn_join' id= btn_join class='col s12 btn btn-large waves-effect indigo'>회원가입</button>
                        </div>
					</div>
                </form>
            </div>
        </div>
	</div>

    <div class="section"></div>
    <div class="section"></div>
</main>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>

	$("#btn_join").click(function(){
	    var email = isEmail ( $("#email").val() );
	    var password = isValidFormPassword ( $("#password").val() );
	    if($("#email").val()=="") {
	        alert("이메일을 입력해주세요.");
	        return false;
	    }else if( $("#password").val()=="" ){
	        alert("비밀번호를 입력해주세요");
	        return false;
	    }else if(!email) {
	        alert("이메일 형식에 맞게 작성하세요");
	        return false;
	    }else if(!password){
	        alert("비밀번호는 6~16자, 영문, 숫자, 특수문자의 조합으로 입력해주세요");
	        return false;
	    }else{
	        alert("인증 메일이 전송되었습니다.")
	        $("#joinForm").submit();
	    }
	});
	
	//이메일 정규식 체크
	function isEmail(asValue) {
	    var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	    return regExp.test(asValue);
	
	}
	
	//비밀번호 정규식 체크
	function isValidFormPassword(pw) {
	    var check = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,16}$/;
	
	    if (!check.test(pw)) {
	        return false;
	    }
	    return true;
	}
	//"<a href='http://localhost:3000/join/auth?email="+ email +"&password="+ password +"&phoneNum="+ phoneNum +"'>인증하기</a>"
</script>

</body>

</html>