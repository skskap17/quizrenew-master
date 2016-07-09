package model;

import model.bean.QuizBean;
import model.bean.UserBean;
import model.dao.DAOException;
import model.dao.QuizDAO;

public class QuizInsertLogic {

	public boolean execute(QuizBean quizB , UserBean ub) throws DAOException{

		//クイズの追加
		QuizDAO qd = new QuizDAO();
		boolean result = qd.insertQuiz(quizB , ub);

		return result;


	}

}
