var categoryEle = document.getElementsByName('categoryNo');

for (const ele of Array.from(categoryEle)) {
    ele.addEventListener("click", checkFunc);
}

function checkFunc() {
    const categoryNum = this.value;
    
    const cPage = document.getElementById('copypage').value;
	const examBox = document.getElementById('exam-result-box');
	
	examBox.innerHTML = "";

    $.ajax({
        type: 'POST',  // 오타 수정
        url: '/ExamCategory.do',
        data: {
            categoryNum: categoryNum,
            cPage: cPage
        },
        success: function(data) {

			for(let i = 0; i < data.constructList.length; i++){
				examBox.innerHTML += `<form action="/constructExam/constructdelete.do" method="POST">
											<input type="hidden" name="examNo" value="` + data.constructList[i].examNo +`">
											<input type="hidden" name="fileNo" value="`+ data.constructList[i].fileNo+`">
											<input type="hidden" name="fileName" value="`+ data.constructList[i].fileName +`">
											<input type="hidden" name="categoryNum" value="`+ data.constructList[i].categoryNo +`">
											<input type="hidden" name="page" value="1">
											<div class="col">
												<div class="card shadow-sm he-min">
													<a href="/constructDetail.do?examNo=`+data.constructList[i].examNo+`" class="img-size ">
													<img class="bd-placeholder-img card-img-top" src=/resources/img/`+ data.constructList[i].fileName+` fill="#55595c">
													</a>
													<p class="djqcpaud">`+ data.constructList[i].copyName +`</p>
					
													<div class="card-body">
														<p>`+ data.constructList[i].title +`</p>
														<div class="d-flex justify-content-between align-items-center">
															<div class="btn-group">
															
															</div>
														</div>
													</div>
												</div>
											</div>
										</form>`;
			}
			
			
            // $('body').html(data);
        },
        error: function(error) {
            console.error('Error:', error);
        }
    });

}





