<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<!-- <script>var base = document.getElementsByTagName("base")[0].href;</script> -->

<title>Szczegóły kota</title>
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
					<a href="#" class="list-group-item active">Menu główne</a>
					<a href="wypisz" class="list-group-item list-group-item-action">Lista kotów</a>
					<a href="dodaj"	class="list-group-item list-group-item-action">Dodaj kota</a>
				</div>
				</div>
				<div class="col-md-9">
					<h4>Szczegóły kota</h4>
					<div class="container">
						<table class="table table-sm table-hover">
							  <thead>
							    <tr>
							      <th>#</th>
							      <th>Imię</th>
							      <th>Data urodzenia</th>
							      <th>Waga</th>
							      <th>Imię opiekuna</th>
							    </tr>
							  </thead>
							  <tbody>
							  
							    <tr>
							      <th scope="row">1</th>
							      <td>${kot.imie}</td>
							      <td>${kot.dataUrodzenia}</td>
							      <td>${kot.waga}</td>
							      <td>${kot.imieOpiekuna}</td>
							    </tr>
							    
							  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<script type="text/javascript" src="${bootstrapjs}"></script>
</body>
</html>