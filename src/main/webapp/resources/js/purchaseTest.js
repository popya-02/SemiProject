/*



IMP.init("imp67844376");

const button = document.querySelector("button");

const onClickPay = async () => {
	IMP.request_pay({
		pg: "html5_inicis",
		pay_method: "card",
		amount: "60000",
		name: "우소우소짱",
		merchant_uid: "ORD20240604-00000001",
	});
	
};

button.addEventListener("click", onClickPay);
*/