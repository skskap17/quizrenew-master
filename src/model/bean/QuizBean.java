package model.bean;

public class QuizBean {

	private int quiz_id;		//クイズid
	private String quiz;		//問題文
	private String answer;		//答え
	private String choices1;	//選択肢1
	private String choices2;	//選択肢2
	private String choices3;	//選択肢3
	private int user_id;		//クイズを登録したユーザー

	/*
	 各フィールドのセッターゲッター
	 */

	public int getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}
	public String getQuiz() {
		return quiz;
	}
	public String getAnswer() {
		return answer;
	}
	public String getChoices1() {
		return choices1;
	}
	public String getChoices2() {
		return choices2;
	}
	public String getChoices3() {
		return choices3;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public void setChoices1(String choices1) {
		this.choices1 = choices1;
	}
	public void setChoices2(String choices2) {
		this.choices2 = choices2;
	}
	public void setChoices3(String choices3) {
		this.choices3 = choices3;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


}
