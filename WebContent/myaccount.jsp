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

<link href="css/Globalstyles.css" rel="stylesheet" type="text/css" />
<link href="css/hacks.css" rel="stylesheet" type="text/css" />
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
            	<div class="SH"><h2>My Account</h2></div>
                <div class="SC">
                	<div class="MyAc">
                    	<span class="Uname">Welcome Mark</span><br/>
                        <div class="Griddata">
                            <table class="" width="100%" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td>Name</td>
                                    <td>Mark</td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>Password</td>
                                    <td>*********</td>
                                    <td><a href="#">Edit</a></td>
                                </tr>
                                <tr>
                                    <td>Mobile Number</td>
                                    <td>0031612345678</td>
                                    <td><a href="#">Edit</a></td>
                                </tr>
                                <tr>
                                    <td>Device</td>
                                    <td>Nokia n97</td>
                                    <td><a href="#">Edit</a></td>
                                </tr>
                            </table>
                        </div>
                     	<div class="Griddata TopGap10">
                        	<h3>My Subscriptions</h3>
                        	<table class="SubscriptionsTable" width="100%" border="0" cellpadding="0" cellspacing="0">
                            	<tr>
                                    <td class="th">S.no</td>
                                    <td class="th">Name</td>
                                    <td class="th">Details</td>
                                    <td class="th">Termination</td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>Lorem ipsum</td>
                                    <td><a href="#">Delete</a></td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Mark</td>
                                    <td>Lorem ipsum</td>
                                    <td><a href="#">Delete</a></td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Mark</td>
                                    <td>Lorem ipsum</td>
                                    <td><a href="#">Delete</a></td>
                                </tr>
                            </table>
                     	</div>
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
</body>
</html>
