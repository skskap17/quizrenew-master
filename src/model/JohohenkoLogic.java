package model;

import model.bean.UserBean;
import model.dao.DAOException;
import model.dao.UserDAO;

public class JohohenkoLogic {

	public boolean updateUser(UserBean user) {
		boolean result;
		int count = 0;	//アップデートが成功したかどうか確認する変数

		UserDAO userDAO = new UserDAO();
		try {
			count = userDAO.updateUser(user);	//UserBeanを渡してアップデート
		} catch (DAOException e) {
			e.printStackTrace();
		}

		if (count == 0) {//アップデートの成功判定
			result = false;
		} else {
			result = true;
		}
		return result;

	}

}
