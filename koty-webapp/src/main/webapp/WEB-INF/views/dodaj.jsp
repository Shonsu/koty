<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<spring:url value="/resources/bootstrap/js/bootstrap.min.js" var="bootstrapjs" />
	<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapcss" />

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="${bootstrapcss}" rel="stylesheet" type="text/css" > 


<title>Insert title here</title>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-md-4">
		<a href="wypisz">Powrót do listy kotów</a><br/>
		<a href="dodaj">Dodaj</a><br/>
		<a href="szczegoly">Szczegóły</a><br/>
    </div>
    <div class="col-md-8">
      	<h4>Podaj Dane kota:</h4>

		<form>
			<div class="form-group">
				<label class="form-control-label" for="imie">Imię kota:</label> <input
					type="text" class="form-control" id="imie" placeholder="Tofik">
			</div>
			<div class="form-group">
				<label class="form-control-label" for="data_urodzenia">Data urodzenia:</label> <input
					type="text" class="form-control" id="data_urodzenia" placeholder="Tofik">
			</div>
			<div class="form-group">
				<label class="form-control-label" for="waga">Waga:</label> <input
					type="text" class="form-control" id="waga" placeholder="Tofik">
			</div>
			<div class="form-group">
				<label class="form-control-label" for="opiekun">Imię opiekuna:</label> <input
					type="text" class="form-control" id="opiekun"
					placeholder="Tofik">
			</div>
			<button type="submit" class="btn btn-primary">Wyślij</button>
		</form>
    </div>
  </div>
</div>

	<script type="text/javascript" src="${bootstrapjs}"></script> 
</body>
</html>