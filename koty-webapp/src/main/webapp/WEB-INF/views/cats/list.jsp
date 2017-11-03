<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
				<c:if test="${not empty msg}">
					<div class="alert alert-${css} alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<strong>${msg}</strong>
					</div>
				</c:if>
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
								<th></th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="element" items="${koty}" varStatus="loop">
								<%-- <tr class='clickable-row' data-href='szczegoly/${element.custId}'> --%>
								<tr>
									<th scope="row" class="align-middle">${loop.index}/ ${loop.count} / ${element.custId}</th>
									<td class="align-middle">${element.name}</td>
									<td class="align-middle"><fmt:formatDate pattern="dd.MM.yyyy" value="${element.birthDate}" /></td>
									<td class="align-middle">${element.weight}</td>
									<td class="align-middle">${element.owner}</td>
									<td class="align-middle">
									
									<spring:url value="/cats/${element.custId}/" var="userUrl" />
									<spring:url value="/users/${element.custId}/delete" var="deleteUrl" />
									<spring:url value="/cats/${element.custId}/update" var="updateUrl" />
									
									
									<button class="btn btn-info btn-sm" onclick="location.href='${updateUrl}'">Update</button>
										<button class="btn btn-primary btn-sm" onclick="location.href='${userUrl}'">Details</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 		<script type="text/javascript">
			jQuery(document).ready(function($) {
			    $(".clickable-row").click(function() {
			        window.location = $(this).data("href");
			    });
			});
		</script> -->
	<script type="text/javascript" src="${bootstrapjs}"></script>
</body>
</html>
