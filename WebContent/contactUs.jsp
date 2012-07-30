<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<s:include value="header.jsp"></s:include>
<div class="content">
<div class="box">
Contact ICM<br>
			<b>Phone:</b>925-895-0033<br>
			<b>Address:</b>19001 San Ramon Valley Blvd,<br>
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 San Ramon, CA 94583.<br>
			<b>Email:</b>testemail@gmail.com<br>
			Fill out the form to send in your inquiry immediately.
	
	<table>
		<tr>
			<td>
			Name:
			</td>
		</tr>
		<tr>
			<td>
			<input type="text" name="name"/>
			</td>
		</tr>
		<tr>
			<td>
			E-Mail:
			</td>
		</tr>
		<tr>
			<td>
			<input type="text" name="email"/>
			</td>
		</tr>
		<tr>
			<td>
			Phone(Optional):
			</td>
		</tr>
		<tr>
			<td>
			<input type="text" name="phone"/>
			</td>
		</tr>
		<tr>
			<td>
			Subject:
			</td>
		</tr>
		<tr>
			<td>
			<input type="text" name="subject"/>
			</td>
		</tr>
		<tr>
			<td>
			Comments:
			</td>
		</tr>
		<tr>
			<td>
			<textarea rows="5" cols="30" name="comments"></textarea>
			</td>
			
		</tr>
	</table>
	<input type="button" name="submit" value="Submit"/>
<s:include value="footer.jsp"></s:include>
</div>
</div>
