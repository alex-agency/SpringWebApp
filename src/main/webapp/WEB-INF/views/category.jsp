<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form class="form-horizontal">
	<fieldset><legend>Category info</legend>
		<div class="well">${category.name}</div>
	</fieldset>
	
	<a href="${category.id}/edit" class="btn btn-primary">Edit</a>
	<a href="${category.id}/delete" class="btn btn-primary">Delete</a>
</form>

<ul>
	<c:forEach var="recipe" items="${category.recipes}">
		<li><a href="/recipe/${recipe.id}">${recipe}</a></li>
	</c:forEach>
</ul>