<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Photos</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="Keywords" content="MyBatis Spring Test" />
<meta name="Description" content="This is web app for mybatis-spring Test" />
<style>
html, body {
	margin: 0;
	padding: 0;
	background-color: #FFF;
	font-family: "Liberation Sans", Helvetica, sans-serif;
}
#paging {
	width: 640px;
	float: left;
	font-size: 1em;
}
a:link {
	color: #2C80D0;
	text-decoration: none;
}
a:visited {
	color: #2C80D0;
	text-decoration: none;
}
a:active {
	color: #2C80D0;
	text-decoration: none;
}
a:hover {
	color: #2C80D0;
	text-decoration: underline;
}
</style>
<script src="../resources/js/jquery-3.6.1.min.js"></script>
<script>
$(document).ready(function() {
	$("#addForm").submit(function (event) {
		event.preventDefault();
		var $form = $(this);
		var content = $('#addForm-tf').val();
		content = $.trim(content);
		if (content.length === 0) {
			$('#addForm-tf').val('');
			return false;
		}
		var dataToBeSent = $form.serialize();
		var url = $form.attr("action");
		var posting = $.post(url, dataToBeSent);
		posting.done(function () {
			$('#addForm-tf').val('');
		});
	}); 
	$('#photos a').click(function (event) {
		event.preventDefault();
		var no = this.title;
		var chk = confirm("Are you sure to delete the " + no + " photo?");
		if (chk) {
			var action = $('#delForm').attr('action');
			action += no;
			$('#delForm').attr('action', action);
			$('#delForm').submit();
		}
	});
});
</script>
</head>
<body>
	<div id="photos">
		<c:forEach var="photo" items="${photos }" varStatus="status">
		<a href="#" title="${photo.no }"><img width="640" alt="p_${photo.no }" src="${photo.content }" /></a>
		</c:forEach>
	</div>

	<div id="paging">
		<c:if test="${param.page > 1 }">
		<a href="?page=${param.page - 1 }" title="${param.page - 1 }">◁ back</a>
		</c:if>

		<c:if test="${prevBlock > 0 }">
		<a href="?page=1" title="1">1</a>
		<a href="?page=${prevBlock }" title="${prevBlock }">...</a>
		</c:if>

		<c:forEach var="i" begin="${firstPage }" end="${lastPage }" varStatus="status">
		<c:choose>
			<c:when test="${param.page == i }">
			<strong>${i }</strong>
			</c:when>
			<c:otherwise>
			<a href="?page=${i }" title="${i }">${i }</a>
			</c:otherwise>
		</c:choose>
		</c:forEach>

		<c:if test="${nextBlock > 0 }">		
		<a href="?page=${nextBlock }" title="${nextBlock }">...</a>
		<a href="?page=${finalPage }" title="${finalPage }">${finalPage }</a>
		</c:if>

		<c:if test="${param.page < finalPage }">
		<a href="?page=${param.page + 1 }" title="${param.page + 1 }">next▷ </a>
		</c:if>

		<form id="addForm">
			<input type="text" id="addForm-tf" name="content" style="width: 500px;" />
			<input id="submit" type="submit" value="Send" />
			<a href="../">Home</a>
		</form>
	</div>
	<div style="display:none">
		<form id="delForm" action="../photo/" method="post">
			<input type="hidden" name="page" value="${param.page }" />
			<input type="hidden" name = "_method" value = "delete"/>
		</form>
	</div>
</body>
</html>
