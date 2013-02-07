<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form:form id="form" method="post" modelAttribute="recipe" class="form-horizontal">
	<fieldset><legend>Recipe info</legend>
		<div class="control-group">
			<form:label class="control-label" path="title">Title</form:label>
			<div class="controls">
				<form:input path="title" placeholder="Title"/>
				<span class="help-inline"><form:errors path="title"/></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" path="category">Category</label>
			<div class="controls">
				<select name="categories">
					<c:forEach var="category" items="${categories}">
						<option>${category.name}</option>
					</c:forEach>
				</select>
				<%-- <form:form modelAttribute="categories">
					<form:select path="name">
	    				<form:option value="" label="-- Choose one--" />
	    				<form:options items="${categories}" itemValue="id" itemLabel="name" />
					</form:select>
					<form:errors path="name">
	    				<span class="help-inline"><form:errors path="name" /></span>
					</form:errors>
				</form:form> --%>
			</div>
		</div>
		<div class="control-group">
			<form:label class="control-label" path="ingredients">Ingredients</form:label>
			<div class="controls">
				<form:input path="ingredients" placeholder="Ingredients"/>
				<span class="help-inline"><form:errors path="ingredients"/></span>
			</div>
		</div>
		<div class="control-group">
			<form:label class="control-label" path="body">Recipe</form:label>
			<div class="controls">
				<form:textarea path="body" rows="5"/>
				<span class="help-inline"><form:errors path="body"/></span>
			</div>
		</div>
	</fieldset>
	
	<div class="form-actions">
		<button type="submit" class="btn btn-primary">Save changes</button>
		<button type="button" class="btn">Cancel</button>
	</div>
</form:form>