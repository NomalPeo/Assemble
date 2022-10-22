/**
 * member.js
 */

function join_check() {
    if ($.trim($("#user_id").val()) == "") {
        alert("회원아이디를 입력하세요!");
        $("#user_id").val("").focus();
        return false;
    }
    const user_pwd = $.trim($("#user_pwd").val());
    const user_pwd2 = $.trim($("#user_pwd2").val());
    if (user_pwd == "") {
        alert("비번을 입력하세요!");
        $("#user_pwd").val("").focus();
        return false;
    }
    if (user_pwd2 == "") {
        alert("비번확인을 입력하세요!");
        $("#user_pwd2").val("").focus();
        return false;
    }
    if (user_pwd != user_pwd2) {
        alert("비번이 다릅니다!");
        $("#user_pwd").val(""); //비번 입력박스를 초기화
        $("#user_pwd2").val("");
        $("#user_pwd").focus();
        return false;
    }
    if ($.trim($("#user_name").val()) == "") {
        alert("회원이름을 입력하세요!");
        $("#user_name").val("").focus();
        return false;
    }

    if ($.trim($("#user_nickname").val()) == "") {
        alert("닉네임을 입력하세요!");
        $("#user_nickname").val("").focus();
        return false;
    }
}

//중복아이디 검색
function id_check() {
    /* copy begin */

    const id_check_dom = $("#idcheck");
    id_check_dom.hide();

    //아이디 영역을 숨김
    const user_id = $.trim($("#user_id").val());

    //1.입력글자 길이 체크
    if (user_id.length < 4) {
        const newtext = '<font color="red" size="3"><b>아이디는 4자 이상이어야 합니다.</b></font>';
        id_check_dom.text('');
        //idcheck 아이디 영역 문자열을 초기화
        id_check_dom.show();
        //idcheck 아이디 영역을 보이게 함.
        id_check_dom.append(newtext);
        //idcheck영역에 문자열을 추가
        $("#user_id").val('').focus();
        return false;
    }
    if (user_id.length > 12) {
        const newtext = '<font color="red" size="3"><b>아이디는12자 이하이어야 합니다.</b></font>';
        id_check_dom.text('');
        //idcheck 아이디 영역 문자열을 초기화
        id_check_dom.show();
        //idcheck 아이디 영역을 보이게 함.
        id_check_dom.append(newtext);
        //idcheck영역에 문자열을 추가
        $("#user_id").val('').focus();
        return false;
    }
    //2.입력글자 확인
    if (!(validate_userid(user_id))) {
        const newtext  = '<font color="red" size="3"><b>아이디는 영문소문자,숫자,_조합만 가능합니다.</b></font>';
        id_check_dom.text('');
        id_check_dom.show();
        id_check_dom.append(newtext);
        id_check_dom.val('').focus();
        return false;
    }
    const token = $("meta[name='_csrf']").attr("content");
    const header = $("meta[name='_csrf_header']").attr("content");
    //디버그용
		
		


    $.ajax({
        type: "POST",
        url: "./users_idcheck",
        data: {
            "id": user_id
        },
        dataType: "json",
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            console.log(data)
            const id_check_dom =  $("#idcheck");

                        if (data ==1) {
                const newtext = '<font color="red" size="3"><b>중복 아이디입니다.</b></font>';
                id_check_dom.text('');
                id_check_dom.show();
                id_check_dom.append(newtext);
                $("#user_id").val('').focus();
                return false;
            
            } else {
                const newtext = '<font color="blue" size="3"><b>사용가능한 아이디입니다.</b></font>';
                id_check_dom.text('');
                id_check_dom.show();
                id_check_dom.append(newtext);
                $("#user_pwd").focus();
            }
        },
        error: function () {
            alert("data error");
        }
    });
    /* end */
}

//정규표현식
function validate_userid($mem_id) {
    const pattern = new RegExp(/^[a-z0-9_]+$/); //아이디를 영문소문
    //자와 숫자 와 _조합으로 처리
    return pattern.test($mem_id);
}

//메일 주소 선택과 직접입력
function domain_list() {
    const num = m.mail_list.selectedIndex; //선택한 목록 항목 번호
    if (num == -1) { //목록이 선택되지 않았을때 실행
        return true;
    }
    if (m.mail_list.value == "직접입력") {
        m.email_domain.value = "";
        m.email_domain.readOnly = false; //쓰기 가능
        m.email_domain.focus(); //입력박스로 포커스 이동
    } else { //목록에서 멜주소를 선택한 경우
        m.email_domain.value = m.mail_list.options[num].value;
        //목록 옵션 value값이 멜도메인 입력박스로 입력
        m.email_domain.readOnly = true; //읽기만 가능
    }
} //domain_list()