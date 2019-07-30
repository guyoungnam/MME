<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복 체크</title>
<script type="text/javascript">
var httpRequest = null;

//httpRequest 객체 생성
function getXMlHttpRequeset(){
	var httpRequest = null;
	
	if(window.ActiveXObject){
		try{
			httpRequest = new ActiveXObject("Msxm12.XMLHTTP");
		}catch(e){
			try{
				httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e2){httpRequest=null;}
		}
	}
	else if(window.XMLHttpRequest){
		httpRequest = new window.XMLHttpRequest();
	}
	return httpRequest;
}

//회원가입창의 아이디 입력간의 값을 가져온다.
function pValue(){
	document.getElementById("userId").value = opener.documenet.userInfo.id.value;
}

//아이디 중복체크
function idCheck(){
	var id = document.getElementById("userId").value;
	
	if(!id){
		alert("아이디를 입력하지 않습니다.");
	    return false;
	}
	else if((id<"0"||id>"9")&&(id<"A"||id>"Z")&&(id<"a"||id>"z")){
		alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
		return false;
	}
	else
		{
		var param="id="+id
		httpRequest = getXMlHttpRequeset();
		httpRequest = onreadystatechange = callback;
		
		}
}

</script>
</head>
<body>

</body>
</html>