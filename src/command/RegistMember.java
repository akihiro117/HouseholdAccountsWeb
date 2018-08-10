package command;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.MemberDao;
import entity.Member;
import utility.CheckInputtedData;
import utility.ConnectionOperator;

public class RegistMember implements Command {
	//
	/**
	 * 会員情報をDBに登録する
	 * @param request requestオブジェクト
	 * @return
	 * 成功した場合は、遷移先の画面名を返し、
	 * 失敗した場合はnullを返す
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String memberName = request.getParameter("memberName");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String balanceStr = request.getParameter("balance");
		//フォームに入力された情報の形式をチェックする
		List<String> errMsgs = CheckInputtedData.checkMemberForm(memberName, password1,
				password2, balanceStr);
		//入力データにエラーがあった場合は、
		//エラーメッセージをattributeにセットし、会員登録フォームを返す
		if (!errMsgs.isEmpty()) {
			request.setAttribute("errMsgs", errMsgs);
			return "RegistUser.jsp";
		} else {
			Connection con = null;
			try {
				con = ConnectionOperator.getConnection();
				MemberDao memberDao = new MemberDao(con);

				Calendar registrationDate = Calendar.getInstance();
				String email = request.getParameter("email");
				//登録時の残高が入力されなかった場合には残高の初期値を0とする
				int balance = 0;
				//残高が入力された場合のみ、残高をint型に変換する
				if (balanceStr != null && !balanceStr.equals("")) {
					balance = Integer.parseInt(balanceStr);
				}
				Member member = new Member(memberName, password1, registrationDate, email, balance);
				//会員情報をDBのMemberテーブルに登録
				memberDao.insert(member);
				request.setAttribute("member", member);

				return "MemberRegistConfirm.jsp";
			} catch (SQLException e) {
				request.setAttribute("errMsg", "SQLの処理中にエラーが発生しました");
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

}
