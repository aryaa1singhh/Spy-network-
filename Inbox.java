/**
 * class for inbox through which messages will be received and sent
 */
public class Inbox {
    private Message recent; // this is head for my understanding

    /**
     * setting the head to null as no message has been received
     */
    public Inbox() {
        this.recent = null;
    }

    /**
     * method to receive message the new message is set as the head
     * @param message
     */
    public void receive(Message message) {
        message.setNext(recent);
        recent = message;
    }

    /**
     * a method to read the messages in the linked list and it will stop when no message is left in the list
     * @return
     */
    public Message read() {
        if (recent == null) {
            System.out.println("No message to read.");
            return null;
        }
        Message temp = recent;
        recent = recent.getNext();
        return temp;
    }

    public void printAll(){
        printAllRec(recent);
    }

    /**
     * a recursive method to print messages until no message is left to read
     * @param message
     */
    private void printAllRec(Message message){
        if(message == null){
            System.out.println("<no more messages>");
            return;
        }
        System.out.println(message.getContent());
        printAllRec(message.getNext());
    }

    /**
     * getter for the head of the linked list
     * @return
     */
    public Message getRecent(){
        return this.recent;
    }

    /**
     * setter for the head of the linked list
     * @param recent
     */
    public void setRecent(Message recent){
        this.recent = recent;
    }

}
