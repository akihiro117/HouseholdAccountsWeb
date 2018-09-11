//CheckUserCommand.java
//Created by Akihiro Yamada on 2018/07/26.
//Copyright (c) 2018. All Rights Reserved.

package command;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import entity.Member;
import utility.ConnectionOperator;

/**
 * ログインフォームに入力されたメールアドレスと
 * パスワードの組の正誤をチェックする
 *
 */
public class CheckUserCommand implements Command {
	/**
	 * ログインフォームに入力されたメールアドレスと
	 * パスワードの組の正誤をチェックし、
	 * 遷移先のjsp名を返す
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
				//ログインしている間は、会員情報を使うため、
				//sessionにMemberオブジェクトを追加
				HttpSession session = request.getSession();
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
