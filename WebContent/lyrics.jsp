<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<s:include value="header.jsp"></s:include>
	<s:include value="menu.jsp"></s:include>
<s:form action="/lyrics">
	<div class="content">
		<div class="left-cont">
        	<div class="box-l">
            	<div class="lyrics-search">
                	<input name="keyWords" type="text" value="Search Lyrics" size="30" maxlength="30" onkeydown="if(event.keyCode == 13) document.forms[0].submit();" />
                    <hr />
                    <div class="lyrics-list">
                    <s:hidden name="lyricId" value="" id="lyricId"></s:hidden>
                    	<table width="0" border="0">
	                      	<s:iterator value="%{#session.lyrics}">
		                      	<tr>
		                        <td><a href="#" onclick="showLyrics('<s:property value="lyricsId"/>')"><s:property value="title"/></a></td>
		                      	</tr>
	                      	</s:iterator>
                    </table>
                    </div>
                </div>
            </div>
            <div class="box-l">
            	<div class="lyrics-cont">
                	<div class="title"><s:property value="%{#session.albumName}"/></div>
                    <div class="">
                    	<p><s:property value="%{#session.textLyrics}"/></p>   
                    	
                    </div>
                </div>
            </div>
		</div>
        <div class="right-cont">
        </div>
        <div class="clear"></div>
    </div>

    </s:form>
<s:include value="footer.jsp"></s:include>