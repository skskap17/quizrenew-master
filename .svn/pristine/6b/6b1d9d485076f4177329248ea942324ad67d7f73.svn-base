package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SelectQuizLogic;
import model.bean.QuizBean;
import model.bean.UserBean;
import model.dao.DAOException;


/**
 * Servlet implementation class DoQuizSV
 */
@WebServlet("/DoQuizSV")
public class DoQuizSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoQuizSV() {
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
		System.out.println("DoQuizSVにdoPostきたよ");

		//クイズを取ってくるSV

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		//SelectQuizLogicでクイズ20問を選んできてもらうためインスタンス化。
		SelectQuizLogic selectQuiz = new SelectQuizLogic();

		//表示するクイズを入れるリスト生成
		ArrayList<QuizBean> doquizList = new ArrayList<QuizBean>();

		HttpSession session = request.getSession();
		UserBean user = (UserBean)session.getAttribute("log");

		try {
			//ランダムなクイズ20問を取得
			doquizList = selectQuiz.execute(user);
		} catch (DAOException e) {
			e.printStackTrace();
		}

		//とってきたクイズをセッション領域へ
		session.setAttribute("doquizList",doquizList);


		//Quiz画面へ
		RequestDispatcher rd = request.getRequestDispatcher("Quiz.jsp");
		rd.forward(request, response);



	}

}
