class Notifier{
    private final String username;
    public Notifier(String username) {
        this.username = username;
    }

    public void send(String username,String msg, String mail){
        System.out.println("Sending " + msg +"by Mail to" + mail);
    }

    public String getUsername() {
        return username;
    }
}

class DatabaseService{
    public String getMailFromUsername(String username){
        return username + "@mail";
    }
}

class WhatsAppNotifier extends Notifier{
    public WhatsAppNotifier(String username) {
        super(username);
    }

    public void send(String msg){
        String phoneNbr = databaseService.getphoneNbrFromUsername(getUsername());
        System.out.println("Sending" + msg + "by WhatsApp on " + phoneNbr);
    }
}

class FaceBookNotifier extends Notifier{
    public FaceBookNotifier(String username) {
        super(username);
    }

    public void send(String msg){
        String fbName = databaseService.getFBNameFromUsername(getUsername());
        System.out.println("Sending" + msg + "by Facebook on " + fbName);
    }
}

class databaseService{
    public static String getphoneNbrFromUsername(String username){
        return username + "@Phone";
    }

    public static String getFBNameFromUsername(String username){
        return username + "@Facebook";
    }
}




public class DecoraterDesignPattern {
    public static void main(String[] args) {
        WhatsAppNotifier notifier = new WhatsAppNotifier("Geekific");
        notifier.send("User1","mail byme","to him");
    }
}


//class Notifier{
//    private final String username;
//    private final DatabaseService databaseService;
//    public Notifier(String username) {
//        this.username = username;
//        databaseService = new DatabaseService();
//    }
//
//    public void send(String username,String msg, String mail){
//        String mail1 = databaseService.getMailFromUsername(username);
//        System.out.println("Sending " + msg +"by Mail to" + mail);
//    }
//
//    public String getUsername() {
//        return username;
//    }
//}


