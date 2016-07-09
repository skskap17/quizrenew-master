package model;

import java.util.List;

import model.bean.QuizBean;
import model.bean.UserBean;
import model.dao.DAOException;
import model.dao.UserDAO;

public class QuizResultLogic {

	public int result(List<QuizBean> quizList,List<String> ansList,UserBean user){
		int count = 0;


		for(int i = 0; i < 20; i++){//問題の答えとユーザーの解答を比較
			if(quizList.get(i).getAnswer().equals(ansList.get(i))){//解答が正しい場合
				count++;											//得点を加算
			}
		}

		if(count > user.getScore()){//Userの最高得点と今回の得点を比較し今回の得点が大きければ更新
			user.setScore(count);		//今回の得点をUserBeanにセット
			UserDAO userDAO = new UserDAO();
			try {
				userDAO.updateScore(user);//UserBeanを渡してアップデート
			} catch (DAOException e) {
				e.printStackTrace();
			}
		}

		return count;//得点をリターン
	}
}
