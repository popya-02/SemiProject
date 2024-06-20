document.addEventListener("DOMContentLoaded", ()=> {
	const contentBox = document.getElementById("content-result-box");
	
	const imgElements = contentBox.querySelectorAll('img');

	imgElements.forEach(function(imgElement){
		imgElement.style.maxWidth = "800px";	
	});
	
});