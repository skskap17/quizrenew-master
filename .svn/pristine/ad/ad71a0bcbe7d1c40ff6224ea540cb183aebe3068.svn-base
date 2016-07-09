package model;

import model.bean.UserBean;
import model.dao.DAOException;
import model.dao.UserDAO;

public class InsertLogic {

	public boolean execute(UserBean bean) {

		UserDAO userDAO = new UserDAO();

		int count=0; 	//インサートが成功したかどうか判定する変数
		try {
			count = userDAO.insertUser(bean); //UserBeanを渡してインサート
		} catch (DAOException e) {
			e.printStackTrace();
		}

		if (count == 1) {//インサートの成功判定
			return true;
		} else {
			return false;
		}

	}

}
