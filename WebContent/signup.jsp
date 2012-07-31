<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<s:include value="header.jsp"></s:include>
<s:include value="menu.jsp"></s:include>


<div class="content">
	<div class="left-cont">
		<div class="box-l">
			<h1><s:text name="Sign.Up"></s:text></h1>
			<h3>It's free and always will be.</h3>

			<form action="http://signup.php" method="post">
				<fieldset>
					<table>
						<tr>
							<td width="150px"><strong>Name</strong></td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td><strong>Username</strong></td>
							<td><input type="text" name="username"></td>
						</tr>
						<tr>
							<td><strong>Confirm username</strong></td>
							<td><input type="text" name="confirmusername"></td>
						</tr>
						<tr>
							<td><strong>Password</strong></td>
							<td><input type="text" name="password"></td>
						</tr>
						<tr>
							<td><strong>Confirm Password</strong></td>
							<td><input type="text" name="c-password"></td>
						</tr>
						<tr>
							<td><strong>Church Name</strong></td>
							<td><input type="text" name="churchname"></td>
						</tr>
						<tr>
							<td><strong>Address</strong></td>
							<td><input type="text" name="add1"></td>
						</tr>
						<tr>
							<td><strong>City</strong></td>
							<td><input type="text" name="city"></td>
						</tr>
						<tr>
							<td><strong>Captcha</strong></td>
							<td><input type="text" name="captcha"></td>
						</tr>
					</table>
				</fieldset>

				<fieldset style="text-align: center">

					<br />
					<br /> By clicking Sign Up, you agree to our Terms and that you
					have read and understand our Data Use Policy, including our Cookie
					Use.<input type="checkbox" name="agreeWithTerms" value="Y">

					<?php
      if(array_key_exists('cumulativeErrorMessage', $_POST) && $_POST['cumulativeErrorMessage'] != '') {
    ?>
					<fieldset style="color: #ff0000;">
						<legend>There were errors</legend>
						<?php echo $_POST['cumulativeErrorMessage']?>
					</fieldset>
					<?php
      }
    ?>
					<br /> <label class="botton-bg"><input type="submit"
						value="Signup"></label> <input type="hidden" name="errorUrl"
						value="http://html_signup_form.php"> <input type="hidden"
						name="successUrl" value="http://after_signup.php">
			</form>
		</div>
	</div>
	<div class="right-cont"></div>
	<div class="clear"></div>
</div>

<s:include value="footer.jsp"></s:include>
