<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Nation Builder Chatroom</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='<c:url value="/assets/css/bootstrap.min.css"/>'
	rel="stylesheet">
</head>
<body>
	<!-- Static navbar -->
	<div class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href='<c:url value="/"/>' class="navbar-brand">Nation Builder Chatroom</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href='<c:url value="/join/nb"/>'>Join
							Chatroom</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>