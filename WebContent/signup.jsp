<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    	<div class="LanguageBlock"><span>Choose Language</span> <img src="images/f1.jpg" class="Flag" width="15" height="10" alt=""/><img src="images/f2.jpg" class="Flag" width="15" height="10" alt=""/></div>
        <div class="Search"><input class="SearchInput" type="text" placeholder="Search" /><input class="SBtn" type="submit" value="Search" /></div>
        <div class="AppImg"></div>
        <div class="NextelLogo"></div>
    </header>
    <nav>
    	<ul>
        	<li><a href="#">Home</a></li>
            <li><a href="#" class="Selected">Games (25)</a></li>
            <li><a href="#">Wallpapers (32)</a></li>
            <li><a href="#">Ringtones (15)</a></li>
            <li><a href="#">Video Clips (10)</a></li>
            <li><a href="#">Applications (13)</a></li>
            <li class="width5more"><a href="#">Poly Tones (10)</a></li>
        </ul>
    </nav>
    <section class="NextelLoginNav"><h1>Welcome Guest, Please find the relavent content for your device on our portal.</h1></section>
    <div class="HolderContent">
    	<div class="LeftCol">
        	<section class="LR">
            	<div class="SH"><h2>Genre</h2></div>
                <div class="SC">
                	<nav class="LRSectionNav">
                    	<ul>
                        	<li><a class="Selected" href="#">Action (4)</a></li>
                            <li><a href="#">Adventure (3)</a></li>
                            <li><a href="#">Puzzles (6)</a></li>
                            <li><a href="#">Sports (4)</a></li>
                            <li><a href="#">Strategy (3)</a></li>
                            <li><a href="#">Kids (1)</a></li>
                            <li><a href="#">Other (4)</a></li>
                            <li><a href="#">News (3)</a></li>
                            <li><a href="#">Fun (6)</a></li>
                        </ul>
                    </nav>
                </div>
            </section>
            <section class="LR">
            	<div class="SH"><h2>Select Device</h2></div>
                <div class="SC">
                	<p>Select your device to find games that are compatible.</p>
                    <select>
                      <option value="Nokia N97">Nokia N97</option>
                    </select> 
                </div>
            </section>
            <section class="LR">
                <div class="SH"><h2>Account Login</h2></div>
                <div class="SC">
                	<p>Log in below to access your Nextel account.</p>
                    <input placeholder="User Name" type="text"/>
                    <input placeholder="Password" type="password"/>
                    <button type="submit" class="GrayBtn">Login</button>
                    <div class="TLnks">
                        <a href="#">Forgot your password?</a><br />
                        <a href="#">No account yet? Sign up! </a>
                    </div>
                </div>
            </section>
        </div>
        <div class="MidCol">
        	<section class="Mid">
            	<div class="SH"><h2>Sign Up</h2></div>
                <div class="SC">
                <div class="SignUpDiv">
                	<div class="Row">
                    	<h3 class="RqH">* Required information for Sign Up</h3>
                    </div>
                	<s:actionerror />
                    <form action="registeruser" method="post" onSubmit="javascript:return validateRegister(this);">
                	<div class="Row">
                        <div class="FieldName"><span class="Star">*</span><s:text name="signup.form.mnumber.text" /></div>
                        <div class="FieldValue"><s:textfield name="userBean.msisdn" cssClass="TxtBox" /></div>
                    </div>
                     <div class="Row">
                        <div class="FieldName"><span class="Star">*</span><s:text name="signup.form.username.text" /></div>
                        <div class="FieldValue"><s:textfield name="userBean.userName" cssClass="TxtBox" /></div>
                    </div>
                    <div class="Row">
                        <div class="FieldName"><span class="Star">*</span><s:text name="signup.form.password.text" /></div>
                        <div class="FieldValue"><s:password  name="userBean.password" cssClass="TxtBox" /></div>
                    </div>
                    <div class="Row">
                        <div class="FieldName"><span class="Star">*</span><s:text name="signup.form.email.text" /></div>
                        <div class="FieldValue"><s:textfield  name="userBean.email" cssClass="TxtBox" /></div>
                    </div>
                    <div class="Row">
                    	<div class="FieldName"><span class="Star">*</span> <s:text name="signup.form.device.text" /></div>
                        <div class="FieldValue">
                        	<s:select  name="userBean.deviceId" list="deviceNames" listKey="value" listValue="key" />
                    	</div>
                    </div>
					 <div class="CaptchaRow">
                            	<div class="FieldName">Please enter the code on the right</div>
                                <div class="FieldValue"><s:textfield name="capchaCode" cssClass="TxtBox"/></div>
                            </div>
                            <div class="Code"><img src="captchaimage" width="71" height="38" /></div>
                            <a href="javascript:;" onmouseover="$('#help').show()" onmouseout="$('#help').hide();" ><img src="images/help-icon.jpg" width="16" height="16" alt="" /></a>
							<div id="help" style="display:none;">By entering the code on the left, you'll help us prevent automated WAP push. This reduces system loads and ensures better performance of Games Unlimited services.</div>
                    <div class="BtnsPnl"><s:submit cssClass="GrayBtn" name="submit" key="signup.form.submit" /><input type="button" name="Cancel" value="Cancel" class="GrayBtn LeftGap10" onclick="window.location = 'home' " /></div>
       				</form>
       			 </div>
                </div>
            </section>
        </div>
        <div class="RightCol">
        	<section class="LR">
            	<figure>
                	<img src="images/promo1.jpg" width="201" height="113" alt="" />
                    <img src="images/promo2.jpg" width="201" height="113" alt="" />
                    <img src="images/promo3.jpg" width="201" height="113" alt="" />
                </figure>
            </section>
        	<section class="LR">
                <div class="SH"><h2>Top Rated Games</h2></div>
                <div class="SC">
                	<ol class="RatingPannel">
                    	<li>
                        	<a href="#">Asphait 6</a>
                            <div class="RBPannel">
                            	<div class="Rating"><img src="images/rating-img.jpg" width="102" height="21" /></div>
                                <div class="Cart"><a href="#"><img src="images/cart.png" border="0" width="29" height="22" alt="Buy" title="Buy"/></a></div>
                            </div>
                        </li>
                        <li>
                        	<a href="#">Asphait 6</a>
                            <div class="RBPannel">
                            	<div class="Rating"><img src="images/rating-img.jpg" width="102" height="21" /></div>
                                <div class="Cart"><a href="#"><img src="images/cart.png" border="0" width="29" height="22" alt="Buy" title="Buy"/></a></div>
                            </div>
                        </li>
                        <li>
                        	<a href="#">Asphait 6</a>
                            <div class="RBPannel">
                            	<div class="Rating"><img src="images/rating-img.jpg" width="102" height="21" /></div>
                                <div class="Cart"><a href="#"><img src="images/cart.png" border="0" width="29" height="22" alt="Buy" title="Buy"/></a></div>
                            </div>
                        </li>
                        <li>
                        	<a href="#">Asphait 6</a>
                            <div class="RBPannel">
                            	<div class="Rating"><img src="images/rating-img.jpg" width="102" height="21" /></div>
                                <div class="Cart"><a href="#"><img src="images/cart.png" border="0" width="29" height="22" alt="Buy" title="Buy"/></a></div>
                            </div>
                        </li>
                        <li>
                        	<a href="#">Asphait 6</a>
                            <div class="RBPannel">
                            	<div class="Rating"><img src="images/rating-img.jpg" width="102" height="21" /></div>
                                <div class="Cart"><a href="#"><img src="images/cart.png" border="0" width="29" height="22" alt="Buy" title="Buy"/></a></div>
                            </div>
                        </li>
                    </ol>
                </div>
            </section>
        </div>
    </div>
    <footer>
    	<section class="Flinks"><a href="#">Contact Us</a> | <a href="#">FAQ</a> | <a href="#">Disclaimer</a> | <a href="#">About NII</a></section>
        <section class="CopyRight">&copy; Copyright 2011 Nextel </section>
    </footer>
</div>
<s:debug />
</body>
</html>
