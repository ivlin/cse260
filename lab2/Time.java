import java.util.Calendar;
public class Time{
    private int hour,minute,second;

    public Time(){
	Calendar cal = Calendar.getInstance();
	hour = cal.get(Calendar.HOUR_OF_DAY);
	minute = cal.get(Calendar.MINUTE);
	second = cal.get(Calendar.SECOND);
    }

    public Time(int milliseconds){
	Calendar cal = Calendar.getInstance();
	cal.setTimeInMillis(milliseconds);
	hour = cal.get(Calendar.HOUR_OF_DAY);
	minute = cal.get(Calendar.MINUTE);
	second = cal.get(Calendar.SECOND);
    }

    public Time(int setHrs, int setMins, int setScnds){
	hour = setHrs;
	minute = setMins;
	second = setScnds;
    }

    public int getHour(){
	return hour;
    }

    public int getMinute(){
	return minute;
    }

    public int getSecond(){
	return second;
    }

    public void setTime(long elapseTime){
	second+= (elapseTime/1000) % 60;
	minute+= (elapseTime/1000) % 3600;
	hour+=(elapseTime/1000);
    }

    public String toString(){
	return hour+":"+minute+":"+second;
    }
}
