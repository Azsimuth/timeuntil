import java.time.*;

public class TimeUntil {
    public static void printUsage() {
        System.out.println("timeuntil hh:mm");
    }

    public static void main(String[] args) {

        if(args.length < 1) {
            printUsage();
            System.exit(1);
        }

        String timeStr = args[0];
        int hour, minute;

        try {
            String[] splits = timeStr.split(":");
            if(splits.length == 1) {
                throw new IllegalArgumentException("Format requires colon (:)");
            }
            hour = Integer.parseInt(splits[0]);
            minute = Integer.parseInt(splits[1]);
        
            Time t = new Time(hour, minute);
            
            LocalTime timeObject = LocalTime.now();
            Time currentTime = new Time(timeObject.getHour(), timeObject.getMinute());
            
            Time diff = Time.diff(t, currentTime);
            String start = Time.toString(t, false);
            String written = Time.toWritten(diff);
            System.out.println("Time remaining until " + start + ": " + written);

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }
}
