package model;

import java.util.ArrayList;

import model.bean.QuizBean;
import model.bean.UserBean;
import model.dao.DAOException;
import model.dao.QuizDAO;

public class KakomonLogic {



	public ArrayList<QuizBean> Kakomon(UserBean user){
		QuizDAO qdao = new QuizDAO();

		//過去問用リストを作成（まだ空）
		ArrayList<QuizBean> quizList = new ArrayList<QuizBean>();


		try {
			//QuizDAOから過去問リストをもらってきて入れる
			quizList = qdao.userSelect(user);
		} catch (DAOException e) {
			e.printStackTrace();
		}

		return quizList;
	}



}
