//CheckUserCommand.java
//Created by Akihiro Yamada on 2018/10/14.
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
import dao.RegistExchangeDao;
import entity.ExchangeLog;
import entity.InputData;
import entity.Member;
import utility.ConnectionOperator;

/**
 *
 * 収支履歴を登録するコマンド。
 *
 */
public class RegistExchangeCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws IOException {

		//リクエストパラメータのエンコーディングを設定
		request.setCharacterEncoding("utf-8");
		//金額。
		int price = Integer.parseInt(request.getParameter("price"));
		//収入か支出か
		String isIncome = request.getParameter("isIncome");
		//収支の内容
		String detail = request.getParameter("detail");

		//フォームから入力されたデータをセット
		InputData inputData = new InputData();
		inputData.setPrice(price);
		if (isIncome.equals("true")) {
			inputData.setIsIncome(true);
		} else if (isIncome.equals("false")) {
			inputData.setIsIncome(false);
		}

		inputData.setDetail(detail);

		//sessionからメンバーIDを取得
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		int loginUserId = member.getId();
		inputData.setLoginUserId(loginUserId);

		Connection con = null;
		try {
			con = ConnectionOperator.getConnection();
			con.setAutoCommit(false);
			RegistExchangeDao registExchangeDao = new RegistExchangeDao(con);

			//入力された収支情報を登録
			registExchangeDao.insertExchange(inputData);

			//memberテーブルのbalanceを更新
			registExchangeDao.updateBalnce(loginUserId, price,
					inputData.getIsIncome());

			//会員の収支の履歴
			//入力データ反映後のデータを取得
			LogDao logDao = new LogDao(con);
			List<ExchangeLog> log = logDao
					.selectLogByMember(loginUserId);
			request.setAttribute("log", log);

			//入力データ後の残高情報を取得
			MemberDao memberDao = new MemberDao(con);
			Member updatedMember = memberDao.selectMemberByParam(
					member.getEmail(), member.getPassword());
			session.setAttribute("member", updatedMember);

			con.commit();

			//メインページを返す
			return "MainPage.jsp";
		} catch (SQLException e) {
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
