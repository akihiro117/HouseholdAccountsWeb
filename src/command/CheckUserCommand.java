package command;

import javax.servlet.http.HttpServletRequest;

public class CheckUserCommand implements Command {
	public String execute(HttpServletRequest request) {
		String nextPage = "error.jsp";

		return nextPage;
	}
}
