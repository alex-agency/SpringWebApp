<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form modelAttribute="category" class="form-horizontal">
	<fieldset><legend>Category info</legend>
		<div class="well">${category.name}</div>
	</fieldset>
	
	<a href="${category.id}/edit" class="btn btn-primary">Edit</a>
	<a href="${category.id}/delete" class="btn btn-primary">Delete</a>
</form:form>