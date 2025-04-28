<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>English Word Cards</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="Keywords" content="Spring MVC Test" />
<meta name="Description" content="This is web app for Spring MVC Test" />
<link href="./resources/css/styles.css" rel="stylesheet" />
</head>
<body>

<div id="wordcard">
<h1>${wordCard.word }</h1>
<p>
${wordCard.definitions }
</p>
</div>

<form id="new-form" method="post">
	<input type="text" name="word" />
	<input type="text" name="definitions" />
	<input type="submit" value="Add" style="color: grey;" />
<!-- 	<a href="photo">Photo</a> -->
</form>

</body>
</html>
