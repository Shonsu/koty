<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<spring:url value="/resources/bootstrap/js/bootstrap.min.js" var="bootstrapjs" />
<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapcss" />

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="${bootstrapcss}" rel="stylesheet" type="text/css" />


<title>Dodaj kota</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Baza kotów</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for developing responsive, mobile-first projects on
				the web.</p>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="list-group">
					<a href="#" class="list-group-item active"> Menu główne</a>
					<a href="wypisz" class="list-group-item list-group-item-action">Lista kotów</a>
					<a href="dodaj"	class="list-group-item list-group-item-action">Dodaj kota</a>
				</div>
				</div>
				<div class="col-md-9">
					<h4>Podaj Dane kota:</h4>
					<div class="container">
						<form:form modelAttribute="kotDto" method="post">
							<div class="form-group row">
								<label class="col-sm-4 col-form-label" for="imie">Imię kota:</label>
								<div class="col-sm-8">
									<form:input path="imie" type="text" class="form-control" id="imie" placeholder="Tofik" />
									<c:if test="${pageContext.request.method=='POST'}"><form:errors path="imie" /></c:if>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-4 col-form-label" for="data_urodzenia">Data urodzenia:</label>
								<div class="col-sm-8">
									<form:input path="dataUrodzenia" type="date" class="form-control"  />
									<c:if test="${pageContext.request.method=='POST'}"><form:errors path="dataUrodzenia" /></c:if>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-4 col-form-label" for="waga">Waga:</label>
								<div class="col-sm-8">
									<form:input path="waga" type="number" min="0" step=".001" class="form-control" id="waga" placeholder="2.000" />
									<c:if test="${pageContext.request.method=='POST'}"><form:errors path="waga" /></c:if>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-4 col-form-label" for="opiekun">Imię opiekuna:</label>
								<div class="col-sm-8">
									<form:input path="imieOpiekuna" type="text" class="form-control" id="opiekun" placeholder="Adaś" />
									<c:if test="${pageContext.request.method=='POST'}"><form:errors path="imieOpiekuna" /></c:if>
								</div>
							</div>
							<div class="form-group row">

								<div class="ml-sm-auto col-sm-8">
									<button type="submit" class="btn btn-primary">Dodaj</button>
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