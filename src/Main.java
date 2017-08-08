import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		
		Date ini =  df.parse("01/06/2003");
		Date fim =  df.parse("34/06/2003");
		int d = GregorianCalendar.DATE;
		System.out.println(d);
	}
}
