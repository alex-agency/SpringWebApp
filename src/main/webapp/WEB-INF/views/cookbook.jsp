<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="category" items="${categories}">
	<section id="${category.name}">
		<div class="page-header">
			<h2><a href="/category/${category.id}">${category.name}</a></h2>
		</div>
		
		<ul class="thumbnails">
			<c:forEach var="recipe" items="${category.recipes}">
				<li class="span3">
					<a href="/recipe/${recipe.id}" class="thumbnail">
						<img data-src="holder.js/260x200">
						<div class="caption">
      						<h3>${recipe.title}</h3>
    					</div>
    				</a>
				</li>
			</c:forEach>
		</ul>
	</section>
</c:forEach>