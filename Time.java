public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        set(hour, minute);
    }

    public void set(int hour, int minute) {
        if(0 <= hour && hour <= 23 && 0 <= minute && minute <= 59) {
            this.hour = hour; this.minute = minute;
        } else {
            throw new IllegalArgumentException("Invalid time.: " + Integer.toString(hour) + ":" + Integer.toString(minute) + " { 0 <= h <= 23 && 0 <= m <= 59 }");
        }
    }

    public void set(Time time) {
        int h, m;
        h = time.getHour();
        m = time.getMinute();
        set(h, m);
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

    public static Time diff(Time t1, Time t2) {
        int h1, h2, m1, m2;
        h1 = t1.getHour();
        h2 = t2.getHour();
        m1 = t1.getMinute();
        m2 = t2.getMinute();
        int hour, min;
        min = m1 - m2;
        hour = h1 - h2;

        if(min < 0) {
            min = 60 + min;
            hour -= 1;
        } else {
            if(60 < min) {
                min = min - 60;
                hour += 1;
            }
        }

        if(hour < 0) {
            min = 23 + hour;
        } else {
            if(23 < hour) {
                hour = hour - 24;
            }
        }

        Time diff = new Time(hour, min);
        return diff;
    }

    public static String toWritten (Time t) {
        int h, m;
        h = t.getHour();
        m = t.getMinute();
        return String.format("%d Hour(s) and %d Minute(s)", h, m);
    }
}
