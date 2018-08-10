package utility;

import java.util.ArrayList;
import java.util.List;

/**
 * データの形式をチェックする
 *
 */
public class CheckInputtedData {
	/**
	 * 入力された会員情報の入力チェックを行い、
	 * エラー内容に応じたエラーメッセージのリストを返す
	 * @param name 氏名
	 * @param password1 パスワード
	 * @param password2 確認用のパスワード
	 * @param balanceStr 残高
	 * @return 入力ミスがあった場合のエラーメッセージのリスト
	 */
	public static List<String> checkMemberForm(String name, String password1,
			String password2, String balanceStr) {
		List<String> errMsgs = new ArrayList<String>();
		if (name == null || name.equals("")) {
			errMsgs.add("氏名を入力してください");
		} else if (name.length() > 15) {
			errMsgs.add("氏名を15文字以内で入力してください");
		}
		if (password1 == null || password1.equals("") ||
				password2 == null || password2.equals("")) {
			errMsgs.add("パスワードを入力してください");
		} else if (!password1.equals(password2)) {
			errMsgs.add("確認用のパスワードと一致しません");
		}
		try {
			if (balanceStr != null && !balanceStr.equals("")) {
				Integer.parseInt(balanceStr);
			}
			return errMsgs;
		} catch (NumberFormatException e) {
			errMsgs.add("残高には数値を入力してください");
			return errMsgs;
		} finally {

		}
	}
}
