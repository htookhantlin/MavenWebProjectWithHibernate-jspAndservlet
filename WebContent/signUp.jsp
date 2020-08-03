<%@ include file="header_tag.jsp"%>
<div align="center">
	<h3>Sign Up page</h3>
</div>
<h1>PLEASE SIGN UP</h1>
<form action="saveAdmin" method="post">
	<table border="0">
		<tr>
			<td><b>Enter user name:</b></td>
			<td><input type="text" name="userName" required="required" /></td>
		</tr>
		<tr>
			<td><b>Enter Gmail:</b></td>
			<td><input type="email" name="gmail" required="required" /></td>
		</tr>
		<tr>
			<td><b>Enter password:</b></td>
			<td><input type="password" name="password"  required="required"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Save" name="save" /></td>
		</tr>
	</table>
</form>
Already have an account 
<a href="login.jsp">LOGIN HERE</a>