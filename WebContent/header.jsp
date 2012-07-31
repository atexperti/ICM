<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="keywords" content="<s:text name="header.meta.keywords" />" />
	<meta name="description"
		content="<s:text name="header.meta.description" />" />
<title><s:text name="title"></s:text></title>
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
					<div class="slogan"><s:text name="slogan"></s:text></div>
				</div>

				<s:if test="%{#session.userId !=null}">
					<div class="login">
						<div class="user">
							<s:text name="header.welcomeText" />
							:&nbsp;
							<s:property value="%{#session.username}" />
							<br></br> <a href="myAccount"><s:text name="My.Account"></s:text></a>&nbsp;|&nbsp;<a
								href="logout.action"><s:text name="Sign.Up"></s:text></a>
						</div>
						<input type="hidden" name="language" id="language" value="English" />
						<div class="log">
							<s:text name="choose.lang"></s:text>
							<s:select onchange="changLanguage(this);" name="language"
								list="languages" listValue="languageName" listKey="languageName"
								value="%{language}"></s:select>
						</div>

						<div class="clear"></div>
					</div>
				</s:if>
				<s:elseif test="%{#session.forgetpassword!=null}">
				<div class="forgetlogin">
					<div class="user">
						<s:form theme="simple" action="getpassword" method="post">
							<span class="Star">*</span>
							<s:text name="header.forget.uname.form.text" />
								&nbsp;<s:textfield name="userName" cssClass="TxtBox" />
							<br />
							<span class="Star">*</span>
							<s:text name="header.forget.email.form.text" />
								&nbsp;<s:textfield name="email" cssClass="TxtBox" />
								&nbsp;
								<button type="submit"><s:text name="submit"></s:text></button>
						</s:form>
					</div>
					<input type="hidden" name="language" id="language" value="English" />
					

					<div class="clear"></div>
				</div>
			</s:elseif>
			<s:else>
			<div class="login">
				<s:form action="login.action" method="post" theme="simple"
					onSubmit="javascript:return validateLogin(this)">
					<div class="user">
						<s:textfield name="userName" cssClass="LoginTxtBox" />
						<s:password name="password" cssClass="LoginTxtBox" />

						<button type="submit"><s:text name="login"></s:text></button>
						<br /> <a href="forgetpassword"><s:text name="forget.text"></s:text></a><br />
						<a href="register"><s:text name="signup.text"></s:text></a>
					</div>


				</s:form>
				<input type="hidden" name="language" id="language" value="English" />
				<div class="log">
					<s:text name="choose.lang"></s:text>
						<s:select onchange="changLanguage(this);" name="language"
							list="languages" listValue="languageName" listKey="languageName"
							value="%{language}"></s:select>
					</div>

				<div class="clear"></div>
		</div>
		</s:else>



		<div class="clear"></div>
	</div>
	</div>
	<div id="container">