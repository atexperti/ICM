<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="login">

	<s:if test="%{#session.userId !=null}">

		<div class="user">

			<a href="register"> My Account </a>&nbsp;<a href="logout">Sign
				Out </a>
		</div>
	</s:if>
	<s:elseif test="%{#session.forgetpassword!=null}">
		<div class="user">
			<s:form action="getpassword" method="post">
				<span class="Star">*</span>
				<s:text name="forget.email.form.text" />
				<br />
				<s:textfield name="email" cssClass="TxtBox" />
				<br />
				<button type="submit" />
				Submit
				</button>
				<input type="button" name="Cancel" value="Cancel"
					class="GrayBtn LeftGap10" onclick="window.location = 'home' " />
				<br />
			</s:form>
		</div>
	</s:elseif>
	<s:else>
		<s:form action="login.action" method="post" theme="simple"
			onSubmit="javascript:return validateLogin(this)">
			<div class="user">
				<s:textfield name="userName" cssClass="LoginTxtBox" />
				<s:password name="password" cssClass="LoginTxtBox" />
			
				<button type="submit" />
				Login
				</button>
				<br /> <a href="forgetpassword">Forgot your password?</a><br /> <a
					href="register">No account yet? Sign up! </a>
			</div>


		</s:form>
	</s:else>
