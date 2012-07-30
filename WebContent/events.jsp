<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<s:include value="header.jsp"></s:include>
	<s:include value="menu.jsp"></s:include>
	<s:form action="/events">

	<div class="content">
		<div class="left-cont">
  			<div class="box-l">
        	<div class="events-select"> 
            <s:select list="%{#session.regions}" headerValue="Region" headerKey="-1" name="region">
            </s:select> 
            </div>
            <div class="events-select">
            <s:select list="%{#session.places}" headerValue="Place" headerKey="-1" name="place">
            </s:select> 
            </div>
            <div class="events-select"> 
	            <s:select list="%{#session.spLanguages}" headerValue="Language" headerKey="-1" name="spLanguage">
	            </s:select> 
            </div>
            <div class="events-select"> 
            <select name="sortBy">
  								<option>Sort By </option>
  								 <option>place Asc</option>
  								  <option>place Desc</option>
  								 <option>Language Asc</option>
  								  <option>Language Desc</option>
  								 <option>Region Asc</option>
  								  <option>Region Desc</option>
							  </select> 
            </div>
           <div class="events-select">
            <s:textfield name="keyword" type="text" value="Keyword" size="20" maxlength="30" onkeydown="if(event.keyCode == 13) document.forms[0].submit();"/>
           </div>
             <div class="events-select">
            <input name="Sort" type="submit" value="Sort" />
           </div>
         	<div class="clear"></div>  
         </div>
         	<div class="box-l">         
             <table class="conference">
                <tr class="table-header">
                     <td class="table-events">Event</td>
                    <td class="table-events">Spectator Language</td>
                    <td class="table-disc">Description</td>
                    <td class="table-date">Date/Time</td>
                    <td class="table-place">Region</td>
                    <td class="table-place">Place</td>
                </tr>
                <s:iterator value="%{#session.events}">
                <tr>
                    <td class="table-events"><s:property value="eventName"/></td>
                    <td class="table-events"><s:property value="spectatorLanguage"/></td>
                    <td class="table-disc"><s:property value="eventDescription"/></td>
                    <td class="table-date"><s:property value="datetime"/></td>
                    <td class="table-place"><s:property value="region"/></td>
                    <td class="table-place"><s:property value="place"/></td>
                </tr>
                </s:iterator>
            </table>
		</div> 
        	<div class="clear"></div>
		</div>
        <div class="right-cont">
        </div>
        <div class="clear"></div>
    </div>
</s:form>
    
<s:include value="footer.jsp"></s:include>    