<c:if test="${!ajaxRequest}">
<form method="post">
<table>
    <tr>
        <td><label>Name</label></td>
        <td><input name="name" value="${category.name}" /></td> 
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Save"/>
        </td>
    </tr>
</table>
</form>

<script type="text/javascript">
	$(document).ready(function() {
	$("#form").submit(function() {  
		$.post($(this).attr("action"), $(this).serialize(), function(html) {
			$("#formsContent").replaceWith(html);
			$('html, body').animate({ scrollTop: $("#message").offset().top }, 500);
		});
		return false;  
		});			
	});
</script>
</c:if>