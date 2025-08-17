/**
 * class to implement secret agent who have their own personal inbox
 */
public class SecretAgent extends Agent {

    private Inbox personalInbox;
    private Clearance clearance;

    /**
     * constructor for secret agent class
     * @param agentName
     * @param codeName
     * @param clearance
     */
    public SecretAgent(String agentName, String codeName,Clearance clearance) {
        super(agentName, codeName, clearance);
        this.personalInbox = new Inbox();
    }

    /**
     * getter for inbox
     * @return
     */
    public Inbox getInbox() {
        return this.personalInbox;
    }

    /**
     * method to send message after undergoing some tests
     * @param receiver
     * @param msg
     * @param key
     */
    public void send(SecretAgent receiver, Message msg, int key) {
        if (msg.getFrom() != this) {
            System.out.println("Sender does not match.");
            return;
        }
        if (msg.getTo() != receiver) {
            System.out.println("Receiver does not match.");
            return;
        }
        if (this.getAgentClearance().getClearanceHierarchy() < receiver.getAgentClearance().getClearanceHierarchy() - 1 ) {
            System.out.println("Sender has insufficient clearance.");
            return;
        }

        msg.encrypt(key);
        receiver.personalInbox.receive(msg);
    }

    /**
     * method ot decrypt all the message in the personal inbox
     * @param keys
     */
    public void decryptAll(int[] keys) {
        Message currentMessage = personalInbox.getRecent();

        while(currentMessage != null){
        for (int i = 0; i < keys.length; i++) {
            if ( currentMessage.getFrom().getAgentClearance().getClearanceHierarchy()
                    < this.getAgentClearance().getClearanceHierarchy() - 1) {
                currentMessage.decrypt(keys[i]);
            }
            currentMessage = currentMessage.getNext();
        }
        }

        if (currentMessage != null) {
            System.out.println("Not enough keys supplied!");
        }
    }





}
