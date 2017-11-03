<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<spring:url value="/resources/bootstrap/js/bootstrap.min.js" var="bootstrapjs" />
<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapcss" />

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="${bootstrapcss}" rel="stylesheet" type="text/css" />

<c:set var="url">${pageContext.request.requestURL}</c:set>
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />


<title>Update kota</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Baza kotów</h1>
			<p>Spring MVC, JPA, Boostrap, JSTL example based on Cats Database.</p>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="list-group">
					<a href="cats" class="list-group-item list-group-item-action">Lista kotów</a>
					<a href="cats/add" class="list-group-item list-group-item-action">Dodaj kota</a>
				</div>
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
									<form:errors path="name" />
								</c:if>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-4 col-form-label" for="birthDate">Data urodzenia:</label>
							<div class="col-sm-8">
								<fmt:formatDate value="${catDto.birthDate}" pattern="yyyy-MM-dd" var="formattedDate" />
								<form:input path="birthDate" type="date" class="form-control" value="${formattedDate}" />
								<c:if test="${pageContext.request.method=='POST'}">
									<form:errors path="birthDate" />
								</c:if>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-4 col-form-label" for="weight">Waga:</label>
							<div class="col-sm-8">
								<form:input path="weight" type="number" min="0" step=".001" class="form-control" id="weight" placeholder="2.000" />
								<c:if test="${pageContext.request.method=='POST'}">
									<form:errors path="weight" />
								</c:if>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-4 col-form-label" for="owner">Imię opiekuna:</label>
							<div class="col-sm-8">
								<form:input path="owner" type="text" class="form-control" id="owner" placeholder="Adaś" />
								<c:if test="${pageContext.request.method=='POST'}">
									<form:errors path="owner" />
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

	<script type="text/javascript" src="${bootstrapjs}"></script>
</body>
</html>