# MergerDate
You have to write a Java program. Create a class called DateMerger. This class should have a method called mergeDates. This method takes a list of class DateRange which has member variables startDate and endDate.
The method signature looks like:
public List<DateRange>mergeDates(List<DateRange>dateRanges)
This function should scan the list of passed date ranges and merge those date ranges.
For example, if given the below date ranges
01 Jan 2014 - 30 Jan 2014
15 Jan 2014 - 15 Feb 2014
10 Mar 2014 - 15 Apr 2014
10 Apr 2014 - 15 May 2014
The output should be:
01 Jan 2014 - 15 Feb 2014
10 Mar 2014 - 15 May 2014
Note: If start date of a date range is greater than end date of another date range, then do not merge those date ranges. For example, the below date ranges should not be merged:
01 Jan 2014 – 15 Jan 2014
16 Jan 2014 – 30 Jan 2014
(There is a gap of one day between first and second date ranges).
Below date ranges should be merged:
01 Jan 2014 – 15 Jan 2014
15 Jan 2014 – 30 Jan 2014
(End date of first date range matches with start date of second date range).
