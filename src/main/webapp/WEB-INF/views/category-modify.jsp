<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%-- <c:if test="${!ajaxRequest}"> --%>

<form:form id="form" method="post" modelAttribute="category" class="form-horizontal">
	<fieldset><legend>Category info</legend>
		<div class="control-group">
			<form:label class="control-label" path="name">Name</form:label>
			<div class="controls">
				<form:input path="name" placeholder="Name"/>
				<span class="help-inline"><form:errors path="name"/></span>
			</div>
		</div>
	</fieldset>
	
	<div class="form-actions">
		<button type="submit" class="btn btn-primary">Save changes</button>
		<button type="button" class="btn">Cancel</button>
	</div>
</form:form>

<!-- <script type="text/javascript">
	$(document).ready(function() {
		$("#form").submit(function() {  
			$.post($(this).attr("action"), $(this).serialize(), function(html) {
			});
			return false;  
		});			
	});
</script>

</c:if> -->