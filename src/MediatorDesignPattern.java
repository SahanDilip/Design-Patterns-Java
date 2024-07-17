/**
 * Mediator is a behavioral design pattern that lets you reduce chaotic dependencies between objects.
 * The pattern restricts direct communications between the objects and forces them to collaborate only via a mediator object.
 *
 * References: https://refactoring.guru/design-patterns/mediator
 *             https://www.digitalocean.com/community/tutorials/mediator-design-pattern-java
 */

import java.util.ArrayList;
import java.util.List;
interface ChatMediator {
    public void sendMessage(String msg, User user);

    void addUser(User user);
}

class ChatMediatorImpl implements ChatMediator{
    private List<User> users;

    public ChatMediatorImpl(){
        this.users=new ArrayList<>();
    }

    @Override
    public void addUser(User user){
        this.users.add(user);
    }

    @Override
    public void sendMessage(String msg, User user) {
        for(User u : this.users){
            //message should not be received by the user sending it
            if(u != user){
                u.receive(msg);
            }
        }
    }
}
class MediatorApplication {

    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();
        User user1 = new UserImpl(mediator, "Nikhil");
        User user2 = new UserImpl(mediator, "Shivam");
        User user3 = new UserImpl(mediator, "Vishrut");
        User user4 = new UserImpl(mediator, "Ali");
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Subscribe to Daily Code Buffer!!");
    }

}

abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator med, String name){
        this.mediator=med;
        this.name=name;
    }

    public abstract void send(String msg);

    public abstract void receive(String msg);
}
class UserImpl extends User {
    public UserImpl(ChatMediator med, String name) {
        super(med, name);
    }

    @Override
    public void send(String msg){
        System.out.println(this.name+": Sending Message="+msg);
        mediator.sendMessage(msg, this);
    }
    @Override
    public void receive(String msg) {
        System.out.println(this.name+": Received Message:"+msg);
    }
}