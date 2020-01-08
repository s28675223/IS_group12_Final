<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoogleSearch</title>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<!-- <link href='http://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'> -->
		<!--上面的東西對於外觀都沒啥影響-->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-panels.min.js"></script>
		<script src="js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel-noscript.css" />
			<link rel="stylesheet" href="css/style.css" />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->

</head>
<body>


<form action='${requestUri}' method='get'>
<div id="header">
			<div class="container">
					
				<!-- Logo -->
					<div id="logo">
						<h1><a href="#">Head phone</a></h1>
						<span>Design by GROUP 12</span>
					</div>
				
				<!-- Nav -->
				<form id="logo" size=5>
						<input type='text' name='keyword' placeholder = 'keyword' />
						<input type='submit' value='submit' />
					</form>

			</div>
		</div>
	<!-- Header -->
			
	<!-- Main -->
		<div id="main">
			<div class="container">
				<!-- Logo -->
					<div id="logo">
						<h1><a href="#">搜尋結果</a></h1>
					</div>

					<div class="g">
						<hr>
						<%
String[][] orderList = (String[][])  request.getAttribute("query");
for(int i =0 ; i < orderList.length;i++){%>
	<a href= <%= orderList[i][1] %>'><%= orderList[i][0] %></a><br><h style="font-size:5px ;"><%= orderList[i][1] %></h><br><br>
<%
}
%>

					<div class="g">
						<hr></hr>

						<div class="g">
							

							<div class="g">
								
				<!-- Nav -->
				<br><br><br><br>

			</div>
	<!-- Main -->

	<!-- Footer -->
		<div id="footer">

</form>

</body>
</html>