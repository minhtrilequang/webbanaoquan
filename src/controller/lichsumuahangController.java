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

import bean.khachhangbean;
import bean.lichsumuahangbean;
import dao.lichsumuahangdao;

/**
 * Servlet implementation class lichsumuahangController
 */
@WebServlet("/lichsumuahangController")
public class lichsumuahangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public lichsumuahangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<lichsumuahangbean> list = new ArrayList<lichsumuahangbean>();
		khachhangbean kh = (khachhangbean) session.getAttribute("dn");
		if (kh != null) {
			lichsumuahangdao lsmhdao = new lichsumuahangdao();
			try {
				list = lsmhdao.HienThilsmh(kh.getMakhachhang());

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		request.setAttribute("ds", list);
		RequestDispatcher rd = request.getRequestDispatcher("lichsumuahang.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
