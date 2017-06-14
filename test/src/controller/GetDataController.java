package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DataDao;

/**
 * Servlet implementation class GetDataController
 */
public class GetDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDataController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataDao dataDao = new DataDao();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int temp = Integer.parseInt(request.getParameter("temp"));
		int humi = Integer.parseInt(request.getParameter("humi"));
		if (dataDao.updateList(temp, humi) > 0) {
			response.getWriter().println(("Them Thanh Cong !"));
		} else {
			response.getWriter().println(("Them That Bai !"));
		}
		response.getWriter().println("Temp: "+temp + " ---- " + "Humi: "+humi);

	}

}
