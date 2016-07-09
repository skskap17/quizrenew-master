<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="model.bean.QuizBean"%>
<%@ page import ="java.util.ArrayList" %>
<!DOCTYPE html >
<html>
<head>

<%
	ArrayList<QuizBean> qList =  (ArrayList) session.getAttribute("doquizList");
%>
	<link rel = "stylesheet"href="submit.css"type="text/css">
<style>


.gazou img {

   width: 512px;
  height: 209px;
  margin-top:30px;

}

.body{

position:relative;

}


.nekoyana{

	width:0px;
	height:0px;

	position:relative;
	left:740px;
	top:120px;
	margin-bottom: 0px;


}


/* アコーディオン開始 */

label {
    padding :20px 20px 20px 20px;
    display: block;
    margin: 0;
    color :#fff;
    font-weight:bold;
    background :#6699FF;
    border: 1px solid #ccc;
    border-top-left-radius: 20px;
    -webkit-border-top-left-radius: 10px;
    -moz-border-radius-topleft: 10px;
    border-top-right-radius: 10px;
    -webkit-border-top-right-radius: 10px;
    -moz-border-radius-topright: 10px;
    cursor :pointer;
    width:500px;
    margin:0 auto;
}

input[type="checkbox"].bellows{
    display: none;/* チェックボックスの非表示 */
}

.ac_menu ul {
/* メニュー開閉時アニメーション */
    background :#f4f4f4;
    -webkit-transition: all 0.5s;
    -moz-transition: all 0.5s;
    -ms-transition: all 0.5s;
    -o-transition: all 0.5s;
    transition: all 0.5s;
    margin: 0;
    padding: 0;
    list-style: none;
}

.ac_menu li {
    padding: 5px;
}

/* ▽▽アコーディオン開閉指定▽▽ */
input[type="checkbox"].bellows + ul{
    height: 0;/* チェックが入っていない時の高さ */
    overflow: auto;
}

input[type="checkbox"].bellows:checked + ul{
    height: 800px;/* チェックが入っているときの高さ */
}
/* △△アコーディオン開閉指定△△ */



.kotae li{
margin-top:10px;
margin-bottom:20px;


}

.totop{

margin-top:30px;


}

.thequiz{

font-weight:bold;

}

.ac_menu{

width:850px;
margin:0 auto;

}



</style>





<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>点数発表画面</title>
</head>
<body>

<div class="nekoyana">

<img src="nekoyana (1).png" alt="" height="300">

</div>



<div class="gazou">

  <img src="kazumasa2.jpg" alt="ねこやなぎ" >
</div>
		<div id="form">
    <p class="form-title">★クイズ結果発表★</p>
    <h1>あなたの結果は<%=request.getAttribute("tokuten") %>点です</h1><br>
    	<h5>おつかれさまでした。</h5></div>





<div class="ac_menu">
<label for="nav01">解答結果</label>
    <input type="checkbox" id="nav01" class="bellows"/>



<ul class="kotae">
<%
for(int i = 0; i < 20; i++){
%>


<li class ="thequiz">Q<%=i+1%> <%= qList.get(i).getQuiz() %>
<%
if(request.getParameter("ans" + i).equals(qList.get(i).getAnswer())){
%>
○
<%
} else {
%>
×
<%
}
%>

</li>
<li>あなたの解答:<%=request.getParameter("ans" + i)%></li>
<li>問題の答え　:<%=qList.get(i).getAnswer()%></li>



<%
}
%>
</ul>
</div>

<%-- 	<p class="submit"><input type="submit" value="ランキングへ">--%>
<p class="submit totop"><a href = "Top.jsp"><input type = "submit" value = "Top画面へ"></a></p>









</body>
</html>