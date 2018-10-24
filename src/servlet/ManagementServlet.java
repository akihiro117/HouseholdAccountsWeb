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
import command.LogoutCommand;
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

		if (commandName == null) {
			commandName = "";
		}

		switch (commandName) {
		case "":
			nextPage = "LoginForm.jsp";
			break;
		case "CheckUser":
			//入力されたメールアドレスとパスワードをチェック。
			//会員情報を取得。
			nextPage = new CheckUserCommand().execute(request);
			break;
		case "MemberRegistForm":
			//新規会員登録フォーム。
			nextPage = "MembeerRegistForm.jsp";
			break;
		case "MemberRegistConfirm":
			//会員情報の入力チェック。
			nextPage = new CheckMemberFormCommand().execute(request);
			break;
		case "RegistMember":
			//会員情報をDBに登録。
			nextPage = new RegistMemberCommand().execute(request);
			break;
		case "RegistExchange":
			//収支情報をDBに登録。
			nextPage = new RegistExchangeCommand().execute(request);
			break;
		case "Logout":
			//ログアウト
			nextPage = new LogoutCommand().execute(request);
			break;
		default:
			//エラーページ。
			request.setAttribute("errMsg", "指定されたページは存在しません");
			nextPage = "ErrorPage.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
