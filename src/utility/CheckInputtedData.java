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
			String password2, String balanceStr, String email) {
		List<String> errMsgs = new ArrayList<String>();
		if (name == null || name.equals("")) {
			errMsgs.add("氏名を入力してください");
		} else if (name.length() > 15) {
			errMsgs.add("氏名を15文字以内で入力してください");
		}
		if (password1 == null || password1.equals("")) {
			errMsgs.add("パスワードを入力してください");
		} else if (password1.length() < 8) {
			errMsgs.add("パスワードを8文字以上の半角英数字で入力してください");
		} else if (password1.length() > 30) {
			errMsgs.add("パスワードを30文字以内で入力してください");
		} else if (!password1.equals(password2)) {
			errMsgs.add("パスワードが確認のパスワードと一致しません");
		}
		if (email == null || email.equals("")) {
			errMsgs.add("メールアドレスを入力してください");
		}
		if (email.length() > 50) {
			errMsgs.add("メールアドレスを50文字以内で入力してください");
		}
		try {
			if (balanceStr != null && !balanceStr.equals("")) {
				//数値が入力されたか確かめる用
				Integer.parseInt(balanceStr);
				if (balanceStr.length() > 10) {
					errMsgs.add("初期残高を10桁以内で入力してください");
				}
			} else {
				errMsgs.add("初期残高を入力してください");
			}
			return errMsgs;
		} catch (NumberFormatException e) {
			errMsgs.add("残高には数値を入力してください");
			return errMsgs;
		}
	}
}
