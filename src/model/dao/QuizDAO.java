package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.bean.QuizBean;
import model.bean.UserBean;

public class QuizDAO {

	private Context ict  ;		//JNDI追加
	private DataSource ds  ;	//JNDI追加
	private Connection con  ;
	private PreparedStatement pstmt  ;	//プリペアオブジェクト生成SQLで統一

	/**
	 * ■■■■■■■■■■■■■■■■■■■■共通接続■■■■■■■■■■■■■■■■■■■■■■■■■
	 * @throws DAOException
	 * @throws NamingException
	 */
	private Connection getConnection() {

		if ( this.con != null ){
			return con;
		}

		try {

			// JDBC間接接続の取得
			ict = new InitialContext();

			// データソースを検索（アプリケーションサーバ定義）
			ds = (DataSource) ict.lookup("java:comp/env/MySQL_JDBC");

			// 接続
			con =  ds.getConnection();


		// SQLに関する例外処理
		}catch(NamingException e1){

			e1.printStackTrace();

		} catch (SQLException e2) {

			e2.printStackTrace();

		}

		return con;
	}





	/**
	 * ■■■■■■■■■■■■■■■■共通クローズ■■■■■■■■■■■■■■■■■■■■■■■
	 * @throws DAOException
	 */
	private void close() throws DAOException{

		//SQL生成オブジェクトクローズ（ResultSetはココで自動クローズ）
		if (this.pstmt != null) {
			try {
				this.pstmt.close();
			} catch (SQLException e) {
				throw new DAOException("PreparedStatentの[close]異常", e);
			}
		}
		this.pstmt = null;

		//接続クローズ
		if (con != null){
			try {
				this.con.close();


			} catch (SQLException e) {
				throw new DAOException("Connectionの[close]異常", e);
			}
		}
		this.con = null;
	}


	//selectByAllで全件検索

		public  ArrayList<QuizBean> selectByAll() throws DAOException {

			System.out.println("QuizDAO : selectbyAll()を実行");

			// 検索結果となるEmployee の情報は、EmployeeBean に格納し呼び出し元に返す
			ArrayList<QuizBean> quizList = null;

			try {
				//接続
				con =  getConnection();

				//取得
				String sql = "SELECT * FROM quiz";
				pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();

				quizList = new ArrayList<QuizBean>();

				//４:（操作）
				while(rs.next()){
					QuizBean quizB = new QuizBean();

					quizB.setQuiz_id(rs.getInt("quiz_id"));
					quizB.setQuiz(rs.getString("quiz"));
					quizB.setAnswer(rs.getString("answer"));
					quizB.setChoices1(rs.getString("choices1"));
					quizB.setChoices2(rs.getString("choices2"));
					quizB.setChoices3(rs.getString("choices3"));
					quizB.setUser_id(rs.getInt("user_id"));

					quizList.add(quizB);


				}} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("[conect]異常", e);
			}finally{

				close();
			}



			return quizList;
		}

		//

		public boolean insertQuiz(QuizBean quizB , UserBean ub) throws DAOException {

			//QuizBean beanQ = new QuizBean();

			int count = 0;

			try {

				//INSERTのSQL文を作成
				con = getConnection();

				String sql = "Insert INTO quiz VALUES(0,?,?,?,?,?,?)" ;

				//prepareStatement作成
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1,quizB.getQuiz());
				pstmt.setString(2,quizB.getAnswer());
				pstmt.setString(3,quizB.getChoices1());
				pstmt.setString(4,quizB.getChoices2());
				pstmt.setString(5,quizB.getChoices3());
				pstmt.setInt(6,ub.getId());

				count = pstmt.executeUpdate();

				if (count != 1) {
					return false;
				}

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

			return true;
		}


		//userSelect
		public  ArrayList<QuizBean> userSelect(UserBean user) throws DAOException {

			System.out.println("QuizDAO : userSelect()を実行");

			// クイズリストを作成。
			ArrayList<QuizBean> quizList = null;

			try {

				//接続

				con =  getConnection();

				//ユーザーIDを用いて検索する、SQL文を作成

				String sql = "SELECT * FROM quiz WHERE user_id = ?";
				pstmt = con.prepareStatement(sql);

				//ユーザーIDを用いて検索実行
				pstmt.setInt(1,user.getId());
				ResultSet rs = pstmt.executeQuery();



				//クイズリストをnewします。
				quizList = new ArrayList<QuizBean>();

				//QuizBeanにユーザーが作成したクイズを格納
				while(rs.next()){

					QuizBean quizB = new QuizBean();
					quizB.setQuiz_id(rs.getInt("quiz_id"));
					quizB.setQuiz(rs.getString("quiz"));
					quizB.setAnswer(rs.getString("answer"));
					quizB.setChoices1(rs.getString("choices1"));
					quizB.setChoices2(rs.getString("choices2"));
					quizB.setChoices3(rs.getString("choices3"));
					quizB.setUser_id(rs.getInt("user_id"));

					quizList.add(quizB);


				}} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("[conect]異常", e);
			}finally{

				close();
			}



			return quizList;
		}


		//問題を削除する
		public  boolean quizDelete(QuizBean qb) throws DAOException {

			System.out.println("QuizDAO : quizDelete()を実行");

			// クイズリストを作成。

			try {

				//接続

				con =  getConnection();

				//ユーザーIDを用いて検索する、SQL文を作成

				String sql = "DELETE FROM quiz WHERE quiz_id = ?";
				pstmt = con.prepareStatement(sql);


				//ユーザーIDを用いて削除を実行
				pstmt.setInt(1,qb.getQuiz_id());
				pstmt.executeUpdate();



				} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("[conect]異常", e);
			}finally{

				close();
			}



			return true;
		}

		//削除系
		public  boolean quizUpdate(QuizBean beanq) throws DAOException {

			System.out.println("QuizDAO : quizUpdate()を実行");

			// クイズリストを作成。



			try {

				//接続

				con =  getConnection();

				//ユーザーIDを用いて特定後、更新する、SQL文を作成

				String sql = "UPDATE quiz SET quiz = ?,answer = ?,choices1 = ?,choices2 = ?,choices3 = ? WHERE quiz_id = ?";
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1,beanq.getQuiz());
				pstmt.setString(2,beanq.getAnswer());
				pstmt.setString(3,beanq.getChoices1());
				pstmt.setString(4,beanq.getChoices2());
				pstmt.setString(5,beanq.getChoices3());
				pstmt.setInt(6,beanq.getQuiz_id());
				pstmt.executeUpdate();







				} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}finally{

				close();
			}



			return true;
		}






}
