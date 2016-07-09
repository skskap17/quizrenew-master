package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.QuizBean;
import model.dao.DAOException;
import model.dao.QuizDAO;

/**
 * Servlet implementation class QuizKosinSV
 */
@WebServlet("/QuizKosinSV")
public class QuizKosinSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizKosinSV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//クイズを変更するSV

		//リクエストから値を取得
		String mondai = request.getParameter("first");
		String ans = request.getParameter("ans");
		String ch1 = request.getParameter("ch1");
		String ch2 = request.getParameter("ch2");
		String ch3 = request.getParameter("ch3");
		String quizid = request.getParameter("quizid");
		int id = Integer.parseInt(quizid);


		String url = null; //遷移先を指定する変数

		//ビーンに値をセット
		QuizBean qb = new QuizBean();
		qb.setQuiz(mondai);
		qb.setAnswer(ans);
		qb.setChoices1(ch1);
		qb.setChoices2(ch2);
		qb.setChoices3(ch3);
		qb.setQuiz_id(id);

		QuizDAO dao = new QuizDAO();
		boolean ok = false;
		try {//アップデート

			ok = dao.quizUpdate(qb);

		} catch (DAOException e) {
			e.printStackTrace();
		}

		if(ok) {//結果で遷移先を決定
			url = "KosinKanryo.jsp";
		} else {
			url = "KosinShippai.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);


	}

}
