package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Data;
import model.dao.DataDao;

/**
 * Servlet implementation class GetLedController
 */
public class GetLedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLedController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataDao dataDao = new DataDao();
		Data objD = dataDao.getList();
		if (objD.isDoor()) {
			response.getWriter().println("1");
		} else {
			response.getWriter().println("0");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		DataDao dataDao = new DataDao();
		Data objD = dataDao.getList();
		boolean led = Boolean.parseBoolean(request.getParameter("led"));
		
		System.out.println(led);
		if (dataDao.updateLed(led) > 0) {
			
		} else {
			response.getWriter().println(("Them That Bai !"));
		}
		if (led) {
			out.print("<input type='checkbox' id='buttonThree' style='display:none' name='checkbot' onclick='return checkBox(this.value)' checked/>"+
					"<label for='buttonThree'>"+
					"<i></i>"+
					"</label>");
		} else {
			out.print("<input type='checkbox' id='buttonThree' style='display:none' name='checkbot' onclick='return checkBox(this.value)' unchecked/>"+
					"<label for='buttonThree'>"+
					"<i></i>"+
					"</label>");
		}
		
	}

}
