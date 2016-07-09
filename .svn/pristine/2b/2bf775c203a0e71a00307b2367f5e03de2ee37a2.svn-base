package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.bean.UserBean;

public class UserDAO {

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

/**
 * ログインユーザーを検索
 * @param user
 * @return ub
 * @throws DAOException
 */

	//■検索 (1件：引数の UserBean で検索する)
		public UserBean selectByUser(UserBean user) throws DAOException {

			// 検索結果となるUser の情報は、UserBean に格納し呼び出し元に返す

			UserBean ub = null;

			try {
				//データベース接続
				con =  getConnection();

				//SQL文作成
				String sql = "select * from user where name = ?";

				//prepareStatement作成
				pstmt = con.prepareStatement(sql);

				//?に内容をセット
				pstmt.setString(1, user.getName());

				//SLECT文を実行
				ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				ub = new UserBean();
				//結果表からデータを取得

				ub.setId(rs.getInt("user_id"));
				ub.setName(rs.getString("name"));
				ub.setPass(rs.getString("pass"));
				ub.setScore(rs.getInt("score"));

			}


			}catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("[conect]異常", e);
			}finally{
				close();

			}

			return ub; //見つかったUserBeanをリターン


		}

/**
 * ユーザーの新規登録を行う
 * @param user
 * @return count
 * @throws DAOException
 */


	public int insertUser(UserBean user) throws DAOException {

		int count = 0;//インサートが成功したか判定する変数
		try {
			//データベース接続
			con = getConnection();

			//SQL文を作成
			String sql = "Insert INTO user VALUES(0,?,?,0)" ;

			//prepareStatement作成
			pstmt = con.prepareStatement(sql);

			//?に内容をセット
			pstmt.setString(1,user.getName());
			pstmt.setString(2,user.getPass());

			//SQL文を実行
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return count;//INSERTが成功したかどうかをリターン
	}

/**
 * パスワードの変更を行う
 * @param user
 * @return count
 * @throws DAOException
 */
	public int updateUser(UserBean user) throws DAOException {

		int count  = 0;		//アップデートが成功したか判定する変数

		try {
			//データベース接続
			con = getConnection();

			//PrepareStatementを作成
			pstmt = con.prepareStatement("UPDATE user SET pass=? WHERE user_id =?");

			//?に内容をセット
			pstmt.setString(1,user.getPass());
			pstmt.setString(2,String.valueOf(user.getId()));

			//UPDATE文を実行
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			close();
		}
		return count;//UPDATEが成功したかどうかをリターン
	}
/**
 * 最高点数の更新
 * @param user
 * @return
 * @throws DAOException
 */
	public int updateScore(UserBean user) throws DAOException {

		int count  = 0; //アップデートが成功したか判定する変数

		try {
			//データベース接続
			con = getConnection();

			//PrepareStatementを作成
			pstmt = con.prepareStatement("UPDATE user SET score=? WHERE user_id = ?");

			//?に内容をセット
			pstmt.setString(1,String.valueOf(user.getScore()));
			pstmt.setString(2,String.valueOf(user.getId()));

			//UPDATE文を実行
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			close();
		}
		return count;//UPDATEが成功したかどうかをリターン
	}

	/**
	 * ランキングを返す
	 * @return
	 * @throws DAOException
	 */
	public List<UserBean> rankingUser() throws DAOException {


		System.out.println("UserDAO : rankingUser()を実行");

		// 検索結果となるUser の情報は、List<UserBean> に格納し呼び出し元に返す

		UserBean ub = null;
		List<UserBean> ranking = new ArrayList<UserBean>(); //ランキング情報を入れるリスト

		try {
			//データベース接続
			con =  getConnection();

			//SQL文作成
			String sql = "select * from user order by score desc";

			//prepareStatement作成
			pstmt = con.prepareStatement(sql);

			//SLECT文を実行
			ResultSet rs = pstmt.executeQuery();

		while(rs.next()) {
			ub = new UserBean();
			//結果表からデータを取得
			ub.setId(rs.getInt("user_id"));
			ub.setName(rs.getString("name"));
			ub.setPass(rs.getString("pass"));
			ub.setScore(rs.getInt("score"));

			ranking.add(ub);
		}


		}catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("[conect]異常", e);
		}finally{
			close();

		}

		return ranking; //ランキングのリストをリターン

	}

}
