package Xen.E2E;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class gettimestamp {
	
	public String get_timestamp()
	{
		DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String returned_date= dateFormat.format(date);
		 return returned_date;
	}

}
