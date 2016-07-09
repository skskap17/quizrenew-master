<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>

		<link rel = "stylesheet"href="submit.css"type="text/css">

<meta charset="UTF-8">
<title>登録結果画面</title>
</head>
<body>

<center><h1><br><br><br>
<div class="lalala">
<p class="kanryo"><%=(String)request.getAttribute("msg") %>
</div>
</h1></center>
<a href="Login.jsp">

	<p class="submit"><input type="submit" value="Login画面へ">
</a>


<style>


.lalala{
width: 600px;
margin-bottom: 1em;
background: #336699;

color:#F8F8F8;

 /* サイズ指定 */
 width:300px;
 height:300px;
 /* 背景色 */
 background-color: #336699;
 /* 角を丸くする */
 border-radius: 50%;
 -webkit-border-radius: 50%;
 -moz-border-radius: 50%;

  filter:alpha(opacity=80);
    -moz-opacity: 0.5;
    opacity: 0.8;
}


.kanryo{
	padding-top:110px; /* 真ん中にまで文字を下ろす */
 text-align: center; /* 中央寄せ */
 margin: 0 auto; /* h1とpの余白をリセット

}


</style>
</body>
</html>