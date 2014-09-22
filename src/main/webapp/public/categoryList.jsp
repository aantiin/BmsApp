<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row-fluid">
	<h1>Category List</h1>

	<form:form method="post" action="/category/list" commandName="criteria"
		class="form-horizontal">
		<div class="control-group">
			<form:select path="fieldName" items="${criterias}"
				class="selectpicker" />
			<form:select path="operatorStr" items="${operators}"
				class="selectpicker" />
			<input id="value" name="value" type="text" class="form-control span4">
			<button id="category-search" type="submit" class="btn btn-default">search</button>
		</div>
	</form:form>

	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th></th>
				<th>name</th>
				<th>description</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categories}" var="category">
				<tr>
					<td><input type="radio" name="selectedObject"
						value="${category.id}" /></td>
					<td>${category.name}</td>
					<td>${category.description}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script src="/resources/js/pages/menu.js"></script>
</div>
