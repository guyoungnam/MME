<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="MemberAddServlet" method="get" name="userInfo" onsubmit="return checkValue()">
아이디:<input type="text" name="userid" id="userid">
<span id="result"></span>
<input type="button" value="중복확인" onClick="openIdChk()">	
<input type="hidden" name="idDuplication" value="idUncheck">
<br> 
암호:<input type="text" name="passwd" id="passwd"><br> 
암호확인:<input type="text" name="passwd2" id="passwd2">
<span id="result2"></span>
<br> 
이름:<input type="text" name="username"><br> 

닉네임:<input type="text" name="nickname"><br>

전화번호:<select name="phone1">
  <option value="010">010</option>
  <option value="011">011</option>
</select>-
<input type="text" name="phone2" >-<input type="text" name="phone3" >
<br>

사업자번호: <input type="text" name="seller_num"><br>
사업자대표: <input type="text" name="seller_name"><br>

<input type="text" name="post" id="sample4_postcode" placeholder="우편번호">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" name="addr1" id="sample4_roadAddress" placeholder="도로명주소"><br>
<input type="text" name="addr2" id="sample4_jibunAddress" placeholder="지번주소">
<span id="guide" style="color:#999"></span>
<br>


<input type="submit" value="저장/수정">
<input type="reset" value="초기화">
</form>

<script>

//아이디 중복 여부 판단
function checkValue(){
	var form = document.userInfo;
	
	if(!form.id.value){
		alert("아이디를 입력하세요.");
	    return false;
	}
	if(!form.idDuplication.value !="idCheck"){
		alert("아이디 중복 체크를 해주세요.");
		return false;
	}
	if(!form.passwd.value){
		alert("비밀번호를 다시 입력 하세요");
		return false;
	}
	if(!form.passwd.value !=form.passwd2.value){
		alert("비밀번호를 동일 하게 입력하세요");
		return false;
	}
    if(!form.name.value){
    	alert("이름을 입력하세요");
    	return false;
    }

   function openIdChk(){
	   window.name = "parentform";
	   window.open = "member/IdCheckForm.jsp","chkForm,width=500, height=300, resizable=no, scrollbar=no");
		   }
   //아이디 입력창에 값 입력시 hidden에 idUncheck를 세팅한다.
   //이렇게 하는 이유는 중복체크 후 다시 아이디창이 새로운 아이디를 입력했을 때 
   // 다시 중복체크를 하도록 한다.
   
   function inputIdchk(){
	   document.userInfo.idDuplication.value="idUncheck";
   }
   
   }

</script>


<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>