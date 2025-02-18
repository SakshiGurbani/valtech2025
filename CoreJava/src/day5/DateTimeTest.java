package day5;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class DateTimeTest {

	@Test
	void test() throws Exception{
	  Date now=new Date();
	  System.out.println(now);
	  Date independence=new Date(47,7,15);
	  System.out.println(independence);
	  
	  
	  
	  /*
	   * yyyy = year  yy(last 2 digit)
	   * MM = numeric Month   MMM=alpha
	   * dd=day
	   * Hour=hh
	   * Minute=mm
	   * Second=ss
	   * */
	  DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
	  System.out.println(df.format(independence));
	  Date republic=df.parse("26-01-1950");
	  System.out.println(republic);
	
	}

}
