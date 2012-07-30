<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<s:include value="header.jsp"></s:include>
<s:include value="menu.jsp"></s:include>
<div class="content">
	<div class="box-l">
		<div class="vdo">
			<!-- this A tag is where your Flowplayer will be placed. it can be anywhere -->
			<a
				href="http://pseudo01.hddn.com/vod/demo.flowplayervod/flowplayer-700.flv"
				style="display: block; width: 380px; height: 320px" id="player">
			</a>

			<!-- this will install flowplayer inside previous A- tag. -->
			<script>
				flowplayer("player", "swf/flowplayer-3.2.11.swf");
				function changeFile(url) {
					document.getElementById('player').href = url;
					flowplayer("player", "swf/flowplayer-3.2.11.swf");
				}
			</script>
		</div>
		<div class="title">Latest Video</div>
		<div class="log-media-v">
			<table width="0" border="0">
				<s:iterator value="%{#session.video}">
					<tr>
						<td><a href="#"
							onclick="changeFile('<s:property value="preview"/>')"><s:property
									value="title" /></a></td>
					</tr>
				</s:iterator>
			</table>

		</div>
	</div>

	<div class="box">
		<div class="box-l">
			<div class="title">Image of the Day</div>
			<div class="image-of-the-day">
				<img src="<s:property value="#session.imageOftheDay"/>" width="248" height="185" />
			</div>
		</div>
		<div class="clear"></div>
		<div class="box-l">
			<div class="inspiration"></div>
		</div>
	</div>
	<div class="box-l">
		<div class="title">Latest Music</div>
		<div class="log">
			<div class="log-media-a">
				<table width="0" border="0">
					<s:iterator value="%{#session.audio}">
            			<tr>
                        <td><a href="#" onclick="changeFile('<s:property value="preview"/>')"><s:property value="title"/></a></td>
                      </tr>
            		</s:iterator>
				</table>
			</div>
		</div>
		<div class="ado"></div>
	</div>
	<div class="clear"></div>
</div>
<s:include value="footer.jsp"></s:include>
