<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row-fluid">
	<h1>Publisher List</h1>

	<form:form method="post" action="/publisher/list" commandName="criteria"
		class="form-horizontal">
		<div class="control-group">
			<form:select path="fieldName" items="${criterias}"
				class="selectpicker" />
			<form:select path="operatorStr" items="${operators}"
				class="selectpicker" />
			<input id="value" name="value" type="text" class="form-control span4">
			<button id="publisher-search" type="submit" class="btn btn-success">search</button>
		</div>
	</form:form>

	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th></th>
				<th>name</th>
				<th>address</th>
				<th>phone</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${publishers}" var="publisher">
				<tr>
					<td><input type="radio" name="selectedObject"
						value="${publisher.id}" /></td>
					<td>${publisher.name}</td>
					<td>${publisher.address}</td>
					<td>${publisher.phone}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script src="/resources/js/pages/menu.js"></script>
</div>
