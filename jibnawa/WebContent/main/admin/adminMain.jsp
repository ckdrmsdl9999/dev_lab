<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- 스타일 -->
<link href="../css/bootstrap-ko.css" rel="stylesheet">
<link href="../css/bootstrap-responsive.css" rel="stylesheet">
<link href="../css/docs-ko.css" rel="stylesheet">
<link href="../css/prettify.css" rel="stylesheet">
<script type="text/javascript" src="../js/widgets.js"></script>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/holder.js"></script>
<script src="../js/prettify.js"></script>
<script src="../js/application.js"></script>

<!-- 파비콘과 앱 아이콘 -->

<script>
      (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
      ga('create', 'UA-146052-10', 'getbootstrap.com');
      ga('send', 'pageview');
      function test(){
    	  $.ajax({
    	        type : "POST",
    	        url : "admin/jibnawaMember.kosmo",
    	        dataType : "text",
    	        error : function() {
    	          alert('통신실패!!');
    	        },
    	        success : function(data) {
    	          $('#dropdowns').html(data);
    	        } 
    	      });
    	  }

      $(window).load(function() {
        // 로딩 완료되었을때
      });
       
      $(document).ready(function() {
        // 문서의 로딩을 시작할때
      }); 
       
       
      $(function() {
        test();
      }); 
      </script>

<div class="alert alert-danger bs-alert-old-docs">
	<strong>주의!</strong> 더 이상 공식지원하지 않는 v2.3.2 문서입니다. <a
		href="http://getbootstrap.com">최신 버전 부트스트랩을 확인하세요!</a>
</div>

<!-- Docs nav
    ================================================== -->
<div class="row">
	<div class="span3 bs-docs-sidebar">
		<ul class="nav nav-list bs-docs-sidenav">
			<li><a href="#dropdowns" onclick="test()"><i
					class="icon-chevron-right"></i>회원관리</a></li>
			<li><a href="#buttonGroups"><i class="icon-chevron-right"></i>업체관리</a></li>
			<li><a href="#buttonDropdowns"><i class="icon-chevron-right"></i>경매내역</a></li>
			<li><a href="#navs"><i class="icon-chevron-right"></i> test3</a></li>
			<li><a href="#navbar"><i class="icon-chevron-right"></i>
					test4</a></li>
			<li><a href="#breadcrumbs"><i class="icon-chevron-right"></i>
					test5</a></li>
		</ul>
	</div>


	<div class="span9">
		<!-- 드롭다운
        ================================================== -->
		<section id="dropdowns">
			<jsp:include page="jibnawaMember.kosmo" />
		</section>
		<!-- 버튼 그룹
        ================================================== -->
		<section id="buttonGroups"></section>



		<!-- 분리된 버튼 드롭다운
        ================================================== -->
		<section id="buttonDropdowns"></section>



		<!-- 탐색, 탭, 알약
        ================================================== -->
		<section id="navs"></section>



		<!-- 탐색막대
        ================================================== -->
		<section id="navbar"></section>



		<!-- 사이트 경로
        ================================================== -->
		<section id="breadcrumbs"></section>



		<!-- 라벨과 배지
        ================================================== -->
		<section id="labels-badges"></section>



		<!-- 미리보기
        ================================================== -->
		<section id="thumbnails"></section>




		<!-- 경고
        ================================================== -->
		<section id="alerts"></section>




		<!-- 진행표시줄
        ================================================== -->
		<section id="progress"></section>




		<!-- 미디어 객체
        ================================================== -->
		<section id="media"></section>





		<!-- 기타
        ================================================== -->
		<section id="misc"></section>
	</div>
</div>





<!-- 자바스크립트
    ================================================== -->
<!-- 페이지를 빨리 읽어들이도록 문서 마지막에 배치 -->


<!-- 웹로그 분석
    ================================================== -->
<!--<script>
      var _gauges = _gauges || [];
      (function() {
        var t   = document.createElement('script');
        t.type  = 'text/javascript';
        t.async = true;
        t.id    = 'gauges-tracker';
        t.setAttribute('data-site-id', '4f0dc9fef5a1f55508000013');
        t.src = '//secure.gaug.es/track.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(t, s);
      })();
    </script>-->


