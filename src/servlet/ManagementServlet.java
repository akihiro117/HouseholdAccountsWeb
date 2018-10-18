//ManagementServlet.java
//Created by Akihiro Yamada on 2018/07/23.
//Copyright (c) 2018. All Rights Reserved.

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CheckMemberFormCommand;
import command.CheckUserCommand;
import command.RegistExchangeCommand;
import command.RegistMemberCommand;

/**
 * Servlet implementation class ManagementServlet
 */
@WebServlet("/ManagementServlet")
public class ManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagementServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String commandName = request.getParameter("command");

		String nextPage = "ErrorPage.jsp";
		switch (commandName) {
		case "CheckUser":
			nextPage = new CheckUserCommand().execute(request);
			break;
		case "MemberRegistForm":
			nextPage = "MemberRegistForm.jsp";
			break;
		case "MemberRegistConfirm":
			nextPage = new CheckMemberFormCommand().execute(request);
			break;
		case "RegistMember":
			nextPage = new RegistMemberCommand().execute(request);
			break;
		case "RegistExchange":
			nextPage = new RegistExchangeCommand().execute(request);
			break;
		default:
			request.setAttribute("errMsg", "指定されたページは存在しません");
			nextPage = "ErrorPage.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
