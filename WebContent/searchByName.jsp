<%@ include file="header_tag.jsp"%>
<jsp:include page="header.jsp">
	<jsp:param value="Search by Name" name="frmHeading" />
</jsp:include>
<form action="searchStudentByName" method="post">

	Enter Name:<input type="text" name="name" required="required" /> <br><input type="submit"
		value="Submit" />
</form>