<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>模板</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<link href="css/customCSS/msgboardofplaylifepagecss.css"
	rel='stylesheet' type='text/css' />
<link
	href='http://fonts.useso.com/css?family=Lato:100,300,400,700,100italic,300italic,400italic|Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.useso.com/css?family=Raleway:400,200,300,500,600,800,700,900'
	rel='stylesheet' type='text/css'>
<!--//webfonts-->
</head>
<body>
	<div class="login-01">
		<form>
			<ul>
				<li class="first"><a href="#" class=" icon user"></a><input
					type="text" class="text" value="Name" onFocus="this.value = '';"
					onBlur="if (this.value == '') {this.value = 'Name';}">
					<div class="clear"></div></li>
				<li class="first"><a href="#" class=" icon email"></a><input
					type="text" class="text" value="Email" onFocus="this.value = '';"
					onBlur="if (this.value == '') {this.value = 'Email';}">
					<div class="clear"></div></li>
				<li class="first"><a href="#" class=" icon phone"></a><input
					type="text" class="text" value="Phone" onFocus="this.value = '';"
					onBlur="if (this.value == '') {this.value = 'Phone';}">
					<div class="clear"></div></li>
				<li class="second"><a href="#" class=" icon msg"></a> <textarea
						value="Message" onFocus="this.value = '';"
						onBlur="if (this.value == '') {this.value = 'Comments';}">Comments</textarea>
					<div class="clear"></div></li>
			</ul>
			<input type="submit" onClick="myFunction()" value="Submit">
			<div class="clear"></div>
		</form>
	</div>
</body>
</html>