//RegistMemberCommand.java
//Created by Akihiro Yamada on 2018/08/08.
//Copyright (c) 2018. All Rights Reserved.

package command;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import entity.Member;
import utility.ConnectionOperator;

/**
 * 新規会員登録フォームに入力された情報をDBに登録するためのクラス。
 *
 */
public class RegistMemberCommand implements Command {
	/**
	 * 会員情報をDBに登録する
	 * @param request requestオブジェクト
	 * @return
	 * 成功した場合は、遷移先のjsp名を返し、
	 * 失敗した場合はnullを返す。
	 */
	@Override
	public String execute(HttpServletRequest request) {
		Connection con = null;
		try {
			con = ConnectionOperator.getConnection();
			con.setAutoCommit(false);

			//membersテーブルを操作するためのDaoクラス。
			MemberDao memberDao = new MemberDao(con);

			HttpSession session = request.getSession();
			//フォームに入力された会員情報。
			Member member = (Member) session.getAttribute("member");
			//システム日付を登録日とする
			Calendar registrationDate = Calendar.getInstance();
			member.setRegistrationDate(registrationDate);

			//会員情報をDBのmembersテーブルに登録
			memberDao.insert(member);
			//登録結果に登録情報を表示するためにセットする
			request.setAttribute("member", member);
			session.invalidate();

			con.commit();
			//会員登録結果の画面のjsp
			return "MemberRegistResult.jsp";
		} catch (SQLException e1) {
			//ErrorPage.jspに表示するエラー文
			request.setAttribute("errMsg", "SQLの処理中にエラーが発生しました");
			try {
				if (con != null) {
					con.rollback();
				}
			} catch (SQLException e2) {

			}
			//SQLのエラーが発生した場合はエラーページに遷移する
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
