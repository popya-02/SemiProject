const msgReceive = document.getElementById("transmit-msg");
const enterBtn = document.getElementById("enter-btn");

msgReceive.addEventListener('keyup', enterEvent);

function enterEvent(event){
    if(event.keyCode == 13){   
        enterBtn.click();
    }
}