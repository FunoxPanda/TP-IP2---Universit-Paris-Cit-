public class Message {

    String content;
    Utilisateur sender;
    
    public Message(String message, Utilisateur sender) {
        if(message.length() == 0) return;
        this.content = message;
        this.sender = sender;
    }
    
}
