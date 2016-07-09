package model.bean;


public class UserBean {

	private int id; 		//ユーザーid
	private String name;	//ログイン用ユーザー名
	private String pass;	//ログイン用パスワード
	private int score;		//クイズの得点


	/*
	 各フィールドのセッターゲッター
	 */
	public int getId() {
		return id;
	}
	public int getScore() {
		return score;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPass(String pass){
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}

}
