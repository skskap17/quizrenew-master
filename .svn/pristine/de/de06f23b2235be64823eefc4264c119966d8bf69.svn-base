package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.QuizResultLogic;
import model.bean.QuizBean;
import model.bean.UserBean;

/**
 * Servlet implementation class QuizRsultSV
 */
@WebServlet("/QuizResultSV")
public class QuizResultSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizResultSV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		System.out.println("doPostきたよ");

		//クイズの結果出すSV

		//送られてきた回答入れる用のリスト作る（空っぽ）
		List<String> ansList = new ArrayList<String>();

		//回答情報を受け取る。

		for (int i = 0; i < 20; i++) {

			ansList.add(request.getParameter("ans" + i));

		}

		//問題のリスト(空)
		List<QuizBean> quizList = new ArrayList<QuizBean>();

		HttpSession session = request.getSession();
		quizList  = (List<QuizBean>) session.getAttribute("doquizList");


		//セッション領域にあるUserBeanのリスト
		UserBean user =  (UserBean)session.getAttribute("log");

		QuizResultLogic quizresult = new QuizResultLogic();
		int tokuten = quizresult.result(quizList,ansList,user);

		request.setAttribute("tokuten",tokuten);

		RequestDispatcher dispatcher = request.getRequestDispatcher("Quizkeltuka.jsp");
		dispatcher.forward(request,response);

	}

}
