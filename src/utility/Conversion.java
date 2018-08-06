package utility;

import java.sql.Date;
import java.util.Calendar;

public class Conversion {
	public static Date convertCalendarToDate(Calendar date) {
		//date.getTime()でjava.util.Date型のオブジェクトを取得
		//date.getTime().getTime()でlong型(ミリ秒)を取得
		//Date(long date)でjava.sql.Dateのオブジェクトを構築
		return new Date(date.getTime().getTime());
	}
}
