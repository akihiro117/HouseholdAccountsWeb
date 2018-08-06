package command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
	public abstract String execute(HttpServletRequest request);
}
