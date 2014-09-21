<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row-fluid">
	<h1>Add Author</h1>
	<form:form method="post" action="/author/add" commandName="author"
			class="form-horizontal">

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<input type="text" name="name" id="name" value="${author.name}">
				</div>
			</div>
			<div class="form-group">
				<label for="contact" class="col-sm-2 control-label">Contact</label>
				<div class="col-sm-10">
					<input type="text" name="contact" id="contact" value="${author.contact}">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button id="author-add" type="submit" class="btn btn-default">submit</button>
					<button id="author-cancel" type="submit" class="btn btn-default">cancel</button>
				</div>
			</div>
		</form:form>
</div>