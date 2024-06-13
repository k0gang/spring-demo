// 이벤트 핸들러 함수 정의
function submitForm(e) {
    e.preventDefault(); // 기본 동작 방지

    // 폼 데이터를 가져옵니다.
    const form = document.getElementById('updateForm');
    const formData = new FormData(form);

    // 폼 데이터를 JSON 형식으로 변환합니다.
    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });

    // JSON 데이터를 서버에 전송합니다.
    fetch('http://localhost:8080/user/update', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
    	if (response.ok){
    		window.location.href = "http://localhost:8080/user/mypage";
    	}
    })
    .then(data => {
        console.log('Success:', data);
        // 성공적인 요청 처리 후 로직 추가
    })
    .catch((error) => {
        console.error('Error:', error);
        // 에러 발생 시 로직 추가
    });
}

// DOMContentLoaded 이벤트 발생 시 폼의 submit 이벤트에 이벤트 핸들러를 추가합니다.
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('updateForm').addEventListener('submit', submitForm);
});
