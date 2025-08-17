/**
 * enum class for all the types of clearance an agent
 */
public enum Clearance {
    LEVEL_1A(1),
    LEVEL_1B(2),
    LEVEL_2(3),
    LEVEL_3(4);

    private final int CLEARANCE_HIERARCHY;

    private Clearance(int CLEARANCE_HIERARCHY){
        this.CLEARANCE_HIERARCHY =CLEARANCE_HIERARCHY;
    }
    public int getClearanceHierarchy(){
        return CLEARANCE_HIERARCHY;
    }
}
