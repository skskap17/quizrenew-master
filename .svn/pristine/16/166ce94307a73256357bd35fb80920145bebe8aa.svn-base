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

import model.KakomonLogic;
import model.bean.QuizBean;
import model.bean.UserBean;

/**
 * Servlet implementation class KakomonSV
 */
@WebServlet("/KakomonSV")
public class KakomonSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public KakomonSV() {
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
		// TODO Auto-generated method stub
		System.out.println("KakomonSVのdoPostきたよ");
		request.setCharacterEncoding("UTF-8");

		//過去問を取ってくるSV

		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("log");

		//過去問ロジックへ
		KakomonLogic kako = new KakomonLogic();


		//受け取り用過去問リスト（kakomonList）
		ArrayList<QuizBean> kakomonList = new ArrayList<QuizBean>();
		kakomonList = kako.Kakomon(user);

		//sessionに過去に作成した問題をセット
		HttpSession sesesion = request.getSession();
		session.setAttribute("kakomonList", kakomonList);


		RequestDispatcher dispatcher = request.getRequestDispatcher("QuizKako.jsp");
		dispatcher.forward(request,response);

	}

}
