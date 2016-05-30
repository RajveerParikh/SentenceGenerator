package sentenceGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author <Rajveer Parikh>
 */
public class SingleDefinitionTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test method for {@link sentenceGenerator.SingleDefinition#toString()}.
     */
    @Test
    public final void testToString() {
    	SingleDefinition testSingleDef = new SingleDefinition();
    	SingleDefinition testSingleDef2 = new SingleDefinition();
    	testSingleDef.add("<adjective>");
    	testSingleDef.add("<adjectives>");
    	testSingleDef2.add("<noun phrase>");
    	testSingleDef2.add("<verb phrase>");
    	assertEquals("<adjective> <adjectives>", testSingleDef.toString());
    	assertEquals("<noun phrase> <verb phrase>", testSingleDef2.toString());
    	
    }

}
