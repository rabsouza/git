package br.com.boletos.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class Teste {

	@Test
	public void test(){
//		for (int i = 0; i < 50; i++) {
//			System.out.println("0"+ (new Random().nextInt(90000) + 90000));
//		}

		DateFormat formatter = new SimpleDateFormat("MMM");
	    GregorianCalendar calendar = new GregorianCalendar();
	    calendar.set(Calendar.MONTH, 3-1);
	    System.out.println(formatter.format(calendar.getTime()));
	}

}
