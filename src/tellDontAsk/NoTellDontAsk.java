package tellDontAsk;

public class NoTellDontAsk {
    public static void main(String[] args) {
        Alarm_ alarm = new Alarm_();
        AskMonitor_ am = new AskMonitor_("Time Vortex Hocus", 2, alarm);
        am.setValue(3);
        //Violates the Tell don't ask principle - this should be insite a method, it's logic
        if (am.getValue() > am.getLimit())
           am.getAlarm().warn(am.getName() + " too high");


    }
}

class Alarm_{
    void warn(String message){
        System.out.println(message);
    }
}

class AskMonitor_{

    private int value;
    private int limit;
    private boolean isTooHigh;
    private String name;
    private Alarm_ alarm;

    public AskMonitor_ (String name, int limit, Alarm_ alarm) {
        this.name = name;
        this.limit = limit;
        this.alarm = alarm;
    }

    public int getValue() {return value;}
    public void setValue(int arg) {value = arg;}
    public int getLimit() {return limit;}
    public String getName()  {return name;}
    public Alarm_ getAlarm() {return alarm;}
}
