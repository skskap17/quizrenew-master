package model;

import java.util.ArrayList;
import java.util.Collections;

import model.bean.QuizBean;
import model.bean.UserBean;
import model.dao.DAOException;
import model.dao.QuizDAO;



public class SelectQuizLogic {

	public ArrayList<QuizBean> execute(UserBean user) throws DAOException{


		QuizDAO dao = new QuizDAO();

		ArrayList<QuizBean> quizList = dao.selectByAll(); //クイズリストにすべてのクイズを格納
		ArrayList<QuizBean> selectList = new ArrayList<QuizBean>();//ランダムにしたクイズを格納するリスト

		Collections.shuffle(quizList);//クイズリストの順番をシャッフル

		int i = 0; //ループ用の添え字
		int j = 0; //ループ用の添え字

		while (i < 20){ //自分で登録したクイズが出ないようにチェック

			if (user.getId() != quizList.get(j).getUser_id()){//ユーザーのuser_idとクイズのuser_idが一致しない場合

				QuizBean result = quizList.get(j);
				selectList.add(result);//シャッフルした結果を格納

				i++;
			}
			j++;
		}

		return selectList;//シャッフルした結果をリターン


	}
}
