<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
    <tr>
        <td><label>Name</label></td>
        <td><input name="name" value="${category.name}" /></td> 
    </tr>
    <tr>
        <td><a href="${category.id}/edit">Edit</a></td>
        <td><a href="${category.id}/delete">Delete</a></td>
    </tr>
    <ul>
		<c:forEach var="recipe" items="${category.recipes}">
			<li><a href="/recipe/${recipe.id}">${recipe}</a></li>
		</c:forEach>
	</ul>
</table>