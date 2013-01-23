<form>
 
<table>
    <tr>
        <td><label>${recipe.title}</label></td>
    </tr>
    <tr>
        <td><label>${category.name}</label></td>
    </tr>
    <tr>
        <td><label>${recipe.recipe}</label></td>
    </tr>
    <tr>
        <td><a href="${recipe.id}/edit">Edit</a></td>
        <td><a href="${recipe.id}/delete">Delete</a></td>
    </tr>
</table>  
     
</form>