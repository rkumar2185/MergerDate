import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DateMerger {

	public static void main(String[] args) {

		List<DateRange> list_of_Date = new ArrayList<>();

		/*
		 * 01 Jan 2014 - 30 Jan 2014 15 Jan 2014 - 15 Feb 2014 10 Mar 2014 - 15 Apr 2014
		 * 10 Apr 2014 - 15 May 2014
		 */

		list_of_Date.add(new DateRange("01 Jan 2014", "30 Jan 2014"));
		list_of_Date.add(new DateRange("15 Jan 2014", "15 Feb 2014"));
		list_of_Date.add(new DateRange("10 Mar 2014", "15 Apr 2014"));
		list_of_Date.add(new DateRange("10 Apr 2014", "15 May 2014"));

		/*
		 * 01 Jan 2014 – 15 Jan 2014 16 Jan 2014 – 30 Jan 2014
		 */

		/*
		 * list_of_Date.add(new DateRange("01 Jan 2014", "15 Jan 2014"));
		 * list_of_Date.add(new DateRange("16 Jan 2014", "30 Feb 2014"));
		 */
		List<DateRange> x = new ArrayList<>();
		x = mergeDates(list_of_Date);

		for (Iterator iterator = x.iterator(); iterator.hasNext();) {
			DateRange dR = (DateRange) iterator.next();
			System.out.println(dR.getStartDate() + "-" + dR.getEndDate());
		}

	}

	public static List<DateRange> mergeDates(List<DateRange> dateRanges) {

		Collections.sort(dateRanges); // we will get sorted Date Range , implemented comparble interface

		Set<DateRange> result_list = new TreeSet<DateRange>();
		List<DateRange> merged_Intervals = new ArrayList<DateRange>();

		// declare date formate to parse and format date from string to and from
		DateFormat sdf = new SimpleDateFormat("DD MMM yyyy");

		if (dateRanges.size() == 1) {
			return dateRanges;
		}

		if (dateRanges.size() > 1) {
			// get first DateRange Object. consider it as first interval
			DateRange merge_Interval = dateRanges.get(0);

			// System.out.println(merge_Interval);
			// loop other intervals from second in the list
			for (int i = 1; i < dateRanges.size(); i++) {
				DateRange Second_interval = dateRanges.get(i);
				// System.out.println(Second_interval);
				try {
					Date startDate1 = sdf.parse(merge_Interval.getStartDate());
					Date endDate1 = sdf.parse(merge_Interval.getEndDate());
					Date startDate2 = sdf.parse(Second_interval.getStartDate());
					Date endDate2 = sdf.parse(Second_interval.getEndDate());

					// System.out.println(startDate1 + " " + endDate1 + " " + startDate2+"
					// "+endDate2);
					// compare if current interval's start date is before merging interval's end
					// date
					// then the two intervals are overlaping
					if (startDate2.before(endDate1)) {
						// System.out.println("1");
						// check whether end date of current loop interval is after the merging
						// interval.
						// then we need to update the end date of merging interval with looping
						// interval's end date
						if (endDate2.after(endDate1)) {
							// System.out.println("2");

							merge_Interval.setEndDate(Second_interval.getEndDate());

						}
					} else {
						// compare if current interval's start date is after merging interval's end date
						// then it must be a new interval start so swap mergInterval variable with
						// current looping interval

						merge_Interval = Second_interval;

					}

					// add merge interval to set.
					result_list.add(merge_Interval);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}

		}
		merged_Intervals.addAll(result_list);
		return merged_Intervals;

	}

}
