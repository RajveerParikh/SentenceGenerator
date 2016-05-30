package sentenceGenerator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFileChooser;

/**
 * This is my version of a CIT594 assignment to read in a BNF grammar
 * and produce sentences from that grammar.
 */
public class SentenceGenerator {
    private Grammar grammar;
    private Random random = new Random();

    /**
     * Prompts the user for a file containing a BNF grammar, then
     * generates several sentences from that grammar.
     * 
     * @param args Unused.
     */
    public static void main(String[] args) {
        try {
            new SentenceGenerator().run();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Does the work of this class.
     * 
     * @throws IOException If an input exception occurs.
     */
    private void run() throws IOException {
    	BufferedReader readLine = getFileReader();
    	grammar = new Grammar(readLine);
        grammar.print();
        for (int j = 0; j < 20; j++){
        	printAsSentence(generate("<sentence>"));
        }        
    }
    
    /**
     * Expands the given term into a list of terminals. If the given
     * term is already a terminal, a list containing this single term
     * is returned.
     * 
     * @param term A terminal or nonterminal to expand into a list.
     * @return A list of terminals.
     */
    List<String> generate(String term) {
        List<String> result = new ArrayList<String>();
        ListOfDefinitions listDef = grammar.getDefinitions(term);
        SingleDefinition singleDef = (SingleDefinition) chooseRandomElement(listDef);
        if (singleDef.get(0).charAt(0) == ('<')){
        	for(int i = 0; i < singleDef.size(); i++){
        		if (singleDef.get(0).charAt(0) == ('<')){
        			result.addAll(generate(singleDef.get(i)));
        		}
        		
        	}
        }
        else {
        	result.addAll(singleDef);
        }
    	return result;
    }

    /**
     * Randomly choose and return one element from a list.
     * 
     * @param list The list from which the selection is to be made.
     * @return The randomly selected element.
     */
    private Object chooseRandomElement(List list) {
        return (list.get(random.nextInt(list.size())));
    }

    /**
     * Prints the given list of words as a sentence. The first word is
     * capitalized, and a period is printed at the end.
     * 
     * @param list The words to be printed.
     */
    void printAsSentence(List<String> list) {
    	System.out.printf("%s ", list.get(0).substring(0, 1).toUpperCase() + list.get(0).substring(1));
    	for (int x = 1; x < list.size(); x++){
    		if (x == list.size() -1){
    			System.out.printf("%s", list.get(x));
    		}
    		else{
    			System.out.printf("%s ", list.get(x));
    		}
    	}
    	System.out.print(".");
    	System.out.println("");
    }
    
    /**
     * Prompts the user to choose a file, which should contain a BNF grammar.
     * 
     * @return The chosen file, or <code>null</code> if none is chosen.
     */
    private BufferedReader getFileReader() throws IOException{
    	BufferedReader reader = null;
    	String fileName;
    	JFileChooser chooser = new JFileChooser();
    	chooser.setDialogTitle("Load which file?");
    	int result = chooser.showOpenDialog(null);
    	if(result == JFileChooser.APPROVE_OPTION){
    		File file = chooser.getSelectedFile();
    		if(file != null){
    			fileName = file.getCanonicalPath();
    			reader = new BufferedReader(new FileReader(fileName));
    		}
    	}
    	return reader;
    }
}