package model;

import java.util.List;

import model.bean.UserBean;
import model.dao.DAOException;
import model.dao.UserDAO;

public class RankingLogic {

	public List<UserBean> getRanking(){

		UserDAO userDAO = new UserDAO();

		List<UserBean> ranking=null; //ユーザーのランキングを入れるリスト
		try {
			ranking = userDAO.rankingUser();//ランキングを持ってくる
		} catch (DAOException e) {
			e.printStackTrace();
		}
	return ranking;//ランキングのリストをリターン
	}
}