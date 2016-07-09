<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>

		<link rel = "stylesheet"href="submit.css"type="text/css">
		<link rel = "stylesheet"href="hidden.css"type="text/css">

<meta charset="UTF-8">
<title>登録確認画面</title>
</head>

<style>
.kokodake{

margin-top:20px;

}

.hidden{

line-height:1.8em;
font-size:20px;
font-weight:bold;


}

</style>

<body>

		<div id="form">
    	<p class="form-title">お間違いないですか?<br>
    	問題なければ完了ボタンをお願いします</p>    </div>







<form action="InsertSV" method="post">

    	<input type="hidden" value="<%=request.getParameter("name")%>" name = "name">
		<input type="hidden" value="<%=request.getParameter("pass")%>" name = "pass">
<center>
<h2>

<p class="hidden">ユーザ名:<%=request.getParameter("name") %>

<p class="hidden">
パスワード:<%=request.getParameter("pass") %>

		<p class="submit kokodake"><input type="submit" value="確認完了">



</h2>
</center>
</form>
<p class="submit"><a href="SinkiTouroku.jsp"><input type="submit" value="1つ前に戻る"></a>




</body>
</html>