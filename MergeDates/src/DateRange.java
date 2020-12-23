import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateRange implements Comparable<DateRange> {
	private String startDate;
	private String endDate;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public DateRange(String startDate, String endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "DateRange [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	@Override
	public int compareTo(DateRange dR) {
		DateFormat formatter;
		formatter = new SimpleDateFormat("DD MMM yyyy");
		try {
			Date start_Date = formatter.parse(startDate);
			Date end_Date = formatter.parse(endDate);
			Date start_1Date = formatter.parse(dR.startDate);
			Date end_1Date = formatter.parse(dR.startDate);
			
			return start_Date.compareTo(start_1Date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
