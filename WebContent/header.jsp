<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Indian Christian Media</title>
<link rel="stylesheet" type="text/css" href="css/icm.css" />
<link rel="stylesheet" type="text/css" href="css/corosel.css" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:600,400,700,800'
	rel='stylesheet' type='text/css'>
	<script src="SpryAssets/SpryValidationPassword.js"
		type="text/javascript"></script>
	<script type="text/javascript" src="js/modernizr.custom.53451.js"></script>
	<script type="text/javascript" src="js/flowplayer-3.2.10.min.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/interface.js"></script>
	<script type="text/javascript" src="js/functions.js"></script>

	<link href="SpryAssets/SpryValidationPassword.css" rel="stylesheet"
		type="text/css" />
	<script type="text/javascript">
		function changLanguage(obj) {
			location.search = '?lang=' + obj.value;
		}
	</script>
</head>
<body>
	<div id="web-box">
		<div id="header">
			<div class="header-box">
				<div class="logo">
					<div class="slogan">Enlighten...Enrich...Edify...</div>
				</div>
				<div class="login">
					<s:if test="%{#session.userId !=null}">
						<div class="register">
							<a href="register"> My Account </a><br></br> <a href="logout">Sign
								Out </a>
						</div>
					</s:if>
					<s:else>
						<div class="user">
							<s:actionerror />
							<form action="login" method="post"
								onsubmit="javascript:return validateLogin(this)">
								<s:textfield name="userName" required="true" />
								<s:textfield name="password" required="true" />
								<s:submit cssClass="botton-bg" type="button" name="submit" value="Submit" />
							</form>
							
						</div>
						<div class="register">
							<a href="">Forgot Password?</a> | <a href="signup.php">Create
								Account</a>
						</div>
					</s:else>
					<input type="hidden" name="language" id="language" value="English" />
					<div class="log">
						Select Language:
						<s:select onchange="changLanguage(this);" name="language"
							list="languages" listValue="languageName" listKey="languageName"
							value="%{language}"></s:select>
					</div>

					<div class="clear"></div>
				</div>

				<div class="clear"></div>
			</div>
		</div>
		<div id="container">