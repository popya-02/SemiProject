var categoryEle = document.getElementsByName('categoryNo');

for (const ele of Array.from(categoryEle)) {
    ele.addEventListener("click", categoryCheck);
}

/* 메인페이지 버튼 */
var mainCategoryEle = document.getElementsByName('mainCategoryNo');

for (const ele of Array.from(mainCategoryEle)) {
    ele.addEventListener("click", categoryCheck);
}

let cPage = 1;
let categoryNum = 0;


/* 시공예시 페이지의 radio 클릭시 categoryNum과 cPage 할당 */
function categoryCheck() {
    if (this.type === 'radio') {
        cPage = 1;
    }

    const categoryResultNum = this.value;

    if (categoryResultNum) {
        categoryNum = parseInt(categoryResultNum, 10);
    }

    checkFunc(categoryNum, cPage);
}

/* 시공예시 화면의 카페고리 페이지네이션 할당 */
function copypageNumFunc(sumPage) {
	
    if (sumPage === 'L') {
        cPage -= 1;
    } else if (sumPage === 'R') {
        cPage += 1;
    }else{
	    cPage = Number(this.innerText);
	
	}

    checkFunc(categoryNum, cPage);
}

function checkFunc(resultCategory, paginationNum) {

    if (resultCategory) {
        categoryNum = Number(resultCategory);
    }

    if (paginationNum) {
        cPage = Number(paginationNum);
    }


    $.ajax({
        type: 'POST',
        url: '/ExamCategory.do',
        data: {
            categoryNum: categoryNum,
            cPage: cPage
        },
        success: function(data) {
			const examBox = document.getElementById('exam-result-box');

            examBox.innerHTML = "";

            if (data.pi.endPage == 0) {
                data.pi.endPage = 1;
            }

            if (data.constructList.length == 0) {
                examBox.innerHTML += `<h5 style="width: 600px; margin-top:30px;">등록 되어있는 예시가 없습니다.</h5>`;
                data.pi.endPage = 0;
            } else {
                for (let i = 0; i < data.constructList.length; i++) {
                    examBox.innerHTML += `<form action="/constructExam/constructdelete.do" method="POST">
                        <input type="hidden" name="examNo" value="${data.constructList[i].examNo}">
                        <input type="hidden" name="fileNo" value="${data.constructList[i].fileNo}">
                        <input type="hidden" name="fileName" value="${data.constructList[i].fileName}">
                        <input type="hidden" name="categoryNum" value="${data.constructList[i].categoryNo}">
                        <input type="hidden" name="page" value="${data.pi.copypage}">
                        <div class="col">
                            <div class="card shadow-sm he-min">
                                <a href="/constructDetail.do?examNo=${data.constructList[i].examNo}" class="img-size">
                                    <img class="bd-placeholder-img card-img-top img-contain" src="/resources/img/${data.constructList[i].fileName}">
                                </a>
                                <p class="djqcpaud">${data.constructList[i].copyName}</p>
                                <div class="card-body">
                                    <p>${data.constructList[i].title}</p>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>`;
                }
            }

            const paginationBox = document.getElementById('paginaetion-box');
            paginationBox.innerHTML = "";

            if (data.pi.copypage == 1) {
                paginationBox.innerHTML += `<a onclick="copypageNumFunc()" id="categoryNo" class="page-n rounded" >&laquo;</a>`;
            } else {
                paginationBox.innerHTML += `<a onclick="copypageNumFunc('L')" id="categoryNo" class="page-n rounded">&laquo;</a>`;
            }
			
            for (let i = data.pi.startPage; i <= data.pi.endPage; i++) {
                paginationBox.innerHTML += `<a class="page-n rounded" id="copypageNum" name="copypageNum">`+[i]+`</a>`;
            }

            if (data.pi.copypage == data.pi.maxPage) {
                paginationBox.innerHTML += `<a onclick="copypageNumFunc()" id="categoryNo" class="page-n rounded" >&raquo;</a>`;
            } else {
                paginationBox.innerHTML += `<a onclick="copypageNumFunc('R')" id="categoryNo" class="page-n rounded">&raquo;</a>`;
            }

            const copypageNumChoice = document.getElementsByName("copypageNum");

            for (const ele of Array.from(copypageNumChoice)) {
                ele.addEventListener("click", copypageNumFunc);
            }
        },
        error: function(error) {
            console.error('Error:', error);
        }
    });
}
