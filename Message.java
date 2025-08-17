/**
 * a class to send messages between the agent
 */
public class Message {
    private Agent to;
    private Agent from;
    private String content;
    private Message next;
    private int[] encoded;
    private int[] encrypted;
    private int[] decrypted;
    private Clearance secrecy;

    /**
     * constructor 1 of message class
     * @param from
     * @param to
     * @param content
     */
    public Message(Agent from, Agent to, String content){
        this.to = to;
        this.from = from;
        this.content = content;
    }

    /**
     * constructor 2 of message class
     * @param from
     * @param to
     * @param content
     * @param secrecy
     */
    public Message(Agent from, Agent to, String content, Clearance secrecy){
        this.to = to;
        this.from = from;
        this.content = content;
        this.secrecy = secrecy;
    }

    /**
     * setter for the sender agent
     * @param to
     */
    public void setTo(Agent to){
        this.to = to;
    }

    /**
     * encoder method to encode the content of the message being sent
     */
    public void encode(){
        encoded = new int[content.length()];
        for(int i = 0; i < content.length(); i++){
            encoded[i] = content.charAt(i);
        }
    }

    /**
     * method to properly construct the out of the encoded messages
     * @return
     */
    public String getEncoded() {
        String result = "encoded: ";
        if (encoded == null) {
            result = "<not encoded>";
        } else {
            for (int i = 0; i < encoded.length; i++) {
                result += "[" + encoded[i] + "]";
            }
        }
        return result;
    }

    /**
     * encrypt method to encrypt the encoded content
     * @param key
     */
    public void encrypt(int key) {
        if(content == null){
            return;
        }else{
        encode();
        encrypted = new int[content.length()];

        for(int i = 0; i < content.length(); i++){
            encrypted[i] = encoded[i] + key;
        }

        content = "";
        for(int ch : encrypted) {
            content += (char) ch;
        }
    }
    }

    /**
     * method to construct the output of encrypted content
     * @return
     */
    public String getEncrypted() {
        String result = "encrypted: ";
        if (encrypted == null) {
            result = "<not encrypted>";
        } else {
            for (int i = 0; i < encrypted.length; i++) {
                result += "[" + encrypted[i] + "]";
            }
        }
        return result;
    }


    /**
     * method to decrypt content back to normal
     * @param key
     */
    public void decrypt(int key) {
        if(encrypted == null){
            return ;
        }else{
        decrypted = new int[content.length()];

        for(int i = 0; i < content.length(); i++){
            decrypted[i] = content.charAt(i) - key;
        }
        content = "";
        for(int ch : decrypted) {
            content += (char) ch;
        }
        }
    }

    /**
     * method to construct the output of decrypted content
     * @return
     */

    public String getDecrypted() {
        String result = "decrypted: ";

        if (decrypted == null) {
            result = "<not decrypted>";
        } else {
            for (int i = 0; i < decrypted.length; i++) {
                result += "[" + decrypted[i] + "]";
            }
        }

        return result;
    }


    /**
     * getter for receiver
     * @return
     */
    public Agent getTo() {
        return to;
    }

    /**
     * setter for sender
     * @param from
     */
    public void setFrom(Agent from) {
        this.from = from;
    }

    /**
     * getter for sender
     * @return
     */
    public Agent getFrom() {
        return from;
    }

    /**
     * setter for content
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * getter for content
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * setter for next message
     * @param next
     */
    public void setNext(Message next) {
        this.next = next;
    }

    /**
     * getter for next message
     * @return
     */
    public Message getNext() {
        return next;
    }

    /**
     * setter for secrecy
     * @param secrecy
     */
    public void setSecrecy(Clearance secrecy) {
        this.secrecy = secrecy;
    }

    /**
     * getter for secrecy
     * @return
     */
    public Clearance getSecrecy() {
        return secrecy;
    }


    @Override
    public String toString() {
        String output = ( "Message from " + from.getCodeName() + " to " + to.getCodeName() + ":\n" + content);
        return output;
    }

    /**
     * method to construct all messages in a proper way
     * @return
     */

    public String debugString() {
        String output = toString() + "\n";
        output += getEncoded() + "\n";
        output += getEncrypted() + "\n";
        output += getDecrypted() + "\n";
        return output;
    }


}
