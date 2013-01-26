package wyd.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeHelper {

	public static long toMilliSeconds(final java.util.Date inDate) {
		return inDate.getTime();
	}

	public static long toMilliSeconds(final java.sql.Date inDate) {
		return inDate.getTime();
	}

	public static java.util.Date toDateWithTimeOff(final java.util.Date inDate) {
		Calendar inCal = Calendar.getInstance();
		inCal.setTimeInMillis(inDate.getTime());
		inCal.set(Calendar.HOUR_OF_DAY, 0);
		inCal.set(Calendar.MINUTE, 0);
		inCal.set(Calendar.SECOND, 0);
		inCal.set(Calendar.MILLISECOND, 0);
		return inCal.getTime();
	}

	public static java.sql.Date toSqlDate(final java.util.Date inDate) {
		java.sql.Date outDate = new java.sql.Date(inDate.getTime());
		return outDate;
	}

	public static java.sql.Date toSqlDateWithTimeOff(final java.util.Date inDate) {
		Calendar inCal = Calendar.getInstance();
		inCal.setTimeInMillis(inDate.getTime());
		inCal.set(Calendar.HOUR_OF_DAY, 0);
		inCal.set(Calendar.MINUTE, 0);
		inCal.set(Calendar.SECOND, 0);
		inCal.set(Calendar.MILLISECOND, 0);
		java.sql.Date outDate = new java.sql.Date(inCal.getTimeInMillis());
		return outDate;
	}

	public static java.sql.Date toSqlDateWithTimeOff(final Calendar inCal) {
		inCal.set(Calendar.HOUR_OF_DAY, 0);
		inCal.set(Calendar.MINUTE, 0);
		inCal.set(Calendar.SECOND, 0);
		inCal.set(Calendar.MILLISECOND, 0);
		java.sql.Date outDate = new java.sql.Date(inCal.getTimeInMillis());
		return outDate;
	}

	public static java.sql.Timestamp toSqlTimestamp(final java.util.Date inDate) {
		return new java.sql.Timestamp(inDate.getTime());
	}

	public static java.sql.Timestamp toSqlTimestamp(final java.sql.Date inDate) {
		return new java.sql.Timestamp(inDate.getTime());
	}

	public static String toDateAsString(SimpleDateFormat sdf, Date date) {
		return sdf.format(date);
	}

	public static Date getFirstDateOfCurrentMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE,
				calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}

	public static Date getLastDateOfCurrentMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}
}
