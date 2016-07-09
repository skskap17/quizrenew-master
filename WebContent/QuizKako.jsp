 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ page import = "controller.KakomonSV" %>
 <%@ page import = "model.bean.QuizBean" %>
 <%@ page import = "java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"href="submit100.css"type="text/css">
	<style>



	body {

  background-image:url(time.png);
  text-align: center;

}

.quiztable{

	 width:60%;
    height:100%;
    background:#FFF;
    margin:40px auto;
    border:solid 1px #4169E1;


}



input[type="submit"] {
	background: #6666FF;
	width: 50%;
	padding: 9px;
	letter-spacing: 1px;
	border: none;
	color: #EFDDA8;
	border-radius: 3px;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	/* font-weight:bold; */
	margin-top:20px;
	margin-bottom:20px;
	width:150px;
}





	</style>

<meta charset="UTF-8">
<title>過去問題画面</title>
</head>
<body>

<% ArrayList<QuizBean> kakoList = new ArrayList<QuizBean>();

	kakoList = (ArrayList<QuizBean>) session.getAttribute("kakomonList");

%>

	<div id="form">

    <p class="form-title">過去に作成した問題</p>

    <h5>問題文や選択肢を変更したい場合は変更ボタン<br>問題を削除したい場合は削除ボタンを押してください</h5></div>



<%
	for(int i = 0; i < kakoList.size(); i++){
%>
  <div class="quiztable innner">
		<h4> Q <%=i+1 %> <%= kakoList.get(i).getQuiz() %></h4>

    	<p class="innner">

		答え：<%= kakoList.get(i).getAnswer() %>
		選択肢1：<%= kakoList.get(i).getChoices1()%>
		選択肢2：<%= kakoList.get(i).getChoices2() %>
		選択肢3：<%= kakoList.get(i).getChoices3() %>

		</p>

		<form action = "KakoHenkoSV" method= "post">

		<input type="submit" value="変更" name="ACTION" class="btn innner"/>

		<input type="submit" value="削除" name="ACTION" onclick='return confirm("削除してもよろしいですか？");' class="btn innner"/>

		<input type="hidden" value="<%=i%>" name="number">

		</form>
</div>

<%
	}
%>



<br>


<form action = "QuizTouroku.jsp">
		<p class="submit"><input type="submit" value="クイズ登録画面へ"></p>
</form>
<form action = "Top.jsp">
		<p class="submit"><input type="submit" value="TOP画面へ"></p>
</form>


</body>
</html>