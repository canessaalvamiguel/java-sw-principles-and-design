package tellDontAsk;

/***
 * https://martinfowler.com/bliki/TellDontAsk.html
 * https://martinfowler.com/bliki/GetterEradicator.html
 *
 * There's a hell of a lot of code out there in OO languages that is procedural in design.
 * The OO community may have 'won' in the sense that modern languages are dominated by objects,
 * but they are still yet to win in that OO programming is still not widely used.
 * As a result it's still common to see procedures that pull data out of an object to do something,
 * when that behavior would better fit in the object itself - a violation of the pragmatic programmers
 * principle of "Tell Don't Ask".
 * You can only do this kind of procedural programming if you have getters, so telling people
 * to get rid of getters helps push them to move behavior into the right place.
 */
public class TellDontAsk {
    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        AskMonitor am = new AskMonitor("Time Vortex Hocus", 2, alarm);
        //No violate the Tell don't ask principle, the warn logic is inside
        am.setValue(3);
    }
}

class Alarm{
    void warn(String message){
        System.out.println(message);
    }
}

class AskMonitor{

    private int value;
    private int limit;
    private boolean isTooHigh;
    private String name;
    private Alarm alarm;

    public AskMonitor (String name, int limit, Alarm alarm) {
        this.name = name;
        this.limit = limit;
        this.alarm = alarm;
    }

    public void setValue(int arg) {
        value = arg;
        //No violate the Tell don't ask principle, the warn logic is inside
        if (value > limit) alarm.warn(name + " too high");
    }

    public int getValue() {return value;}
    public int getLimit() {return limit;}
    public String getName()  {return name;}
    public Alarm getAlarm() {return alarm;}
}
