<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<tilesx:useAttribute name="current" />

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>




<title><tiles:getAsString name="title"></tiles:getAsString></title>
</head>
<body>
	<div class="container">

		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href='<spring:url value="/"/>'>JBA</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class=${current=='index'? 'active' : '' }><a
							href='<spring:url value="/"/>'>Home</a></li>

						<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class=${current=='users'? 'active' : '' }><a
								href="<spring:url value="/users.htm"/>">Users</a></li>
						</security:authorize>

						<security:authorize access="! isAuthenticated()">
						<li class=${current=='register'? 'active' : '' }><a
							href="<spring:url value="/register_user.htm"/>">Register</a></li>
						
							<li class=${current=='login'? 'active' : '' }><a
								href="<spring:url value="/login.htm"/>">Login</a></li>
						</security:authorize>
						<security:authorize access="isAuthenticated()">
							<li class=${current=='mypage'? 'active' : '' }><a href="<spring:url value="/mypage.htm"/>">My Account</a></li>
							<li><a href="<spring:url value="/logout"/>">Logout</a></li>
						</security:authorize>

					</ul>

				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>



		<tiles:insertAttribute name="body" />
		<br> <br>

		<tiles:insertAttribute name="footer" />

	</div>
</body>
</html>