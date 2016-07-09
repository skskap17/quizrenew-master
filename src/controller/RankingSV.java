package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RankingLogic;
import model.bean.UserBean;

/**
 * Servlet implementation class RankingSV
 */
@WebServlet("/RankingSV")
public class RankingSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RankingSV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RankingSVのdoGetきたよ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RankingSVのdoPostきたよ");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		//ランキングを確認するSV

		RankingLogic ranLog = new RankingLogic();
		List<UserBean> ranking = ranLog.getRanking();

		request.setAttribute("ranking", ranking);

		RequestDispatcher rd = request.getRequestDispatcher("Ranking.jsp");
		rd.forward(request, response);
	}

}
