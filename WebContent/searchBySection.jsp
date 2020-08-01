<%@ include file="header_tag.jsp"%>
<jsp:include page="header.jsp">
	<jsp:param value="Search by Section" name="frmHeading" />
</jsp:include>
<form action="searchStudentBySection" method="post">
	
	Select Section:
	<select name="section">
		<option value="0">Select</option>
		<c:forEach var="c" items="${requestScope.sectionList}">
				<option value="${c}">${c}</option>
			</c:forEach>
	</select>
	<input type="submit" value="Submit"/>
</form>