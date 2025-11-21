import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DatePart {

    private Date date = null;
    private SimpleDateFormat formatter = null;

    public DatePart(Date anyDate) {
        this.date = anyDate;
        formatter = new SimpleDateFormat("EEE MMM dd hh:mm:ss yyyy", Locale.getDefault());
    } 

    public int getDay() {
        formatter.applyPattern("d");
        return Integer.parseInt(formatter.format(date));
    }

    public int getMonth() {
        formatter.applyPattern("M");
        return Integer.parseInt(formatter.format(date));
    }

    public int getYear() {
        formatter.applyPattern("y");
        return Integer.parseInt(formatter.format(date));
    } 

    public int getHour() {
        formatter.applyPattern("h"); 
        return Integer.parseInt(formatter.format(date));
    } 

    public int getMinute() {
        formatter.applyPattern("m");
        return Integer.parseInt(formatter.format(date));
    }
    
}