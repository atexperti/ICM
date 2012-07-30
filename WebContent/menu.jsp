<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="menu">
			<s:set name="activeMenuId" value="activeMenuId"></s:set>
			
			<div class="menu-box<s:if test="%{#activeMenuId == 'home'}">-active</s:if>">
				<a href="home">Home</a>
			</div>
			<div class="menu-box<s:if test="%{#activeMenuId == 'media'}">-active</s:if>">
				<a href="media">Media</a>
			</div>
			<div class="menu-box<s:if test="%{#activeMenuId == 'events'}">-active</s:if>">
				<a href="events">Events</a>
			</div>
			<div class="menu-box<s:if test="%{#activeMenuId == 'lyrics'}">-active</s:if>">
				<a href="lyrics">Lyrics</a>
			</div>
			<div class="menu-box">
				<a href="articles">Articles</a>
			</div>
			<div class="menu-box<s:if test="%{#activeMenuId == 'support'}">-active</s:if>">
				<a href="support?menuID=support">Support</a>
			</div>
			<div class="menu-box<s:if test="%{#activeMenuId == 'aboutUs'}">-active</s:if>">
				<a href="aboutUS?menuID=aboutUs">About Us</a>
			</div>
			<div class="menu-box<s:if test="%{#activeMenuId == 'links'}">-active</s:if>">
				<a href="links?menuID=links">Links</a>
			</div>
			<div class="search-box">
				<input name="Search" type="text" size="20" maxlength="100" />
			</div>
			<div class="clear"></div>
		</div>