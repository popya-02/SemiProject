// 페이지 로드 시 로컬 스토리지에서 상태 읽기
    $(document).ready(function() {
        const button = $('.likeButton');
        /* const isClicked = localStorage.getItem('likeButtonClicked') === 'true';
        if (isClicked) {
        	console.log("a")
        	console.log(button);
            button.addClass('clicked');
        } */

        // 버튼 클릭 시 Ajax 요청
        button.click(function() {
            const isClicked = $(this).hasClass('clicked');
            const myBtn = this; // 클릭이 발생한 버튼
            const myBtnCopy = myBtn.name; // 클릭이 발생한 버튼의 name
            const copyBtnList = document.getElementsByName(myBtnCopy);
            const copyNum = document.getElementById(myBtnCopy).value; // 예시로 examNo를 하드코딩하거나 실제 동적으로 설정하는 방법으로 변경해야 합니다.
            $.ajax({
                type: 'GET',
                url: '/LikeCopyController',
                
                data: {
                    copyNum: copyNum,
                    isClicked: !isClicked
                },
                success: function(response) {
                    if (response === 'liked') {
                        alert('관심 업체에 등록되었습니다.');
                        for(var i=0; i<copyBtnList.length; i++){                       	
                        copyBtnList[i].classList.add("clicked");
                        }
                        /* myBtn.classList.add("clicked"); */
                       /*  button.addClass('clicked'); */
                        localStorage.setItem('likeButtonClicked', 'true');
                    } else if (response === 'unliked') {
                        alert('관심 업체에서 제거되었습니다.');
                        for(var i=0; i<copyBtnList.length; i++){                       	
                            copyBtnList[i].classList.remove("clicked");
                            }
                        /* myBtn.classList.remove("clicked"); */
;

/*                         button.removeClass('clicked'); */
                        localStorage.setItem('likeButtonClicked', 'false');
                    } else {
                        alert('처리 중 오류가 발생했습니다.');
                    }
                
                },
                error: function(xhr, status, error) {
                    console.error('요청 실패: ' + status + ', ' + error);
                    alert('서버 오류로 인해 요청을 처리할 수 없습니다.');
                }
            });
        });
    });