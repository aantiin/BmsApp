<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row-fluid">
	<h1>Category</h1>
	<form:form method="post" action="/category/add" commandName="category"
			class="form-horizontal">

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<input type="text" name="name" id="name" value="${category.name}">
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-sm-2 control-label">Description</label>
				<div class="col-sm-10">
					<input type="text" name="description" id="description" value="${category.description}">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button id="publisher-add" type="submit" class="btn btn-default">submit</button>
					<button id="publisher-cancel" type="submit" class="btn btn-default">cancel</button>
				</div>
			</div>
		</form:form>
		<script src="/resources/js/pages/menu.js"></script>
</div>