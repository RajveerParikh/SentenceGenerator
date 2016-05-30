package sentenceGenerator;
import java.util.ArrayList;

/**
 * A <code>ListOfDefinitions</code> object consists of a list of alternatives
 * (each of which is a list of terminals and/or nonterminals), but
 * does not include the thing being defined.
 * 
 * @author <Rajveer Parikh>
 */
public class ListOfDefinitions extends ArrayList<SingleDefinition> {
    
    /**
     * Constructs an empty list of definitions.
     */
    ListOfDefinitions() {}
    
    /**
     * Returns a string containing the contents of this <code>ArrayList</code>,
     * separated by <code>" | "</code> symbols.
     * 
     * @see java.util.AbstractCollection#toString()
     */
    @Override
    public String toString() {
    	String result = "";
    	int i = 0;
		for (SingleDefinition myDef : this){
			if (i == this.size() -1){
				result += myDef;
			}
			else{
				result += myDef + " | ";
			}
			i++;
		}
        return result;
    }
}
