import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AgentUnitTest {

    @Test
    public void testConstructorAndGetters() {
        Agent newAgent = new Agent("Claire", "Cinderella");
        assertEquals("Claire", newAgent.getAgentName());
        assertEquals("Cinderella", newAgent.getCodeName());
    }

    @Test
    public void testSetters() {
        Agent newAgent = new Agent("Claire", "Cinderella");
        newAgent.setAgentName("Arya");
        newAgent.setCodeName("Swiftie");
        assertEquals("Arya", newAgent.getAgentName());
        assertEquals("Swiftie", newAgent.getCodeName());
    }

    @Test
    public void testAgentUID() {
        Agent newAgent = new Agent("Claire", "Cinderella");
        String expected = newAgent.getCodeName() + "@" + newAgent.getAgentID();
        assertEquals(expected, newAgent.getUID());
    }

    @Test
    public void testToString() {
        Agent newAgent = new Agent("Claire", "Cinderella");
        String expected = "Name : Claire CodeName : Cinderella UID : " + newAgent.getUID() + " agentID :" + newAgent.getAgentID();
        assertEquals(expected, newAgent.toString());
    }
}


@Test
public void testingTask1(){
    ArrayList<String> postcodesA = new ArrayList<>();
    postcodesA.add("AA");
    postcodesA.add("AB");
    postcodesA.add("BB");

    SortingOffice officeA = new SortingOffice(20,70,"India", true, postcodesA);
    assertEquals(officeA.getLocation(), "X20Y70CIndia");
    assertTrue(officeA.isInternational());
}
}