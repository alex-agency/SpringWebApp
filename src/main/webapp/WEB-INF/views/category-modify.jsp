<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:if test="${!ajaxRequest}">
<form:form id="form" method="post" modelAttribute="category">
	<fieldset><legend>Category info</legend>
		<div class="control-group">
			<form:label class="control-label" path="name">
				Name <form:errors path="name" />
			</form:label>
			<div class="controls">
				<form:input path="name" placeholder="Name" />
			</div>
		</div>
	</fieldset>
	
	<button type="submit" class="btn btn-primary">Submit</button>
</form:form>

<script type="text/javascript">
	$(document).ready(function() {
		$("#form").submit(function() {  
			$.post($(this).attr("action"), $(this).serialize(), function(html) {
			});
			return false;  
		});			
	});
</script>
</c:if>