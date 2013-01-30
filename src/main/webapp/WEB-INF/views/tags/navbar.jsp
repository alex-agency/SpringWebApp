<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- .btn-navbar is used as the toggle for collapsed navbar content -->
<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
</a>

<a class="brand" href="#">Cook Book</a>

<div class="navbar-search pull-right">
	<input type="text" data-provide="typeahead" class="search-query" placeholder="Search">
</div>

<div class="nav-collapse">
	<ul class="nav">
		<c:forEach var="category" items="${categories}">
			<li><a href="#${category.name}">${category.name}</a></li>
		</c:forEach>
	</ul>
</div-->