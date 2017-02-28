/*****************************************************************
 * 
 * @param el:element(span 안에는 텍스트노드) - 태그 정보
 * @param text :변경할 값(보드판매량)을 담을 변수
 * @returns 해당없음 - 직접변경
 *****************************************************************/
function replaceText(el,text){
	//기존의 노드에 들어있는 값을 초기화 시킨다.
	clearText(el);
	//지운 자리에 새로운 텍스트 노드추가하기
	var newNode = document.createTextNode(text);
	el.appendChild(newNode);
}
/*********************************************************************
 * 기존의 노드에 들어있는 값을 지운다.
 * @param el(span)
 * @returns 해당없음
 *********************************************************************/
function clearText(el){//el:span id=boards-sold
	if(el !=null){
		if(el.childNodes){//el.childNodes  -span태그에 자식노드
			for(var i=0;i<el.childNodes.length;i++){
				//childNode변수에 1000
				var childNode = el.childNodes[i];
				el.removeChild(childNode);
			}//////////end of for
		}/////////////end of inner if
	}////////////////end of outter if
}///////////////////end of clearText
/*************************************************************
 * 노드에 값을 읽어오기 구현
 * @param el(span)
 * @returns text
 ***********************************************************/
function getText(el)
{
	var text = "";
	if(el !=null){
//childNodes는 지정된 개체의 직접적인 자식개체인
//html elements와 TextNode개체들의 컬렉션을 반환한다.		
		if(el.childNodes){
			for(i=0;i<el.childNodes.length;i++){
				var childNode = el.childNodes[i];
				//너 텍스트 노드니?
				if(childNode.nodeValue !=null){
					text += childNode.nodeValue;//1000
				}
			}
		}
	}
	return text;
}
/*********************************************************************
 * @param url : 팝업창으로 열어줄 페이지 경로
 * @param popupwidth : 팝업창의 폭
 * @param popupheight : 팝업창의 높이
 * @param popupname : 팝업창의 이름
 ********************************************************************/
function cmm_window_popup(url
		                                    ,popupwidth
		                                    ,popupheight
		                                    ,popupname)
{
	Top = (window.screen.height-popupheight)/3;//y축좌표
	Left = (window.screen.width-popupwidth)/2;  //x축좌표
	if(Top < 0) Top = 0;
	if(Left < 0) Left = 0;
	options = "location=no, fullscreen=no, status=yes"
	options +=", left="+Left+", top="+Top
	options +=", width="+popupwidth+", height="+popupheight;
	popupname = window.open(url,popupname,options);
	popupname.focus();
 }








