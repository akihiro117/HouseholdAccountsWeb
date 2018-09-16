//Conversion.java
//Created by Akihiro Yamada on 2018/07/30.
//Copyright (c) 2018. All Rights Reserved.

package utility;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * データ型の変換を提供する
 *
 */
public class Conversion {
	/**
	 * Calendar型のオブジェクトをjava.sql.Date型に変換する
	 * @param date Calendar型のオブジェクト
	 * @return 引数のCalendarオブジェクトの日付値を表すjava.sql.Date型の
	 * オブジェクト
	 */
	public static Date convertCalendarToDate(Calendar date) {
		//date.getTime()でjava.util.Date型のオブジェクトを取得
		//date.getTime().getTime()でlong型(ミリ秒)を取得
		//Date(long date)でjava.sql.Dateのオブジェクトを構築
		return new Date(date.getTime().getTime());
	}

	public static Calendar convertDateToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	public static String convertCalendarToString(Calendar date) {
		return new SimpleDateFormat("yyyy/MM/dd").format(date.getTime());
	}
}
