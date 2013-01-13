<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Recipe Manager</title>
</head>
<body>
<h2>Recipe Manager</h2>
<form:form method="post" action="addRecipe.html">
 
<table>
    <tr>
        <td><form:label path="title">Title</form:label></td>
        <td><form:input path="title" /></td> 
    </tr>
    <tr>
        <td><form:label path="category">Category</form:label></td>
        <td><form:input path="category" /></td>
    </tr>
    <tr>
        <td><form:label path="recipe">Recipe</form:label></td>
        <td><form:input path="recipe" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Add Recipe"/>
        </td>
    </tr>
</table>  
     
</form:form>
</body>
</html>
