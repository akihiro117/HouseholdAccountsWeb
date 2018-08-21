//Command.java
//Created by Akihiro Yamada on 2018/07/26.
//Copyright (c) 2018. All Rights Reserved.

package command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

/**
 * Commandを提供するクラスが実装するインターフェース
 *
 */
public interface Command {
	public abstract String execute(HttpServletRequest request)
			throws IOException;
}
