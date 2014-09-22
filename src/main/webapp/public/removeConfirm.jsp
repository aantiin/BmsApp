<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row-fluid">
	<h1>Remove Confirmation</h1>
	<p>are you sure want to remove this data?</p>
	<form:form method="post" action="/author/remove" commandName="value"
		class="form-horizontal">
		<div class="alert alert-warning">
			${message} <input type="hidden" name="value" value="${value}" />
		</div>
		<div class="form-horizontal">
			<button type="submit" name="actionButton" value="remove"
				class="btn btn-default">remove</button>
			<button type="submit" name="actionButton" value="cancel"
				class="btn btn-default">cancel</button>
		</div>
	</form:form>
</div>