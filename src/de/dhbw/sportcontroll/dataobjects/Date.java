/**
 * 
 */
package de.dhbw.sportcontroll.dataobjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

/**
 * To simplify the work with Dates and stuff
 * @author schoko
 *
 */
public class Date extends GregorianCalendar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1207186785567218449L;

	private String dateString;
	/**
	 * @return the dateString
	 */
	public String getDateString() {
		return dateString;
	}
	/**
	 * @param dateString the dateString to set
	 */
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	/**
	 * 
	 */
	public Date() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param milliSecsonds
	 */
	public Date(long milliSec){		
		super();
		this.setTimeInMillis(milliSec);		
		
	}
	/**
	 * @param zone
	 */
	public Date(TimeZone zone) {
		super(zone);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param aLocale
	 */
	public Date(Locale aLocale) {
		super(aLocale);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param zone
	 * @param aLocale
	 */
	public Date(TimeZone zone, Locale aLocale) {
		super(zone, aLocale);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 */
	public Date(int year, int month, int dayOfMonth) {
		super(year, month, dayOfMonth);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 * @param hourOfDay
	 * @param minute
	 */
	public Date(int year, int month, int dayOfMonth, int hourOfDay, int minute) {
		super(year, month, dayOfMonth, hourOfDay, minute);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 * @param hourOfDay
	 * @param minute
	 * @param second
	 */
	public Date(int year, int month, int dayOfMonth, int hourOfDay, int minute,
			int second) {
		super(year, month, dayOfMonth, hourOfDay, minute, second);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getDateGreLiEnd() {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		return df.format(this.getTime());
	}
	

}
