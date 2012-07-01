<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Nextel</title>
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<s:head />
<link href="css/Globalstyles.css" rel="stylesheet" type="text/css" />
<link href="css/hacks.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="scripts/jquery-1.7.js"></script>
<script language="JavaScript" src="scripts/functions.js"></script>

</head>

<body>
	<div ID="container">
		<header class="MH">
			<div class="LanguageBlock">
				<span>Choose Language</span> <img src="images/f1.jpg" class="Flag"
					width="15" height="10" alt="" /><img src="images/f2.jpg"
					class="Flag" width="15" height="10" alt="" />
			</div>
			<div class="Search">
				<input class="SearchInput" type="text" placeholder="Search" /><input
					class="SBtn" type="submit" value="Search" />
			</div>
			<div class="AppImg"></div>
			<div class="NextelLogo"></div>
		</header>
		<s:include value="/WEB-INF/jsp/includes/header_nav.jsp" />
		<section class="NextelLoginNav">
			<h1>Welcome Guest, Please find the relavent content for your
				device on our portal.</h1>
		</section>
		<div class="HolderContent">
			
			<div class="MidCol">
				<section class="Mid">
					<div class="Row">
					<form action="getpassword" method="post">
                        <div class="FieldName"><span class="Star">*</span><s:text name="forget.email.form.text" /></div>
                        <div class="FieldValue"><s:textfield  name="userBean.email" cssClass="TxtBox" /></div><br></br>
                    	<div class="BtnsPnl"><s:submit cssClass="GrayBtn" name="submit"  /><input type="button" name="Cancel" value="Cancel" class="GrayBtn LeftGap10" onclick="window.location = 'home' " /></div>
                    </form>
                    </div>
				</section>
			</div>

		</div>
		<footer>
			<section class="Flinks">
				<a href="#">Contact Us</a> | <a href="#">FAQ</a> | <a href="#">Disclaimer</a>
				| <a href="#">About NII</a>
			</section>
			<section class="CopyRight">&copy; Copyright 2011 Nextel</section>
		</footer>
	</div>

	<s:debug />
</body>
</html>
