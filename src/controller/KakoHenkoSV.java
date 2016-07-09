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

import model.bean.QuizBean;
import model.dao.DAOException;
import model.dao.QuizDAO;

/**
 * Servlet implementation class KakoHenkoSV
 */
@WebServlet("/KakoHenkoSV")
public class KakoHenkoSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public KakoHenkoSV() {
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

		//過去問の変更削除を行うSV

		String henko = request.getParameter("ACTION");
		String number = request.getParameter("number");

		int num = Integer.parseInt(number);
		String url = null;

		HttpSession session = request.getSession();

		ArrayList<QuizBean> kakoList = new ArrayList<QuizBean>();
		kakoList = (ArrayList<QuizBean>) session.getAttribute("kakomonList");

		QuizBean delet =null;
		delet = kakoList.get(num);


		if(henko.equals("変更")) {//フォームから送られてきたACTIONが変更

			url = "QuizKosin.jsp";//クイズ変更用のページのurlをセット

		} else {//フォームから送られてきたACTIONが削除

			boolean del = false;
			QuizDAO dao = new QuizDAO();
			try {
				del = dao.quizDelete(delet); //クイズの削除を実行
			} catch (DAOException e) {
				e.printStackTrace();
			}

				if(del){//削除できたかどうかで遷移するページを変更
					url = "QuizSakujoOK.jsp";
				} else {
					url = "QuizSakujoNG.jsp";
				}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
