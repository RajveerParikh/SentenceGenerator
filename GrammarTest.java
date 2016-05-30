package sentenceGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author <Rajveer Parikh>
 */
public class GrammarTest {
	Grammar testGrammar;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    	 testGrammar = new Grammar();
    	 
    }

    /**
     * Test method for {@link sentenceGenerator.Grammar#Grammar()}.
     */
//    @Test
//    public final void testGrammar() {
//        fail("Not yet implemented");
//    }

    /**
     * Test method for {@link sentenceGenerator.Grammar#addRule(java.lang.String)}.
     */
    @Test
    public final void testAddRule() {
    	
    	testGrammar.addRule("<adjectives> ::= <adjective> | <adjective> <adjectives>");
    	ListOfDefinitions listDefTest = testGrammar.getDefinitions("<adjectives>");
    	SingleDefinition def1 = new SingleDefinition();
    	SingleDefinition def2 = new SingleDefinition();
    	def1.add("<adjective>");
    	def2.add("<adjective>");
    	def2.add("<adjectives>");
    	assertEquals (def1, listDefTest.get(0));
    	assertEquals(def2, listDefTest.get(1));
    
    }

    /**
     * Test method for {@link sentenceGenerator.Grammar#getDefinitions(java.lang.String)}.
     */
    @Test
    public final void testGetDefinitions() {
    	testGrammar.addRule("<adjectives> ::= <adjective> | <adjective> <adjectives>");
    	ListOfDefinitions listDefTest = testGrammar.getDefinitions("<adjectives>");
    	ListOfDefinitions expected = new ListOfDefinitions();
    	SingleDefinition def1 = new SingleDefinition();
    	SingleDefinition def2 = new SingleDefinition();
    	def1.add("<adjective>");
    	def2.add("<adjective>");
    	def2.add("<adjectives>");
    	expected.add(def1);
    	expected.add(def2);
    	assertEquals(expected, listDefTest);
    }

}
