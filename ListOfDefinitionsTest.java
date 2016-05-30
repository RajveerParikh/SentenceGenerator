package sentenceGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author <Rajveer Parikh>
 */
public class ListOfDefinitionsTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test method for {@link sentenceGenerator.ListOfDefinitions#toString()}.
     */
    @Test
    public final void testToString() {
    	ListOfDefinitions testListOfDef = new ListOfDefinitions();
    	ListOfDefinitions testListOfDef2 = new ListOfDefinitions();
    	SingleDefinition def1 = new SingleDefinition();
    	SingleDefinition def2 = new SingleDefinition();
    	SingleDefinition def3 = new SingleDefinition();
    	SingleDefinition def4 = new SingleDefinition();
    	def1.add("<adjective>");
    	def2.add("<adjective>");
    	def2.add("<adjectives>");
    	def3.add("boy");
    	def4.add("ring");
    	testListOfDef.add(def1);
    	testListOfDef.add(def2);
    	testListOfDef2.add(def3);
    	testListOfDef2.add(def4);
    	assertEquals("<adjective> | <adjective> <adjectives>", testListOfDef.toString());
    	assertEquals("boy | ring", testListOfDef2.toString());
    }

}
