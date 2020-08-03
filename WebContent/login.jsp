<%@ include file="header_tag.jsp"%>
<div align="center">
	<h3>Login page</h3>
</div>
<h1>PLEASE LOGIN</h1>
<form action="loginAdmin" method="post">
	<table border="0">
		<tr>
			<td><b>Enter user name:</b></td>
			<td><input type="text" name="userName" required="required" /></td>
		</tr>
		<tr>
			<td><b>Enter gmail:</b></td>
			<td><input type="email" name="gmail" required="required" /></td>
		</tr>
		<tr>
			<td><b>Enter password:</b></td>
			<td><input type="password" name="password" required="required" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				value="Login" name="login" /></td>
		</tr>
	</table>
</form>
New User Create Account
<a href="signUp.jsp">SIGN UP Here</a>