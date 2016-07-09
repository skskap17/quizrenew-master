<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html >
<html>
<head>

		<link rel = "stylesheet"href="submit.css"type="text/css">

<meta charset="UTF-8">
<title>クイズ登録確認画面</title>
</head>
<body>

	<div id="form">

    <p class="form-title">このクイズで確定してよろしいてすか？</p>

    		<h4> Q 1 <%= request.getParameter("first") %></h4>

		答え：<%=  request.getParameter("ans")%>
		選択肢1：<%= request.getParameter("ch1")%>
		選択肢2：<%= request.getParameter("ch2") %>
		選択肢3：<%= request.getParameter("ch3")%>

    <h5>間違えがないようでしたら決定ボタンのクリックをおねがいいたします！</h5></div>

	<form action="quiz_new" method="post">
	<p class="submit"><input type="submit" value="このクイズで決定">


	<input type="hidden" value="<%=request.getParameter("first")%>" name = "first">
	<input type="hidden" value="<%=request.getParameter("ans")%>" name = "ans">
	<input type="hidden" value="<%=request.getParameter("ch1")%>" name = "ch1">
	<input type="hidden" value="<%=request.getParameter("ch2")%>" name = "ch2">
	<input type="hidden" value="<%=request.getParameter("ch3")%>" name = "ch3">


	</form>

<a href= "QuizTouroku.jsp"><p class="submit"><input type="submit" value="新規登録画面へ戻る"></a></p>

</body>
</html>