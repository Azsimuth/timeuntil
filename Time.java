public class Time {
    private int hour;
    private int minute;
    private boolean isValidated;
	
    public Time(int hour, int minute, boolean isValidated) {
        set(hour, minute, isValidated);
    }
	
    public Time(Time t, boolean isValidated) {
        set(t, isValidated);
    }


    public void set(int hour, int minute, boolean isValidated) {
	if(isValidated)
        	if(0 <= hour && hour <= 23 && 0 <= minute && minute <= 59) {
            	this.hour = hour; this.minute = minute;
        	} else {
            	throw new IllegalArgumentException("Invalid time.: " + Integer.toString(hour) + ":" + Integer.toString(minute) + " { 0 <= h <= 23 && 0 <= m <= 59 }");
        } else {
		this.hour = hour; this.minute = minute;
	}
    }

    public void set(Time time, boolean isValidated) {
        int h, m;
        h = time.getHour();
        m = time.getMinute();
        set(h, m, isValidated);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public static String toString(Time t, boolean brackets) {
        if (!brackets)
            return String.format("%02d:%02d", t.getHour(), t.getMinute());
        else
            return toString(t);
    }

    public static String toString(Time t) {
        return String.format("(%02d:%02d)", t.getHour(), t.getMinute());
    }

    public static void print(Time t) {
        System.out.print(toString(t));
    }

    public void print() {
        System.out.print(toString(this));
    }

    public void println() {
        System.out.println(toString(this));
    }

    public static void println(Time t) {
        System.out.println(toString(t));
    }

    public static Time normalize(Time t) {
        int total_minutes = t.getHour() * 60 + t.getMinute();
        int hour, min;

        while(total_minutes < 0) {
            total_minutes += 1440;
        }

        int hours = (total_minutes / 60) % 24;
        int mins  = total_minutes % 60;

        return new Time(hours, mins, true);
    }

    public static Time diff(Time t1, Time t2, boolean norm) {
        int mins1 = t1.getHour() * 60 + t1.getMinute();
        int mins2 = t2.getHour() * 60 + t2.getMinute();
        int ttlms = mins2 - mins1;
        int hours = ttlms / 60;
        int minutes = ttlms % 60;
        Time res = new Time(hours, minutes, false);
        if (norm) {
            res = Time.normalize(res);
        }
        return res;
    }

    public static Time add(Time t1, Time t2, boolean norm) {
        int total_minutes = t1.getHour() * 60 + t2.getHour() * 60 + t1.getMinute() + t2.getMinute();
        int hours = total_minutes / 60;
        int minutes = total_minutes % 60;
        Time res = new Time(hours, minutes, false);
        if (norm) {
            res = Time.normalize(res);
        }
        return res;
    }

    public static String toWritten (Time t) {
        int h, m;
        h = t.getHour();
        m = t.getMinute();
        return String.format("%d Hour(s) and %d Minute(s)", h, m);
    }

    public static Time abs(Time t) {
        int h, m;
        h = t.getHour(); m = t.getMinute();
        if (h < 0) {
            h = -h;
        }
        if (m < 0) {
            m = -m;
        }
        return new Time(h, m, false);
    }

    public static boolean isNegative(Time t) {
        int h, m;
        h = t.getHour(); m = t.getMinute();
        if (h < 0 || m < 0) {
            return true;
        }
        return false;
    }
}
