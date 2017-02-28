	var request = null;//통신객체 전역변수선언
	//함수 안에 함수를 또 정의할 수 없다.
	function createRequest(){
		try {
			//사파리, 크롬, 파이어폭스, 익스플로러9.0
			request = new XMLHttpRequest();
		} catch (trymicrosoft) {
			// TODO: handle exception
			try {
				request = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (othermicrosoft) {
				try {
					request = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (failed) {
					request = null;
				}
			}
		}
		if(request == null){
			alert("통신객체 생성 실패~~~");
		}
	}//////////////// end fo createRequest //////////////////
	function requestProcess(){
		if(request.readyState == 4){
			document.getElementById("resultDisplay").innerHTML 
										= request.responseText;//requestPost.xml(html)	
		}
	}///////////////end of requestProcess
	
	
	
	
	
	
	
	
	
	
	