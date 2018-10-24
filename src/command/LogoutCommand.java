//LogoutCommand.java
//Created by Akihiro Yamada on 2018/10/24.
//Copyright (c) 2018. All Rights Reserved.

package command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * ログアウトを行うためのcommandクラス。
 *
 */
public class LogoutCommand implements Command {

	/**
	 * sessionを破棄し、ログアウト後のjsp名を返す。
	 * @param request リクエストオブジェクト。
	 * @return ログアウト後のjsp名。
	 */
	@Override
	public String execute(HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();
		//sessionを破棄。
		session.invalidate();
		return "Logout.jsp";
	}

}
