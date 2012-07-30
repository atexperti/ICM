<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<s:include value="header.jsp"></s:include>
<s:include value="menu.jsp"></s:include>
	<div class="content" align="center">
		<p>
			<strong>Contact ICCOV. </strong>
		</p>
		<p>
			<table width="220" cellspacing="0" cellpadding="4" border="0" >
				<tbody align="left">
					<tr>
						<td>
							
								<strong>phone:</strong>
							
						</td>
						<td>925-895-0033</td>
					</tr>
					<tr>
						<td>
						
								<strong>address:</strong>
						
						</td>
						<td>19001 San Ramon Valley Blvd,<br> San Ramon, CA
								94583.</td>
					</tr>
					<tr>
						<td>
							<div align="left">
								<strong>email:</strong>
							</div>
						</td>
						<td>contact@iccov.org</td>
					</tr>
				</tbody>
			</table>
		</p>
	<s:form action="/support">
			<p>Fill out the form to send in your inquiry immediately.</p>
			<table width="220" cellspacing="0" cellpadding="4" border="0"
				class="smallbold">
				<tbody  align="left">
					<tr>
						<td>Name:<br><input name="Name" class="textbox"></td>
					</tr>
					<tr>
						<td>E-mail:<br><input name="EmailId" id="EmailId"
								class="textbox"></td>
					</tr>
					<tr>
						<td>Phone: (Optional)<br><input name="Phone" id="Phone"
								class="textbox"></td>
					</tr>
					<tr>
						<td>Subject:<br><input name="Subject" size="32"
								id="Subject" class="textbox"></td>
					</tr>
					<tr>
						<td>Comments:<br><textarea cols="32" rows="7"
									name="Message" id="Message" class="textbox"></textarea></td>
					</tr>
					<tr>
						<td><input type="submit" name="Submit" value="Submit"
							onclick="MM_validateForm('Name','','R','Email','','RisEmail','Subject','','R','Comments','','R');return document.MM_returnValue"
							class="submitbutton"></td>
					</tr>
				</tbody>
			</table>
</s:form>
			<div class="clear"></div>
	</div>


<s:include value="footer.jsp"></s:include>
