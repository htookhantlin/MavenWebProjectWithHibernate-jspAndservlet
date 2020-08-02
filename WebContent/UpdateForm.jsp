<%@ include file="header_tag.jsp"%>
<jsp:include page="header.jsp">
	<jsp:param value="Update Student" name="frmHeading" />
</jsp:include>
<form action="updateStudent" method="post">
	<table border="0">
		<c:forEach items="${requestScope.studentList}" var="c">

			<tr>
				<td>Enter First Name:</td>
				<td><input type="text" name="firstName" required="required"
					value="${c.firstName }" /></td>
			</tr>
			<tr>
				<td>Enter Last Name:</td>
				<td><input type="text" name="lastName" required="required"
					value="${c.lastName }" /></td>
			</tr>
			<tr>
				<td>Enter Section:</td>
				<td><input type='text' name='section' required="required"
					value="${c.section }" /></td>
			</tr>
			<tr>
				<td>Enter Street:</td>
				<td><input type='text' name='street' required="required"
					value="${c.getAddress().getStreet() }" /></td>
			</tr>
			<tr>
				<td>Enter City:</td>
				<td><input type='text' name='city' required="required"
					value="${c.getAddress().getCity() }" /></td>
			</tr>
			<tr>
				<td>Enter Country:</td>
				<td><input type='text' name='country' required="required"
					value="${c.getAddress().getCountry() }" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</c:forEach>

	</table>


	<%-- Select Category:
	<select name="frmCatId">
		<option value="0">Select</option>
		<c:forEach var="c" items="${requestScope.catList}">
				<option value="${c.catId}">${c.catName}</option>
			</c:forEach>
	</select><br> --%>

</form>