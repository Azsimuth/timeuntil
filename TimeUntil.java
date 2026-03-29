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
        
            Time goalTime = new Time(hour, minute, true);
            
            LocalTime timeObject = LocalTime.now();
            Time currentTime = new Time(timeObject.getHour(), timeObject.getMinute(), false);
            
            Time diff = Time.diff(currentTime, goalTime, false);
            
            boolean isTomorrow = Time.isNegative(diff);

            if(!isTomorrow) {
                String goal = Time.toString(goalTime, false);
                String written = Time.toWritten(diff);
                System.out.println("Time remaining until " + goal + " is " + written);
            } else {
				Time untilThen = new Time(goalTime, false);
				Time untilMidn = Time.diff(currentTime, new Time(24, 0, false), false);
				untilThen = untilThen.add(untilThen, untilMidn, false);
				String written = Time.toWritten(untilThen);
                String goal = Time.toString(goalTime, false);
                System.out.println("Time remaining until tomorrow " + goal + " is " + written);
            }

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }
}
