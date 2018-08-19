package command;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.Member;
import utility.CheckInputtedData;

public class CheckMemberForm implements Command {
	/**
	 * フォームに入力された会員情報の形式をチェックし、
	 * 会員情報をsessionに登録する
	 * @return 次の遷移先の画面名
	 */
	@Override
	public String execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			request.setAttribute("errMsg", "エンコーディングの処理中にエラーが発生しました");
			return "ErrorPage.jsp";
		}
		String memberName = request.getParameter("name");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String balanceStr = request.getParameter("balance");
		String email = request.getParameter("email");

		//フォームに入力された値の形式をチェックする
		List<String> errMsgs = CheckInputtedData.checkMemberForm(memberName,
				password1, password2, balanceStr, email);
		//入力データにエラーがあった場合は、
		//エラーメッセージと前回入力した値をattributeにセットし、
		//会員登録フォームを返す
		if (!errMsgs.isEmpty()) {
			request.setAttribute("errMsgs", errMsgs);

			//もう一度ログインフォームの新規登録リンクから
			//新規登録フォームに遷移した場合に、
			//前回入力したデータが表示されないようにするために
			//sessionではなくrequestのattributeを使う
			request.setAttribute("name", memberName);
			//もし入力された残高が文字列の場合、memberオブジェクトに
			//入れることができないため、個別にセットする
			request.setAttribute("balance", balanceStr);
			request.setAttribute("email", email);

			return "MemberRegistForm.jsp";
		} else {
			Member member = new Member(memberName, password1, null, email,
					Integer.parseInt(balanceStr));
			HttpSession session = request.getSession();
			session.setAttribute("member", member);

			//入力データにエラーがない場合は確認画面に遷移する
			return "MemberRegistConfirm.jsp";
		}
	}

}
