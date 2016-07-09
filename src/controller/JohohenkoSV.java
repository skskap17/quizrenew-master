package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.JohohenkoLogic;
import model.bean.UserBean;

/**
 * Servlet implementation class JohohenkoSV
 */
@WebServlet("/JohohenkoSV")
public class JohohenkoSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JohohenkoSV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JohohenkoSVのdoGetきたよ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JohohenkoSVのdoPostきたよ");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		//フォームから持ってきたpassをビーンにセット
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession();
		UserBean user = (UserBean)session.getAttribute("log");
		System.out.println(user.getName());
		user.setPass(pass);

		//情報を変更
		JohohenkoLogic joLog = new JohohenkoLogic();
		System.out.println(user.getId());
		boolean result = joLog.updateUser(user);

		String msg = null;
		if(result){//変更結果のメッセージをセット
			msg = "パスワードの変更が完了しました";
		} else {
			msg = "パスワードの変更ができませんでした";
		}
		request.setAttribute("msg", msg);

		RequestDispatcher rd = request.getRequestDispatcher("Johohenkokekka.jsp");
		rd.forward(request, response);


	}

}
