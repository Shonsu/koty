<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<spring:url value="/resources/bootstrap/js/bootstrap.min.js" var="bootstrapjs" />
<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapcss" />
<spring:url value="/resources/jquery/jquery-3.2.1.min.js" var="jqueryMinJs" />
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="${bootstrapcss}" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${jqueryMinJs}"></script>


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
					<a href="#" class="list-group-item active">Menu główne</a>
					<a href="wypisz" class="list-group-item list-group-item-action">Lista kotów</a>
					<a href="dodaj"	class="list-group-item list-group-item-action">Dodaj kota</a>
					<a href="szczegoly"	class="list-group-item list-group-item-action">Szczegóły</a>
					<a href="#"	class="list-group-item list-group-item-action disabled">pit pitu</a>
				</div>
				</div>
				<div class="col-md-9">
					<h4>Lista kotów</h4>
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
							  <c:forEach var="element" items="${koty}" varStatus="loop">
							    <tr class='clickable-row' data-href='szczegoly/${element.custId}'>
							      <th scope="row">${loop.index} / ${loop.count} / ${element.custId}</th>
							      <td>${element.imie}</td>
							      <td><fmt:formatDate  pattern="dd.MM.yyyy" value="${element.dataUrodzenia}" /></td>
							      <td>${element.waga}</td>
							      <td>${element.imieOpiekuna}</td>
							    </tr>
							    </c:forEach>
							  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
			    $(".clickable-row").click(function() {
			        window.location = $(this).data("href");
			    });
			});
		</script>
		<script type="text/javascript" src="${bootstrapjs}"></script>
</body>
</html>
