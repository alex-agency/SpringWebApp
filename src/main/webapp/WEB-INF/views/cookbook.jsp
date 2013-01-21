<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="category" items="${categories}">
	
	<section id="${category.id}">
		<div class="page-header">
			<h2>${category.name}</h2>
		</div>
		
		<ul class="thumbnails">
			<c:forEach var="recipe" items="${category.recipes}">
				
				<li><a class="thumbnail" href="/recipe/${recipe.id}">${recipe}</a></li>
			</c:forEach>
		</ul>
	</section>
</c:forEach>

<section id="category">
	<div class="page-header">
		<h2>Category</h2>
	</div>
	
	<ul class="thumbnails">
		<c:forEach var="recipe" items="${recipes}">
			<li><a class="thumbnail" href="/recipe/${recipe.id}">${recipe}</a></li>
		</c:forEach>
	</ul>
</section>

<!--section id="category1">
	<div class="page-header">
		<h2>Main dishes</h2>
	</div>

	<ul class="thumbnails">
		<li><a class="thumbnail" href="#">Apple Pie</a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
	</ul>
</section>

<section id="category2">
	<div class="page-header">
		<h2>Main dishes2</h2>
	</div>

	<ul class="thumbnails">
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
		<li><a class="thumbnail" href="#"><img src="holder.js/200x200"></a></li>
	</ul>
</section-->