<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row-fluid">
	<h1>Book</h1>
	<div id="gridContainer">
		<form:form method="post" action="/book/list" commandName="filter"
			class="form-horizontal">
			<div class="control-group">
				<form:select path="propertyName" items="${criterias}"
					class="selectpicker" />
				<form:select path="operatorStr" items="${operators}"
					class="selectpicker" />
				<input id="value" name="value" type="text"
					class="form-control span4">
				<button type="submit" class="btn btn-success">search</button>
			</div>
		</form:form>

		<form:form method="post" action="/book/select"
			commandName="selectedObject" class="form-horizontal">
			<div class="form-horizontal">
				<button type="submit" name="actionButton" value="add"
					class="btn btn-danger btn-mini">select</button>
				<button type="submit" name="actionButton" value="cancel"
					class="btn btn-danger btn-mini">cancel</button>
			</div>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th></th>
						<th>title</th>
						<th>isbn></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${books}" var="book">
						<tr>
							<td><input type="radio" name="selectedAuth"
								value="${book.id}" /></td>
							<td>${book.title}</td>
							<td>${book.isbn}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form:form>
	</div>
</div>