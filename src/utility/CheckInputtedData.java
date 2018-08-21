//CheckInputtedData.java
//Created by Akihiro Yamada on 2018/08/08.
//Copyright (c) 2018. All Rights Reserved.

package utility;

import java.util.ArrayList;
import java.util.List;

/**
 * データの形式をチェックする
 *
 */
public class CheckInputtedData {
	//定数の各値は、主にmembersテーブルの仕様に基づいて決定
	static final int MAX_NAME_LENGTH = 15;
	static final int MIN_PASSWORD_LENGTH = 8;
	static final int MAX_PASSWORD_LENGTH = 30;
	static final int MAX_EMAIL_LENGTH = 50;
	static final int MAX_BALANCE_LENGTH = 10;

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
		//入力ミスがあった場合のエラーメッセージのリスト
		List<String> errMsgs = new ArrayList<String>();

		if (name == null || name.equals("")) {
			errMsgs.add("氏名を入力してください");
		} else if (name.length() > MAX_NAME_LENGTH) {
			errMsgs.add("氏名を15文字以内で入力してください");
		}
		if (password1 == null || password1.equals("")) {
			errMsgs.add("パスワードを入力してください");
		} else if (password1.length() < MIN_PASSWORD_LENGTH) {
			errMsgs.add("パスワードを8文字以上の半角英数字で入力してください");
		} else if (password1.length() > MAX_PASSWORD_LENGTH) {
			errMsgs.add("パスワードを30文字以内で入力してください");
		} else if (!password1.equals(password2)) {
			errMsgs.add("パスワードが確認のパスワードと一致しません");
		}
		if (email == null || email.equals("")) {
			errMsgs.add("メールアドレスを入力してください");
		}
		if (email.length() > MAX_EMAIL_LENGTH) {
			errMsgs.add("メールアドレスを50文字以内で入力してください");
		}
		try {
			if (balanceStr != null && !balanceStr.equals("")) {
				//数値が入力されたか、文字列が入力されたかを確かめる用
				Integer.parseInt(balanceStr);

				if (balanceStr.length() > MAX_BALANCE_LENGTH) {
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
