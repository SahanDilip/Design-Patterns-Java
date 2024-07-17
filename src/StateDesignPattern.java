class Phone{
    private State state;
    public Phone(){
        state = new OffState(this);
    }
    public State getState() {
        return state;
    }

    public void setState(State state){
        this.state =state;
    }
    public String lock(){
        return "Looking phone and turning off the screen";
    }
    public String turnOn(){
        return "Turning screen on,Device still locked";
    }
    public String unlock(){
        return "Unlocking the phone to home";
    }
    public String home(){
        return "Going to home-screen";
    }
}

abstract class State{
    protected Phone phone;
    public State(Phone phone) {
        this.phone = phone;
    }
    public abstract String onHomebutton();
    public abstract String onnOffOnutton();
}

class OffState extends State{
    public OffState(Phone phone) {
        super(phone);
    }

    @Override
    public String onHomebutton() {
        phone.setState(new LockedState(phone));
        return phone.turnOn();
    }

    @Override
    public String onnOffOnutton() {
        phone.setState(new LockedState(phone));
        return phone.turnOn();
    }
}

class LockedState extends State{
    public LockedState(Phone phone){
        super(phone);
    }

    @Override
    public String onHomebutton() {
        phone.setState(new ReadyState(phone));
        return phone.unlock();
    }

    @Override
    public String onnOffOnutton() {
        phone.setState(new OffState(phone));
        return phone.lock();
    }

}

class ReadyState extends State{
    public ReadyState(Phone phone){
        super(phone);
    }

    @Override
    public String onHomebutton(){
        return phone.home();
    }

    @Override
    public String onnOffOnutton() {
        phone.setState(new OffState(phone));
        return phone.lock();
    }

}


public class StateDesignPattern {
    public static void main(String[] args) {
        Phone phone = new Phone();
        System.out.println(phone.getState().onHomebutton());
        System.out.println(phone.getState().onnOffOnutton());
        System.out.println(phone.getState().onHomebutton());

    }
}
