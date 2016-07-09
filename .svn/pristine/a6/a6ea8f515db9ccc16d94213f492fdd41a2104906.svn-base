package model;

import model.bean.UserBean;
import model.dao.DAOException;
import model.dao.UserDAO;


public class LoginLogic {

	public UserBean execute(UserBean user) throws DAOException{

		UserBean bean = new UserBean();

		UserDAO dao = new UserDAO();

		//データベースからユーザー情報を取得
		bean = dao.selectByUser(user);//UserBeanを渡して検索

		if(bean==null){//検索したユーザーが存在するか判定
		return null;
		} else if((user.getPass()).equals(bean.getPass())){
				return bean;
		} else {
			return null;
		}

	}
}
