interface IButton{
    public void showbutton();
}
class MacButton implements IButton{
    @Override
    public void showbutton() {
        System.out.println("This is Mac button");
    }
}
class WindowsButton implements IButton{
    @Override
    public void showbutton() {
        System.out.println("This is a Windows Button");
    }
}

interface ITextbox{
    public void showtext();
}
class WindowsTextbox implements ITextbox{
    @Override
    public void showtext() {
        System.out.println("This is a windows TextBox");
    }
}
class MacTextbox implements ITextbox{
    @Override
    public void showtext() {
        System.out.println("This is a Mac textbox");
    }
}

interface IFactories{
    public IButton getBotton();
    public ITextbox getTextBox();
}

class factoryproduce{
    public static IFactories getFactory(String choice){
        if(choice.equalsIgnoreCase("Mac")){
            return new MacFactory();
        } else if (choice.equalsIgnoreCase("Windows")) {
            return new WindowsFactory();
        }
        return null;
    }
}

class MacFactory implements IFactories{

    @Override
    public IButton getBotton() {
        return new MacButton();
    }

    @Override
    public ITextbox getTextBox() {
        return new MacTextbox();
    }
}
class WindowsFactory implements IFactories{

    @Override
    public IButton getBotton() {
        return new WindowsButton();
    }

    @Override
    public ITextbox getTextBox() {
        return new MacTextbox();
    }
}

public class AbstFactoryDesignPattern{
    public static void main(String[] args) {
        IFactories fac1 = factoryproduce.getFactory("Mac");
        fac1.getBotton();
        fac1.getTextBox().showtext();

    }
}

