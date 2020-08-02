<%@ include file="header_tag.jsp"%>
<%@ page import="com.example.model.Student"%>
<jsp:include page="header.jsp">
	<jsp:param value="All Students" name="frmHeading" />
</jsp:include>
<c:if test="${empty requestScope.studentList}">
	<font color='red'>NO Student LIST</font>
</c:if>
<c:if test="${not empty requestScope.studentList}">
	<table border="1" width="100%">
		<tr>
			<th>No</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Section</th>
			<th>City</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach items="${requestScope.studentList}" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.firstName}</td>
				<td>${c.lastName}</td>
				<td>${c.section}</td>
				<td>${c.getAddress().getCity()}</td>
				<td><a href="updateStudent?Id=${c.id }">update</a></td>
				<td><a href="deleteStudent?Id=${c.id }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>