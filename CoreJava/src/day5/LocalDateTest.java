package day5;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

class LocalDateTest {
	
	
	@Test
	void testDateTime() {
		LocalDateTime independence=LocalDateTime.of(1947,8,15,9,15,10);
		System.out.println(independence);
	}

	@Test
	void test() {
		LocalDate independence=LocalDate.of(1947, 8, 15);
		System.out.println(independence);
		LocalDate preIndependence =independence.minusDays(1);
		System.out.println(preIndependence);
		LocalDate postIndependence=independence.plusDays(1);
		System.out.println(postIndependence);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println(dtf.format(independence));
		System.out.println(LocalDate.parse("1947-08-15"));
	}

}
