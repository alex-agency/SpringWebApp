<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form modelAttribute="recipe" class="form-horizontal">
	<fieldset><legend>Recipe info</legend>
		<ul class="thumbnails">
			<li class="span4">
				<h3>${recipe.title}</h3>
				<p>${recipe.ingredients}</p>
				<p>${recipe.body}</p>
			</li>
			<li class="span4 thumbnail" >
				<img data-src="holder.js/380x380">
			</li>
		</ul>
	</fieldset>
	
	<a href="${recipe.id}/edit" class="btn btn-primary">Edit</a>
	<a href="${recipe.id}/delete" class="btn btn-primary">Delete</a>
</form:form>