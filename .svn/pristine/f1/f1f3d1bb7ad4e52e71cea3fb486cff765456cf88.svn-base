package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InsertLogic;
import model.bean.UserBean;

/**
 * Servlet implementation class InsertSV
 */
@WebServlet("/InsertSV")
public class InsertSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSV() {
        super();
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
		response.setCharacterEncoding("UTF-8");
		System.out.println("insertSVのdoPostです");

		//ユーザー情報の新規登録

		//登情報の取得
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		UserBean bean = new UserBean();

		//ビーンにセット
		bean.setName(name);
		bean.setPass(pass);

		//InsertLogicで登録判定
		InsertLogic il = new InsertLogic();
		boolean result = il.execute(bean);

		String msg = null;
		if(result){//メッセージのセット
			msg = "登録完了";
		} else {
			msg = "既にユーザーIDが登録されています";
		}
		request.setAttribute("msg", msg);

		RequestDispatcher rd = request.getRequestDispatcher("TourokuKanryo.jsp");
		rd.forward(request, response);

	}

}
