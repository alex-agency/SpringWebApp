<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="post"> 
<table>
    <tr>
        <td><label>Title</label></td>
        <td><input name="title" value="${recipe.title}" /></td> 
    </tr>
    <tr>
        <td><label>Category</label></td>
        <td>
	        <select>
	        	<c:forEach var="category" items="${categories}">
	        		<option>${category.name}</option>
	        	</c:forEach>
	        	<option><a href="/add-category">New Category</a></option>
	    	</select>
    	</td>
    </tr>
    <tr>
        <td><label>Ingredients</label></td>
        <td><input name="ingredients" value="${recipe.ingredients}" /></td>
    </tr>
    <tr>
        <td><label>Recipe</label></td>
        <td><input name="body" value="${recipe.body}" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Save"/>
        </td>
    </tr>
</table>  
     
</form>