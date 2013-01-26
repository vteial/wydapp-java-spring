<%@ page language="java" import="wyd.dto.WebMessage, wyd.dto.User"%>
<%
	String contextPath = request.getContextPath();
	String viewTitle   = (String) request.getAttribute("viewTitle");
	String viewName    = (String) request.getAttribute("viewName");
	User sesUser       = (User) session.getAttribute("user");
%>
<!doctype html>
<html>

<head>
	<title><%=application.getAttribute("applicationName")%> - <%=viewTitle%></title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="shortcut icon" href="assets/img/gaelyk-small-favicon.png" type="image/png">
	<link rel="icon" href="assets/img/gaelyk-small-favicon.png" type="image/png">
	
	<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="assets/css/bootstrap-responsive.min.css" />
	
	<link rel="stylesheet" type="text/css" href="assets/css/bootstrap-datepicker.css" />
	
	<link rel="stylesheet" type="text/css" href="assets/css/bootstrap-timepicker.min.css" />

	<link rel="stylesheet" type="text/css" href="assets/css/bootstrap-modal.css"/>

	<link rel="stylesheet" type="text/css" href="assets/css/prettify.css" />

	<link rel="stylesheet" type="text/css" href="assets/css/wyd.css" />

	<script type="text/javascript">
		if (window.console) {
			window.log = console.log.bind(console);
		}
		/*
		$(document).ready(function() {
			log("test log...");
		});
		*/
	</script>
</head>

<body>

<div class="page-container">

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<ul class="nav">
					<li class="">
						<a class="brand" href="wydIndex.java">
							<strong><%=application.getAttribute("applicationName")%></strong>
						</a>
					</li>
					<li class="divider-vertical"></li>
					<li class="<%=viewName.equals("wydIndex") ? "active" : ""%>">
						<a href="wydIndex.java"><i class="icon-home icon-white"></i></a>
					</li>
				</ul>
				<ul class="nav pull-right">
					<%
						if (sesUser != null) {
					%>
					<li class=""><a href="wydLogout.java">Sign Out</a></li>
					<%
						} else {
					%>
					<li class="<%=viewName.equals("wydLogin") ? "active" : ""%>">
						<a href="wydLogin.java">Sign In</a>
					</li>
					<%
						}
					%>
					<li class="divider-vertical"></li>
					<li class="<%=viewName.equals("wydAbout") ? "active" : ""%>">
						<a href="wydAbout.java">About</a>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<%
		WebMessage webMessage = (WebMessage) request.getAttribute("webMessage");
		if(webMessage != null && webMessage.getType().equals(WebMessage.WARNING)) {
			webMessage.setValue("<storng>Warning : </storng> " + webMessage.getValue());
		}
		if (webMessage != null) {
	%>
	<div class="container">
		<div class="alert <%=webMessage.getType()%>">
			<button class="close" data-dismiss="alert">×</button>
			<%=webMessage.getValue()%>
		</div>
	</div>	
	<%
		}
	%>

	<div class="container">
	<%
		pageContext.include(viewName + "Breadcrumb.jsp");
	%>
	</div>

	<%
		pageContext.include(viewName + ".jsp");
	%>
 	<!--  
	<div id="footer">
		<div class="container">
			<p class="muted credit">Yet to implement!</p>
		</div>
	</div>
	-->
 
 </div>

<script type="text/javascript" src="assets/js/jquery-1.8.2.min.js"></script>

<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>

<script type="text/javascript" src="assets/js/bootstrap-datepicker.js"></script>

<script type="text/javascript" src="assets/js/bootstrap-timepicker.min.js"></script>

<script type="text/javascript" src="assets/js/bootstrap-modalmanager.js"></script>
<script type="text/javascript" src="assets/js/bootstrap-modal.js"></script>

<script type="text/javascript" src="assets/js/prettify.js"></script>

<script type="text/javascript" src="assets/js/jquery.validate.min.js"></script>

<script type="text/javascript" src="assets/js/jquery.tablesorter.min.js"></script> 

<!-- noty -->
<script type="text/javascript" src="assets/js/noty/jquery.noty.js"></script>
<!-- noty-layouts -->
<script type="text/javascript" src="assets/js/noty/layouts/bottom.js"></script>
<script type="text/javascript" src="assets/js/noty/layouts/bottomCenter.js"></script>
<script type="text/javascript" src="assets/js/noty/layouts/bottomLeft.js"></script>
<script type="text/javascript" src="assets/js/noty/layouts/bottomRight.js"></script>
<script type="text/javascript" src="assets/js/noty/layouts/center.js"></script>
<script type="text/javascript" src="assets/js/noty/layouts/centerLeft.js"></script>
<script type="text/javascript" src="assets/js/noty/layouts/centerRight.js"></script>
<script type="text/javascript" src="assets/js/noty/layouts/inline.js"></script>
<script type="text/javascript" src="assets/js/noty/layouts/top.js"></script>
<script type="text/javascript" src="assets/js/noty/layouts/topCenter.js"></script>
<script type="text/javascript" src="assets/js/noty/layouts/topLeft.js"></script>
<script type="text/javascript" src="assets/js/noty/layouts/topRight.js"></script>
 <!-- noty-themes -->
<script type="text/javascript" src="assets/js/noty/themes/default.js"></script>

<script type="text/javascript" src="assets/js/wyd.js"> </script>
	 	
</body>
</html>