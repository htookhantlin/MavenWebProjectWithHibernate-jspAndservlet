<%@ include file="header_tag.jsp"%>
<jsp:include page="header.jsp">
	<jsp:param value="Register Student" name="frmHeading" />
</jsp:include>
<form action="addStudent" method="post">
	<table border="0">
		<tr>
			<td>Enter First Name:</td>
			<td><input type="text" name="firstName" required="required" /></td>
		</tr>
		<tr>
			<td>Enter Last Name:</td>
			<td><input type="text" name="lastName" required="required" /></td>
		</tr>
		<tr>
			<td>Enter Section:</td>
			<td><input type='text' name='section' required="required" /></td>
		</tr>
		<tr>
			<td>Enter Street:</td>
			<td><input type='text' name='street' required="required" /></td>
		</tr>
		<tr>
			<td>Enter City:</td>
			<td><input type='text' name='city' required="required" /></td>
		</tr>
		<tr>
			<td>Enter Country:</td>
			<td><input type='text' name='country' required="required" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit" /></td>
		</tr>
	</table>


	<%-- Select Category:
	<select name="frmCatId">
		<option value="0">Select</option>
		<c:forEach var="c" items="${requestScope.catList}">
				<option value="${c.catId}">${c.catName}</option>
			</c:forEach>
	</select><br> --%>

</form>