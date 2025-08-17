/**
 * @author Arya Singh   `
 * this class set the basic blueprint for an agent
 */

public class Agent{
    private String agentName;
    private String codeName;
    private String UID;
    private  int agentID;
    private Clearance agentClearance;
    private static int nextID = 549321;


    /**
     * constructor 1 for agent class
     * @param agentName
     * @param codeName
     */
    public Agent(String agentName, String codeName) {
        this.agentName = agentName;
        this.codeName = codeName;
        this.agentID = nextID++;
        this.UID = codeName + "@" + agentID;

    }

    /**
     * constructor 2 for agent class
     * @param agentName
     * @param codeName
     * @param agentClearance
     */

    public Agent(String agentName, String codeName, Clearance agentClearance){
        this.agentName = agentName;
        this.codeName = codeName;
        this.agentID = nextID++;
        this.UID = codeName + "@" + agentID;
        this.agentClearance = agentClearance;
    }

    /**
     * getter for all agent information
     * @return
     */

    public String getAgentInfo(){
        return UID + " ( " + agentClearance + " Clearance" + " )";
    }

    /**
     * setter for agent name
     * @param name
     */
    public void setAgentName(String name){
        this.agentName = name;
    }

    /**
     * getter for agent name
     * @return
     * agent name
     */
    public String getAgentName(){
        return agentName;
    }

    /**
     * setter for agent code name
     * @param codeName
     */
    public void setCodeName(String codeName){
        this.codeName = codeName;

    }

    /**
     * getter for code name
     * @return
     */
    public String getCodeName(){
        return this.codeName;
    }

    /**
     * getter for agent ID
     * @return
     */
    public int getAgentID(){
        return agentID;
    }

    /**
     * getter for agent UID
     * @return
     */
    public String getUID(){
        return UID;

    }

    /**
     * setter for agent clearance
     * @param agentClearance
     */
    public void setAgentClearance(Clearance agentClearance){
        this.agentClearance = agentClearance;
    }

    /**
     * getter for agent clearance
     * @return
     */
    public Clearance getAgentClearance(){
        return this.agentClearance;
    }

    /**
     * to string method to get all the details of the agent
     * @return
     */

    public String toString(){
        String output = ("Name : " + agentName + " CodeName : " + codeName + " UID : " + UID + " agentID :" + agentID );
        return output;
    }




}
