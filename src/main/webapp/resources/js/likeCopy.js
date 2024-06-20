	

// 페이지 로드 시 로컬 스토리지에서 상태 읽기
	let button = $('.likeButton');
	/* const isClicked = localStorage.getItem('likeButtonClicked') === 'true';
	if (isClicked) {
		console.log("a")
		console.log(button);
	    button.addClass('clicked');
	} */

	// 버튼 클릭 시 Ajax 요청

// function likeCopyBtn(myBtn) {
const likeCopyBtn = (e) => {
		const isClicked = $(e.target).hasClass('clicked');
	    const myBtn = e.target; // 클릭이 발생한 버튼
	    const myBtnCopy = myBtn.name; // 클릭이 발생한 버튼의 name
	    const copyBtnList = document.getElementsByName(myBtnCopy);
	    const copyNumElement = document.getElementById(myBtnCopy); // 요소가 null인지 확인
	
	    if (!copyNumElement) {
	        console.error(`Element with id ${myBtnCopy} not found.`);
	        return;
	    }
	
	    const copyNum = copyNumElement.value;
		
		$.ajax({
			type : 'GET',
			url : '/LikeCopyController',

			data : {
				copyNum : copyNum,
				isClicked : !isClicked
			},
			success : function(response) {
				if (response === 'liked') {
					alertSwal("관심 업체에 등록되었습니다.", "", "success", "");
					for (var i = 0; i < copyBtnList.length; i++) {
						copyBtnList[i].classList.add("clicked");
					}
					/* myBtn.classList.add("clicked"); */
					/*  button.addClass('clicked'); */
					localStorage.setItem('likeButtonClicked', 'true');
				} else if (response === 'unliked') {
					alertSwal("관심 업체에서 제거되었습니다.", "", "success", "R");
					for (var i = 0; i < copyBtnList.length; i++) {
						copyBtnList[i].classList.remove("clicked");
					}
					/* myBtn.classList.remove("clicked"); */
					;

					/*                         button.removeClass('clicked'); */
					localStorage.setItem('likeButtonClicked', 'false');
				} else {
					alertSwal("처리중 오류가 발생했습니다.", "", "warning", "");
				}

			},
			error : function(status, error) {
				console.error('요청 실패: ' + status + ', ' + error);
				alertSwal("서버 오류로 인해 요청을 처리할 수 없습니다.", "", "warning", "");
			}
		});
	}
	button.click(likeCopyBtn);

function alertSwal(titlee, msg, iconn, cUrl){
	
	const swalResult = Swal.fire({
		title: titlee,
		text: msg,
		icon: iconn,
    });

	
    swalResult.then(() => {
        if (cUrl === 'b') {
            window.history.back();
        } else if(cUrl === ''){
	
		} else if(cUrl === 'R'){
			window.location.reload();
		} else {
            location.href = cUrl;
        }
    });
}