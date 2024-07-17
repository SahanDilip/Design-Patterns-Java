class ExcelFile extends DataProcessor{

    public void readData(){
        System.out.println("Read Data from Excel file");
    }
    public void processData(){
        System.out.println("Process Data from Excel file");
    }
}

class TextFile extends DataProcessor{
    public void readData(){
        System.out.println("Read Data from Text file");
    }
    public void processData(){
        System.out.println("Process Data from Text file");
    }

}

abstract class DataProcessor{
    public void readProcessSave(){
        readData();
        processData();
        saveData();
    }
    public abstract void readData(); // api methna abstract method body ekk nathi ekk methn define karanwa api ewa sub class eke define krl tyenw kiyl
    public abstract void processData();
    public void saveData(){
        System.out.println("Save Data to Computer");
    }
}



public class TemplateDesignPattern {
    public static void main(String[] args) {
        DataProcessor obj1 = new ExcelFile();
        obj1.readProcessSave();

        DataProcessor obj2 = new TextFile();
        obj2.readProcessSave();

    }
}
