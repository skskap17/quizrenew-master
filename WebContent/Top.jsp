<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "model.bean.UserBean" %>


    <%UserBean user = (UserBean)session.getAttribute("log");
    int score = user.getScore();%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>TOP画面</title>
</head>
<body>

       <div class="tidayo">

		<h3 class="tititi"> キャスレークイズゲーム</h3>
		</div>



		<form action="TopSV" method = "post">

		<p class="submit "><input type="submit" value="クイズ" name="ACTION"><br>

		<%
		if (10 <= score){
		%>

		<p class="submit"><input type="submit" value="クイズ登録"name="ACTION"><br>

		<div class="idou">
		<%
		} else {
		%>
		<p class="gava">10点以上のスコアを取れば<br>クイズを登録できます</p>
		<p class="besub"><input type="button" value=""name="ACTION"><br>

		<%
		}
		%>

		<p class="submit"><input type="submit" value="ランキング"name="ACTION"><br>
		<p class="submit"><input type="submit" value="パスワード変更"name="ACTION"><br>
		<p class="submit"><input type="submit" value="ログアウト"name="ACTION"><br>
		</div>
		</form>

		<style>

.tidayo{

height:250px;
margin-top:-50px;
.idou{



}



text-align: center;
padding:10px 10px 10px 10px;

}







.tititi{

      color: #fff;
      text-shadow: 0 0 20px ;
      font-size:70px;
      padding:30px 0px 30px 0px;



      text-shadow: 0 0 1px #fff,
      0 0 20px #5F9EA0,
      0 0 30px #5F9EA0,
      0 0 40px #5F9EA0,
      0 0 70px #5F9EA0,
      0 0 80px #5F9EA0,
      0 0 100px #5F9EA0;

｝






}



		body,p,form,input{margin: 0}
#form{
  width: 400px;
  margin: 30px auto;
  padding: 20px;
  border: 1px solid #555;
  z-index:1000;
  }

form p{
    font-size: 14px;
    }

.form-title{
  text-align: center;
  }

.mail,.pass{
  margin-bottom: 20px;
  }

input[type="userid"],
input[type="password"] {
  width: 300px;
  padding: 4px;
  font-size: 14px;
  }

submit{
  text-align: right;
  }

/* font */
#form p{
  color: #077685;
  font-weight: bold;
  }

#form .form-title{
  font-family: Arial;
  font-size: 30px;
  color: #4eb4c2;
  }

/* skin */
#form{
  -webkit-border-radius: 6px;
  -moz-border-radius: 6px;
  border-radius: 6px;
  -webkit-box-shadow: 0px 1px 10px #488a9e;
  -moz-box-shadow: 0px 1px 10px #488a9e;
  box-shadow: 0px 1px 10px #488a9e;
  border: solid #4eb4c2 1px;
  background: #fafafa;
  }

#form .form-title{
  padding-bottom: 6px;
  border-bottom: 2px solid #4eb4c2;
  margin-bottom: 20px;
  }

.submit input{
  font-family: Arial;
  color: #ffffff;
  font-size: 25px;
  padding-top: 20px;
  padding-right: 30px;
  padding-bottom: 30px;
  padding-left: 30px;
  text-decoration: none;
  -webkit-border-radius: 30px;
  -moz-border-radius: 30px;
  border-radius: 10px;
 /*  -webkit-box-shadow: 0px 8px 6px #e3e3e3;
  -moz-box-shadow: 0px 8px 6px #e3e3e3;
  box-shadow: 0px 3px 2px #e3e3e3; */
/*   border: solid #f5fdff 1px; */
  background: -webkit-gradient(linear, 0 0, 0 100%, from(#6699FF), to(#6699FF));
  background: -moz-linear-gradient(top, #61c7e0, #418da8);
  width:210px;
  height:20p;
  text-align:center;
  margin-bottom:3px;

  }
.submit input:hover{
  background: #00CCFF;
 }
body {
  text-align: center;
  background:#FFF;
  position:relative;

}


/* ボタンタグデザイン */

.subbot{

font-family: Arial;
  color: #ffffff;
  font-size: 25px;
  padding-top: 20px;
  padding-right: 30px;
  padding-bottom: 30px;
  padding-left: 30px;
  text-decoration: none;
  -webkit-border-radius: 30px;
  -moz-border-radius: 30px;
  border-radius: 10px;
 /*  -webkit-box-shadow: 0px 8px 6px #e3e3e3;
  -moz-box-shadow: 0px 8px 6px #e3e3e3;
  box-shadow: 0px 3px 2px #e3e3e3; */
/*   border: solid #f5fdff 1px; */
  background: -webkit-gradient(linear, 0 0, 0 100%, from(#6699FF), to(#6699FF));
  background: -moz-linear-gradient(top, #61c7e0, #418da8);
  width:210px;
  height:20p;
  text-align:center;
  margin-bottom:3px;
  text-align:center;
  margin:0 auto;
  font-size:20px;
  font-weight:bold;
  margin-bottom:3px;


}


*, *:before, *:after{
  box-sizing:border-box;
}


body{
  font-family: 'Lato', sans-serif;
  background:url("cyas.png");


}

.topimg{

text-align:center;
z-index:-1;

margin:0 auto;

}

a {
text-decoration: none;

}
a:link { color : #fff; }
a:visited { color : #fff; }

.besub{

bacground:#fff;

}

.besub input{

 font-family: Arial;
  color: #ffffff;
  font-size: 25px;
  padding-top: 20px;
  padding-right: 30px;
  padding-bottom: 30px;
  padding-left: 30px;
  text-decoration: none;
  -webkit-border-radius: 30px;
  -moz-border-radius: 30px;
  border-radius: 10px;
 /*  -webkit-box-shadow: 0px 8px 6px #e3e3e3;
  -moz-box-shadow: 0px 8px 6px #e3e3e3;
  box-shadow: 0px 3px 2px #e3e3e3; */
/*   border: solid #f5fdff 1px; */
  background: -webkit-gradient(linear, 0 0, 0 100%, from(#C3C3C3), to(#C3C3C3));
  background: -moz-linear-gradient(top, #61c7e0, #418da8);
  width:210px;
  height:20p;
  text-align:center;
  margin-bottom:3px;


}

.gava{

position:relative;
top:55px;
font-weight:bold;
color:#383838;
line-height:16px;
visibility:visible;
margin-top:-32px;

}

</style>
</body>
</html>