var categoryEle = document.getElementsByName('categoryNo');

for (const ele of Array.from(categoryEle)) {
    ele.addEventListener("click", checkFunc);
}

let cPage = 1;
let categoryNum = 0;

function checkFunc(sumPage) {
	
	if(this.type === 'radio'){
		cPage = 1;
		
		const cetegoryResultNum = this.value;
		if(cetegoryResultNum){
		    categoryNum = cetegoryResultNum;
		}
		
	}else{
		if(sumPage == 'L'){
			cPage -= 1;
		}else if(sumPage == 'R'){
			cPage += 1;
		}
		
	}
	
	const examBox = document.getElementById('exam-result-box');
	
	examBox.innerHTML = "";

    $.ajax({
        type: 'POST',
        url: '/ExamCategory.do',
        data: {
            categoryNum: categoryNum,
            cPage: cPage
        },
        success: function(data) {
			
			if(data.pi.endPage == 0) {
				data.pi.endPage = 1;
			}
	
			if(data.constructList.length == 0){
				examBox.innerHTML += `<h5 style="width: 600px; margin-top:30px;">등록 되어있는 예시가 없습니다.</h5>`;
				data.pi.endPage = 0;
			}else{
				for(let i = 0; i < data.constructList.length; i++){
					examBox.innerHTML += `<form action="/constructExam/constructdelete.do" method="POST">
												<input type="hidden" name="examNo" value="` + data.constructList[i].examNo +`">
												<input type="hidden" name="fileNo" value="`+ data.constructList[i].fileNo+`">
												<input type="hidden" name="fileName" value="`+ data.constructList[i].fileName +`">
												<input type="hidden" name="categoryNum" value="`+ data.constructList[i].categoryNo +`">
												<input type="hidden" name="page" value="`+ data.pi.copypage +`">
												<div class="col">
													<div class="card shadow-sm he-min">
														<a href="/constructDetail.do?examNo=`+data.constructList[i].examNo+`" class="img-size ">
															<img class="bd-placeholder-img card-img-top img-contain" src=/resources/img/`+ data.constructList[i].fileName+`>
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
			}
			
			
			const paignationBox = document.getElementById('paginaetion-box');
			paignationBox.innerHTML = "";
			
			
			if(data.pi.copypage == 1){
				paignationBox.innerHTML += `<a onclick="checkFunc()" id="categoryNo" class="page-n rounded" >&laquo;</a>`;
			}else{
				paignationBox.innerHTML += `<a onclick="checkFunc('L')" id="categoryNo" class="page-n rounded">&laquo;</a>`;
			}
			
			for(let i = data.pi.startPage; i <= data.pi.endPage; i++){
				paignationBox.innerHTML += `<a class="page-n rounded" id="copypageNum" name="copypageNum">`+ [i] +`</a>`;
			}
			
			if(data.pi.copypage == data.pi.maxPage){
				paignationBox.innerHTML += `<a onclick="checkFunc()" id="categoryNo" class="page-n rounded" >&raquo;</a>`;
			}else{
				paignationBox.innerHTML += `<a onclick="checkFunc('R')" id="categoryNo" class="page-n rounded">&raquo;</a>`;
			}
			
			copypageNumChoice = document.getElementsByName("copypageNum");
			
			for (const ele of Array.from(copypageNumChoice)) {
			    ele.addEventListener("click", categoryNumFunc);
			}

            // $('body').html(data);
        },
        error: function(error) {
            console.error('Error:', error);
        }
    });

}




function categoryNumFunc(){
	cPage = Number(this.innerText);
	checkFunc();
}



