class Light{
    public void turn_on(){
        System.out.println("Turn on the light");
    }
    public void turn_off(){
        System.out.println("Turn off the light");
    }
}

class Temperature{
    public void increase_temp(){
        System.out.println("Increse the Temperature");
    }
    public void decrese_temp(){
        System.out.println("Decrese the Temperature");
    }

}
class SecuiritySystem{
    public void on_alarm(){
        System.out.println("Ringing on the alarm");
    }
    public void off_alarm(){
        System.out.println("Ringing  off the alarm");
    }
}

//facade class
class HomeAutomatedSystem{
    Light light;
    Temperature temperature;
    SecuiritySystem secuiritySystem;

    public HomeAutomatedSystem() { // objects created inside the Constructer
        light = new Light();
        temperature =  new Temperature();
        secuiritySystem = new SecuiritySystem();
    }
    public void activateSignals(){
        light.turn_on();
        temperature.increase_temp();
        secuiritySystem.on_alarm();
    }
    public void deactivateSignals(){
        light.turn_off();
        temperature.decrese_temp();
        secuiritySystem.off_alarm();
    }
}

// Client class
public class FacadeDesignPattern {
    public static void main(String[] args) {
        HomeAutomatedSystem facade = new HomeAutomatedSystem();

        // Using the facade to activate and deactivate the home automation system
        facade.activateSignals();
        facade.deactivateSignals();
    }
}
