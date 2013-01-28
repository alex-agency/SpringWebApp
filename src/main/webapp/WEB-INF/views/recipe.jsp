<form>
 
<table>
    <tr>
        <td><label>Title</label></td>
        <td><input name="title" value="${recipe.title}" /></td> 
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
        <td><a href="${recipe.id}/edit">Edit</a></td>
        <td><a href="${recipe.id}/delete">Delete</a></td>
    </tr>
</table>  
     
</form>