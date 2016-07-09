<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>

		<link rel = "stylesheet"href="submit.css"type="text/css">

<meta charset="UTF-8">
<title>クイズ新規登録画面</title>
<%--選択肢の被りを防ぐ --%>
  <script><!--
  // overlapInputTextValue.js
  if (typeof Array.prototype.some !== 'function') {
    Array.prototype.some = function(fun, thisp) {
      var i, len;
      if (typeof fun !== "function") throw new TypeError();
      for (i = 0, len = this.length; i < len; i++) {
        if (i in this && fun.call(thisp, this[i], i, this)) return true;
      }
      return false;
    };
  }
  function createOverlapInputTextValue (value, i) {
    return function (element, index) {
      return index !== i && element.tagName === 'INPUT' && element.type === 'text' && element.value === value;
    };
  }
  function checkForm (event) {
    var form, elements, i, l;
    form = event.target || event.srcElement;
    elements = form.elements;
    for (i = 0, l = elements.length; i < l; i++) {
      if (Array.prototype.some.call(elements, createOverlapInputTextValue(elements[i].value, i))) {
        alert('答えと選択肢はそれぞれ異なるものにしてください');
        event.preventDefault ? event.preventDefault() : event.returnValue = false;
        break;
      }
    }
  }
  //--></script>


<style>

.quizzone{


height: 150px;




}







.textbo{

	width: 50%;
	height:15px;
	margin-bottom:15px;

-webkit-box-shadow: 0px 1px rgba(255, 255, 255, 0.5);
-moz-box-shadow: 0px 1px rgba(255, 255, 255, 0.5);
box-shadow: 0px 1px rgba(255, 255, 255, 0.5);
-webkit-border-radius: 4px;
-moz-border-radius: 4px;
border-radius: 4px;

}

input:focus {
    border:solid 1px #EEA34A;
}

.body{

position:relative;

}


.quizdayo{

margin-bottom:10px;
color:000;



}

.area{

position:relative;
left:20px;


}

input.quiztex{
width:200px;
height:50px;
}

.quizsp{

height:60px;
color:#333;


}

.mondai{

color:#000;

}


</style>



</head>
<body>


	<div id="form">
    <p class="form-title">クイズの記入をお願いします</p>
    <h5>難しいクイズやユニークなクイズなど様々な登録おまちしています！</h5>

	<!-- <p class="mondai">問題文</p> -->
	<form action="QuizKakunin.jsp" method="post" onsubmit="checkForm(event)">

	<p>問題文</p><textarea class="textbo quizsp" name="first" cols="50" rows="1" maxlength="50" placeholder="問題を50文字で入力して下さい" wrap="hard"></textarea><br>
	<p>答え</p><input class="textbo"type="text" name="ans" placeholder="答えを20文字入力してください" value=""  maxlength='50' tabindex="1" required /><br>
	<p>選択肢1</p><input class="textbo"type="text" name="ch1" value="" placeholder="選択肢を20文字で入力してください"  maxlength='50' tabindex="2" required/><br>
	<p>選択肢2</p><input class="textbo"type="text" name="ch2" value="" placeholder="選択肢を20文字で入力してください" maxlength='50' tabindex="3" required/><br>
	<p>選択肢3</p><input class="textbo"type="text" name="ch3" value="" placeholder="選択肢を20文字で入力してください" maxlength='50' tabindex="4" required/><br>


	<p class="submit"><input type="submit" value="このクイズを追加する" >


	</form>
	<p class="submit"><a href="QuizTouroku.jsp"><input type="submit" value="クイズ登録画面へ"></a></p>

    </div>





</body>
</html>