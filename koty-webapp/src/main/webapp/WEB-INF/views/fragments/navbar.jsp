<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
				<div class="list-group">
					<spring:url value="/" var="catsUrlM" />
					<spring:url value="/cats/add" var="AddCatUrlM" />
					<a href="${catsUrlM}" class="list-group-item list-group-item-action">Cats list</a> <a href="${AddCatUrlM}"
						class="list-group-item list-group-item-action">Add cat</a>
				</div>