<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>  
<head>
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no"/>
<meta name="description" content="SONG_LA">
<title>BANDO</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/base.css">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/fonts/font-awesome/css/font-awesome.css">
<link href='http://fonts.googleapis.com/css?family=Lato:400,700,900,300' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/modernizr.custom.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
	var timer = setTimeout(function() {
		$( "#logo" ).slideToggle(800,function(){
			setTimeout(function() {
				$( "#loginForm" ).slideToggle(1000);
			},200);	//顯示表單的時間
		});
	},2000);	//隱藏LOGO的時間
	
	$(document).ready(function() {
		document.body.style.height = window.innerHeight;
	});

    $( function() {
    	$( "#user" ).on( "click", function() {
    		console.log("Before Click: " + $( "#ident").val());
    		$( "#ident").val("mem");
    		console.log("After Click: " + $( "#ident").val());
			var classList = $("#user-login").attr('class');
			var classSet = classList.split(" ");
    		$( "#user-login" ).removeClass(classSet[2],1000).addClass( "panel-mem", 1000);
    		$("#identity").html("一般會員");
    	});

    	$( "#deliver" ).on( "click", function() {
    		console.log("Before Click: " + $( "#ident").val());
    		$( "#ident").val("admin");
    		console.log("After Click: " + $( "#ident").val());
    		var classList = $("#user-login").attr('class');
			var classSet = classList.split(" ");
    		$( "#user-login" ).removeClass(classSet[2],1000).addClass( "panel-deliver", 1000);
    		$("#identity").html("管理員");
    	});

		$( "#store" ).on( "click", function() {
			console.log("Before Click: " + $( "#ident").val());
			$( "#ident").val("store");
			console.log("After Click: " + $( "#ident").val());
	  		var classList = $("#user-login").attr('class');
			var classSet = classList.split(" ");
	  		$( "#user-login" ).removeClass(classSet[2],1000).addClass( "panel-store", 1000);
	   		$("#identity").html("店家");
		});
    });
</script>
</head>  
  
<body>  

	<div class="fixed_bg bg_img_1">
		<div class="video-container" id="top">
	        <video autoplay loop class="fillWidth">
		       <source src="<%=request.getContextPath()%>/video/Home-And-Away.mp4" type="video/mp4"/>
	        </video>
	    <!-- scroll with content (but position swift) -->
	    <!-- </div> -->
        <div class="group">
        	<h1 class=" shadow">Welcome to <strong>BANDON</strong></h1>
        	<div id="logo" style="display:block">
        		<img id="bgimg" src="<%=request.getContextPath()%>/video/bg.png">
        	</div>
				<div id="loginForm" class="container" style="display:none"> 
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<div id="user-login" class="panel panel-default panel-mem">
							<h2><strong>請選擇角色</strong></h2><br>
							<span class="span-pic" id="deliver"><i class="fa fa-cog"></i></span>
							<span class="span-pic" id="user"><i class="fa fa-user"></i></span>
							<span class="span-pic" id="store"><i class="fa fa-home"></i></span>
							<br><br>
							<h4>以 <strong id="identity">一般會員</strong> 身分登入</h4>  
							<div class="panel-body">
								<form:form method="post" modelAttribute="mem" servletRelativeAction="/">
									<form:errors path="*" cssClass="error" />
									<input id="ident" type="hidden" name="ident" value="mem">
									<input type="hidden" name="method" value="login">
									<div class="form-group">
										<form:input path="memId" class="form-control" placeholder="Enter Your Email" />
									</div>
									<div class="form-group">
										<form:input type="password" path="memPwd" class="form-control" placeholder="Enter Your Password" /> 
									</div>
									<div class="form-group">
										<input type="submit" class="btn btn-success btn-lg btn-block">
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
        	<h1 class=" shadow">The Best Way to Color Your Life</h1>
        </div>

        <!-- change Position -->
        </div>
    </div>
    
    <div class="infos color_1">
		<div class="container-fluid">
			<div class="row">
				<h2 style="text-align: center;">會員註冊</h2>
				<div class="container form-container">
					<form>
						<div class="form-group">
						    <label for="email">你的E-mail:</label>
						    <input type="email" class="form-control" id="email">
	  					</div>
						<div class="form-group">
							<label for="pwd">密碼:</label>
							<input type="password" class="form-control" id="pwd">
						</div>
						<div class="form-group">
							<label for="pwd">再次輸入密碼:</label>
							<input type="password" class="form-control" id="re-pwd">
						</div>
						<div class="form-group">
							<label for="pwd">手機:</label>
							<input type="tel" class="form-control" id="tel">
						</div>
						<div class="checkbox">
							<label><input type="checkbox"> Remember me</label>
						</div>
	  					<button type="submit" class="btn btn-default btn-block">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.1.11.1.js"></script> 
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</body>  
</html>  