<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container-fluid">
	<h1>Author List</h1>

	<form:form method="post" action="/author/list" commandName="criteria"
		class="form-horizontal">
		<div class="control-group">
			<form:select path="fieldName" items="${criterias}"
				class="selectpicker" />
			<form:select path="operatorStr" items="${operators}"
				class="selectpicker" />
			<input id="value" name="value" type="text" class="form-control span4">
			<button id="author-search" type="submit" class="btn btn-default">search</button>
		</div>
	</form:form>

	<form:form method="post" action="/author/edit"
		commandName="selectedObject">
		<div class="form-horizontal">
			<button type="submit" name="actionButton" value="edit" class="btn btn-default">edit</button>
			<button type="submit" name="actionButton" value="remove" class="btn btn-default">remove</button>
		</div>
		
		<div class="form-horizontal">
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th></th>
					<th>name</th>
					<th>contact</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${authors}" var="author">
					<tr>
						<td><input id="author-edit" type="radio"
							name="selectedObject" value="${author.id}" /></td>
						<td>${author.name}</td>
						<td>${author.contact}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</form:form>
	<script src="/resources/js/pages/menu.js"></script>
</div>
