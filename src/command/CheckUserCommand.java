//CheckUserCommand.java
//Created by Akihiro Yamada on 2018/07/26.
//Copyright (c) 2018. All Rights Reserved.

package command;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.LogDao;
import dao.MemberDao;
import entity.ExchangeLog;
import entity.Member;
import utility.ConnectionOperator;

/**
 * ログインフォームに入力されたメールアドレスと
 * パスワードの組の正誤をチェックし、
 * 会員情報をDBから取得するためのクラス。
 *
 */
public class CheckUserCommand implements Command {
	/**
	 * ログインフォームに入力されたメールアドレスと
	 * パスワードの組の正誤をチェックし、
	 * 正しい場合は、会員情報、収支の履歴をDBから取得して
	 * sessionに登録した後、遷移先のjsp名を返す
	 * @param request リクエストオブジェクト
	 * @return 遷移先のjsp名
	 */
	public String execute(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Connection con = null;
		try {
			//遷移先のjsp
			String nextPage = null;
			//接続オブジェクトを取得
			con = ConnectionOperator.getConnection();
			MemberDao memberDao = new MemberDao(con);
			//emailとパスワードを元に、Memberオブジェクトを取得
			Member member = memberDao.selectMemberByParam(email, password);
			//入力されたemailとpasswordをもつ会員が存在しない場合は
			//ログインフォームに遷移する
			if (member == null) {
				//ログインフォームに表示するエラーメッセージ
				request.setAttribute("errMsg",
						"入力したメールアドレスまたはパスワードが間違っています");
				nextPage = "LoginForm.jsp";
			} else {
				HttpSession session = request.getSession();

				//会員の収支の履歴
				LogDao logDao = new LogDao(con);
				List<ExchangeLog> log = logDao
						.selectLogByMember(member.getId());
				session.setAttribute("log", log);

				//ログインしている間は、会員情報を使うため、
				//sessionにMemberオブジェクトを追加
				session.setAttribute("member", member);
				nextPage = "MainPage.jsp";
			}
			return nextPage;
		} catch (SQLException e) {
			request.setAttribute("errMsg", "SQLの処理中にエラーが発生しました");
			return "ErrorPage.jsp";
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

			}
		}
	}
}
