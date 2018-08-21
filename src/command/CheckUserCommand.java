//CheckUserCommand.java
//Created by Akihiro Yamada on 2018/07/26.
//Copyright (c) 2018. All Rights Reserved.

package command;

import javax.servlet.http.HttpServletRequest;

public class CheckUserCommand implements Command {
	public String execute(HttpServletRequest request) {
		String nextPage = "error.jsp";

		return nextPage;
	}
}
