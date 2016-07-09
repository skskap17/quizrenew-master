package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.QuizInsertLogic;
import model.bean.QuizBean;
import model.bean.UserBean;
import model.dao.DAOException;

/**
 * Servlet implementation class quiz_new
 */
@WebServlet("/quiz_new")
public class quiz_new extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public quiz_new() {
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

		//クイズを新規登録するSV

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		//リクエストから値を取得

		String mondai = request.getParameter("first");
		String  ans = request.getParameter("ans");
		String  ch1 = request.getParameter("ch1");
		String  ch2 = request.getParameter("ch2");
		String  ch3 = request.getParameter("ch3");

		//ユーザーをセッション領域から取得
		HttpSession session = request.getSession();
		UserBean user = (UserBean)session.getAttribute("log");

		boolean result = false;

		String url = null;


		//ロジックのインスタンス化
		QuizInsertLogic ql = new QuizInsertLogic();
		QuizBean quizB = new  QuizBean();


		quizB.setQuiz(mondai);
		quizB.setAnswer(ans);
		quizB.setChoices1(ch1);
		quizB.setChoices2(ch2);
		quizB.setChoices3(ch3);




		try {

			//ロジック発動
			result = ql.execute(quizB , user);
			System.out.println("quiz_newのトライきました");

		} catch (DAOException e) {

			e.printStackTrace();
		}

		if (result) {
			url = "/QuizTourokuKanryo.jsp";

		} else {
			url = "/QuizTourokuShippai.jsp";
		}
		//クイズ確認へ移行
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(url);
		dispatcher.forward(request,response);


	}

}
