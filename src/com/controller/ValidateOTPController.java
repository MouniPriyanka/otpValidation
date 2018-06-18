package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateOTPController
 */
@WebServlet("/ValidateOTPController")
public class ValidateOTPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateOTPController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		//Get OTP from Parameter
		int paramOTP = Integer.parseInt(request.getParameter("validateOTP"));
		System.out.println("paramOTP:"+ paramOTP);
		
		//Get OTP from Session
		HttpSession session = request.getSession(false);
		int otp = (Integer)session.getAttribute("OTP");
		System.out.println("otp:"+ otp);
		
		if(paramOTP==otp) {
			response.sendRedirect("success.jsp"); //have to change according to the flow - TO-DO
		}
		else
		{
			response.sendRedirect("error.jsp"); //To-do
		}
		
	}

}
