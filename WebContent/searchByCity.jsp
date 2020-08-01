<%@ include file="header_tag.jsp"%>
<jsp:include page="header.jsp">
	<jsp:param value="Search by City" name="frmHeading" />
</jsp:include>
<form action="searchStudentByCity" method="post">
	
	Select City:
	<select name="city">
		<option value="0">Select</option>
		<c:forEach var="c" items="${requestScope.cityList}">
				<option value="${c}">${c}</option>
			</c:forEach>
	</select>
	<input type="submit" value="Submit"/>
</form>