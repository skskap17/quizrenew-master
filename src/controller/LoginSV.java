package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.bean.UserBean;
import model.dao.DAOException;

/**
 * Servlet implementation class LoginSV
 */
@WebServlet("/LoginSV")
public class LoginSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//ログインするSV

		//ログイン情報の判定
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		//ログイン情報をビーンにセット
		UserBean beana = new UserBean();
		beana.setName(name);
		beana.setPass(pass);

		//LoginLogicでログイン判定
		LoginLogic login = new LoginLogic();

		UserBean log = null;
		try {
			//LoguinLogicで入力情報と登録情報で判定してもらう
			log = login.execute(beana);
		} catch (DAOException e) {
			e.printStackTrace();
		}

		String url;

		if (log != null) {
			//判定結果がOKであればユーザー情報をセッションへ保存
			HttpSession session = request.getSession();
			session.setAttribute("log",log);
			url = "Top.jsp";

		} else {
			url = "LoginMiss.jsp";

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}


