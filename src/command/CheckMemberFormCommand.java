//CheckMemberFormCommand.java
//Created by Akihiro Yamada on 2018/08/20.
//Copyright (c) 2018. All Rights Reserved.

package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.Member;
import utility.CheckInputtedData;

public class CheckMemberFormCommand implements Command {
	/**
	 * フォームに入力された会員情報の形式をチェックし、
	 * 会員情報をsessionに登録する
	 * @param request リクエストオブジェクト
	 * @return 次の遷移先のjsp名
	 */
	@Override
	public String execute(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String memberName = request.getParameter("name");
		//ユーザが最初に入力したパスワード
		String password1 = request.getParameter("password1");
		//ユーザが確認用として2回目に入力したパスワード
		String password2 = request.getParameter("password2");
		String balanceStr = request.getParameter("balance");
		String email = request.getParameter("email");

		//フォームに入力された値の形式をチェックし、
		//チェックの結果を受けたエラーメッセージをerrMsgsに代入する
		List<String> errMsgs = CheckInputtedData.checkMemberForm(memberName,
				password1, password2, balanceStr, email);

		//フォームに入力された値にエラーがあった場合は、
		//エラーメッセージとフォームに入力された値をattributeにセットし、
		//会員登録フォームのjsp名を返す
		if (!errMsgs.isEmpty()) {
			request.setAttribute("errMsgs", errMsgs);

			//もう一度ログインフォームの新規登録リンクから
			//新規登録フォームに遷移した場合に、
			//前回入力したデータが表示されないようにするために
			//sessionではなくrequestのsetAttribute()を使う
			request.setAttribute("name", memberName);
			//もし入力された残高が文字列の場合、memberオブジェクトに
			//入れることができないため、memberオブジェクトを
			//attributeにセットせずに、パラメータ毎にセットする
			request.setAttribute("balance", balanceStr);
			request.setAttribute("email", email);

			//会員登録フォーム画面のjsp
			return "MemberRegistForm.jsp";
		} else {
			//入力された値にエラーがない場合

			Member member = new Member(memberName, password1, null, email,
					Integer.parseInt(balanceStr));
			HttpSession session = request.getSession();
			//登録確認画面への表示とDBへの登録を行うために
			//sessionのsetAttribute()を用いる
			session.setAttribute("member", member);

			//確認画面のjsp
			return "MemberRegistConfirm.jsp";
		}
	}

}
