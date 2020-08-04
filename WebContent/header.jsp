<%@ include file="header_tag.jsp"%>
<%@page import="com.example.model.Admin"%>
<%
	Admin admin = (Admin) session.getAttribute("admin");
	System.out.println(admin.getGmail());
%>
<style>
.logout {
	float: right;
}
</style>
<div align="center">
	<h3>${param.frmHeading}page</h3>
</div>
<hr>
<a href="selectAll">Select All</a>
||
<a href="RegisterStudentForm.jsp">Add Student </a>
||
<a href="searchStudentBySection">Search Student By Section</a>
||
<a href="searchStudentByCity">Search Student By City</a>
||
<a href="searchByName.jsp">Search Student By Name</a>
||
<div class="logout">
	<a href="logout" onclick="logout()" ><%= admin.getUserName() %></a>
</div>
<hr>
<script>
	function logout(){
		window.alert("Are you sure to logout?");
	}
</script>
