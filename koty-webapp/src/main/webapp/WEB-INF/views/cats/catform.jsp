<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	
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
				<div class="container">
					<c:choose>
						<c:when test="${catDto.custId == null}">
							<h1>Add Cat</h1>
						</c:when>
						<c:otherwise>
							<h1>Update Cat</h1>
						</c:otherwise>
					</c:choose>
					<br />

					<spring:url value="/cats" var="userActionUrl" />

					<form:form modelAttribute="catDto" method="post" action="${userActionUrl}">
						<c:if test="${catDto.custId!=null}">
							<div class="form-group row">
								<label class="col-sm-4 col-form-label" for="custId">ID:</label>
								<div class="col-sm-8">
									<form:input path="custId" type="text" class="form-control" id="custId" readonly="true" />
								</div>
							</div>
						</c:if>
						<div class="form-group row">
							<label class="col-sm-4 col-form-label" for="name">Imię kota:</label>
							<div class="col-sm-8">
								<form:input path="name" type="text" class="form-control" id="name" placeholder="Tofik" />
								<c:if test="${pageContext.request.method=='POST'}">
									<form:errors path="name" class="badge badge-pill badge-warning" />
								</c:if>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-4 col-form-label" for="birthDate">Data urodzenia:</label>
							<div class="col-sm-8">
								<fmt:formatDate value="${catDto.birthDate}" pattern="yyyy-MM-dd" var="formattedDate" />
								<form:input path="birthDate" type="date" class="form-control" value="${formattedDate}" />
								<c:if test="${pageContext.request.method=='POST'}">
									<form:errors path="birthDate" class="badge badge-pill badge-warning" />
								</c:if>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-4 col-form-label" for="weight">Waga:</label>
							<div class="col-sm-8">
								<form:input path="weight" type="number" min="0" step=".001" class="form-control" id="weight" placeholder="2.000" />
								<c:if test="${pageContext.request.method=='POST'}">
									<form:errors path="weight" class="badge badge-pill badge-warning" />
								</c:if>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-4 col-form-label" for="sex">Sex:</label>
							<div class="col-sm-8 ">
								<div class="form-check form-check-inline">
									<label class="form-check-label">
									 	<form:radiobutton class="form-check-input" path="sex" value="M" /> Male
									</label>
								</div>
								<div class="form-check form-check-inline">
									<label class="form-check-label">
									<%-- checked="${catDto.sex == 'M' ? 'checked':''}" --%>
									 	<form:radiobutton class="form-check-input" path="sex" value="F" /> Female
									</label>
								</div>
								<c:if test="${pageContext.request.method=='POST'}">
									<form:errors path="sex" class="badge badge-pill badge-warning" />
								</c:if>
							</div>

							</div>
							<div class="form-group row">
								<label class="col-sm-4 col-form-label" for="coloring">Coloring:</label>
								<div class="col-sm-8">
									<form:select path="coloring" items="${webColoringList}" multiple="false" size="5" class="form-control" />
									<c:if test="${pageContext.request.method=='POST'}">
										<form:errors path="coloring" class="badge badge-pill badge-warning" />
									</c:if>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-4 col-form-label" for="owner">Imię opiekuna:</label>
								<div class="col-sm-8">
									<form:input path="owner" type="text" class="form-control" id="owner" placeholder="Adaś" />
									<c:if test="${pageContext.request.method=='POST'}">
										<form:errors path="owner" class="badge badge-pill badge-warning" />
									</c:if>
								</div>
							</div>
							<div class="form-group row">

								<div class="ml-sm-auto col-sm-8">
									<c:choose>
										<c:when test="${catDto.custId==null}">
											<button type="submit" class="btn-sm btn-primary pull-right">Add</button>
										</c:when>
										<c:otherwise>
											<button type="submit" class="btn-sm btn-primary pull-right">Update</button>
										</c:otherwise>
									</c:choose>

								</div>
							</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<spring:url value="/resources/bootstrap/js/bootstrap.min.js" var="bootstrapjs" />
	<script type="text/javascript" src="${bootstrapjs}"></script>
</body>
</html>