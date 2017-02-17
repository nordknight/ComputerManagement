<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Computer Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Computer
</h1>

<c:url var="addAction" value="/computer/add" ></c:url>

<form:form action="${addAction}" commandName="computer">
<table>
	<c:if test="${!empty computer.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="inventoryNumber">
				<spring:message text="inventoryNumber"/>
			</form:label>
		</td>
		<td>
			<form:input path="inventoryNumber" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="ip">
				<spring:message text="ip"/>
			</form:label>
		</td>
		<td>
			<form:input path="ip" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="mac">
				<spring:message text="mac"/>
			</form:label>
		</td>
		<td>
			<form:input path="mac" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="chair">
				<spring:message text="chair"/>
			</form:label>
		</td>
		<td>
			<form:input path="chair" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="intendant">
				<spring:message text="intendant"/>
			</form:label>
		</td>
		<td>
			<form:input path="intendant" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="dateOfPurchase">
				<spring:message text="dateOfPurchase"/>
			</form:label>
		</td>
		<td>
			<form:input path="dateOfPurchase" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty computer.name}">
				<input type="submit"
					value="<spring:message text="Edit Computer"/>" />
			</c:if>
			<c:if test="${empty computer.name}">
				<input type="submit"
					value="<spring:message text="Add Computer"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Computer List</h3>
<c:if test="${!empty listComputers}">
	<table class="tg">
	<tr>
		<th width="80">Computer ID</th>
		<th width="120">Computer Inventory Number</th>
		<th width="120">Computer IP</th>
		<th width="120">Computer MAC</th>
		<th width="120">Computer Chair</th>
		<th width="120">Computer Name</th>
		<th width="120">Computer Intendant</th>
		<th width="120">Computer Date of Purchase</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listComputers}" var="computer">
		<tr>
			<td>${computer.id}</td>
			<td>${computer.inventoryNumber}</td>
			<td>${computer.ip}</td>
			<td>${computer.mac}</td>
			<td>${computer.chair}</td>
			<td>${computer.name}</td>
			<td>${computer.intendant}</td>
			<td>${computer.dateOfPurchase}</td>			
			<td><a href="<c:url value='/edit/${computer.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${computer.id}' />" >Delete</a></td>			
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>