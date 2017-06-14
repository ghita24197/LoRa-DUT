package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Data;
import model.dao.DataDao;

/**
 * Servlet implementation class GetFadeController
 */
public class GetFadeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFadeController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataDao dataDao = new DataDao();
		Data objD = dataDao.getList();
		response.getWriter().println(objD.getFled());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataDao dataDao = new DataDao();
		int fade = Integer.parseInt(request.getParameter("fade"));
		if (dataDao.updateFade(fade) > 0) {
			response.getWriter().println((fade));
		} else {
			response.getWriter().println(("Them That Bai !"));
		}
	}
}
