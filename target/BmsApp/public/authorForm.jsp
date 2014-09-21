<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row-fluid">
	<h1>Add Author</h1>
	<div id="gridContainer">
		<form:form method="post" action="/author/submit" commandName="book"
			class="form-horizontal">
			<div class="control-group">
				<label class="control-label">Name</label>
				<div class="controls">
					<input type="text" name="name" id="name" title="name"
						value="${author.name}">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">Contact</label>
				<div class="controls">
					<input type="text" name="contact" id="contact" title="contact"
						value="${author.contact}">
				</div>
			</div>
			<div class="form-actions">
				<button type="submit" id="btnSubmit" name="actionButton"
					value="submit" class="btn btn-success btn-edit">
					submit
				</button>
				<button type="submit" name="actionButton" value="cancel" class="btn">
					cancel
				</button>
			</div>
		</form:form>
	</div>
</div>