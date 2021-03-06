<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	
	<jsp:include page="../fragments/header.jsp" />

<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Cats Database</h1>
			<p>Spring MVC, JPA, Boostrap, JSTL example based on Cats Database.</p>
		</div>
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="../fragments/navbar.jsp" />
			</div>
			<div class="col-md-9">
				<c:if test="${not empty msg}">
					<div class="alert alert-${css} alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<strong>${msg}</strong>
					</div>
				</c:if>
				<h4>Cat details</h4>
				<div class="container">
					<dl class="row">
						<dt class="col-sm-3">#ID</dt>
						<dd class="col-sm-9">${cat.custId}</dd>
						<dt class="col-sm-3">Name</dt>
						<dd class="col-sm-9">${cat.name}</dd>
						<dt class="col-sm-3">Birtd Date</dt>
						<dd class="col-sm-9">
							<fmt:formatDate pattern="dd.MM.yyyy" value="${cat.birthDate}" />
						</dd>
						<dt class="col-sm-3">Weight</dt>
						<dd class="col-sm-9">${cat.weight}</dd>
						<dt class="col-sm-3">Sex</dt>
						<dd class="col-sm-9">${cat.sex}</dd>
						<dt class="col-sm-3">Coloring</dt>
						<dd class="col-sm-9">${cat.coloring}</dd>
						<dt class="col-sm-3">Owner</dt>
						<dd class="col-sm-9">${cat.owner}</dd>
					</dl>


				</div>
			</div>
		</div>
	</div>
	<spring:url value="/resources/jquery/jquery-3.2.1.min.js" var="jqueryMinJs" />
	<spring:url value="/resources/bootstrap/js/bootstrap.min.js" var="bootstrapjs" />
	<script type="text/javascript" src="${jqueryMinJs}"></script>
	<script type="text/javascript" src="${bootstrapjs}"></script>

</body>
</html>