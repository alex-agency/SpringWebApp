<form method="post">
 
<table>
    <tr>
        <td><label>Title</label></td>
        <td><input name="title" value="${recipe.title}" /></td> 
    </tr>
    <tr>
        <td><label>Category</label></td>
        <td><input name="category" value="${category.name}" /></td>
    </tr>
    <tr>
        <td><label>Recipe</label></td>
        <td><input name="recipe" value="${recipe.recipe}" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Save"/>
        </td>
    </tr>
</table>  
     
</form>