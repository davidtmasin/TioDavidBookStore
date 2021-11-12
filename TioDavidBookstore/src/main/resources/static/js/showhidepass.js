
if (navigator.userAgentData != undefined && navigator.userAgentData.mobile) {
		//mobile		
		document.getElementById("showHidePassword").addEventListener("click", function() {
			const password = document.getElementById('userPassword');
			
			if(password.getAttribute("type") == "password"){
				
				password.setAttribute('type','text');
				
			} else{
				
				password.setAttribute('type','password');
			}
		
		});
	} else{
		//desktop
		document.getElementById('showHidePassword').addEventListener('mousedown', function() {
		document.getElementById('userPassword').type = 'text'; 		  
	});
	
	document.getElementById('showHidePassword').addEventListener('mouseup', function() {
		document.getElementById('userPassword').type = 'password';
	});
	
	// Para que o password não fique exposto apos mover a imagem.
	document.getElementById('showHidePassword').addEventListener('mousemove', function() {
		document.getElementById('userPassword').type = 'password';
	 }); 
		
}
	
	

/*
 function show(){
	const password = document.getElementById('userPassword');
	password.setAttribute('type','text');  
}

function hide()
{
   const password = document.getElementById('userPassword');
password.setAttribute('type','password');   
}

function showHide()
{
    let passwordShown = 0;

document.getElementById("showHidePassword").addEventListener("click", function() {
    if (passwordShown == 0) 
    {
        passwordShown = 1; 
        show();
    } 
    else {
        passwordShown = 0;
        hide();
    }
            }, false);

}
*/