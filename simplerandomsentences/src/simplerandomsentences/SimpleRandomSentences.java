package simplerandomsentences;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * The class includes variables and implements methods
 * to form random sentences.
 *
 */

public class SimpleRandomSentences { // Begin of class.

	// String array contains conjunctions.
	static String[] conjunction = new String[]{"and ", "or ", "but ", "because "};

	// String array for proper nouns.
	static String[] proper_noun = new String[]{"Fred ", "Jane ", "Richard Nixon ", 
	"Miss America "};

	// String array for common nouns.
	static String[] common_noun = new String[]{"man ", "man ", "fish ", "elephant ",
	"unicorn "};

	// String array for determiner.
	static String[] determiner = new String[]{"a ", "the ", "every ", "some "};

	// String array for adjective.
	static String[] adjective = new String[]{"big ", "big ", "pretty ", "bald "};

	//String array for intransitive verbs.
	static String[] intransitive_verb = new String[]{"runs ", "jumps ", "talks ",
	"sleeps "};

	// String array for transitive verbs.
	static String[] transitive_verb = new String[]{"loves ", "hates ", "sees ", 
			"knows ", "looks for ", "finds "};

	public static void main(String[] args) { // Begin of main.

		SimpleRandomSentences lol = new SimpleRandomSentences();

		System.out.println(lol.sentence());


	} // End of main.

	/**
	 * This method takes a String[] and choose randomly item of it.
	 * @param String[] listOfStrings.
	 * @return String.
	 */
	public static String randomItem (String[] listOfStrings) {

		return listOfStrings[(int)(listOfStrings.length * Math.random())];


	} // End of randomItem.

	/**
	 * The method forms sentence randomly, and returns a string.
	 * The method calls simple_sentence method, and randomItem method also.
	 * The method uses conjunction variable.
	 * @return String.
	 */
	public static String sentence() {

		// The String to return.
		String sen = simple_sentence();

		// Flag variable to control the second recursion.
		boolean flag = false;

		int random = (int) (2*Math.random());

		if (random == 0 && flag == false) {
			sen += randomItem(conjunction);
			sen+= sentence();
			flag = true;
		}

		return sen;

	} // End of sentence.

	/**
	 * The method uses verb_phrase method and noun_phrase method.
	 * @return String.
	 */
	public static String simple_sentence() {

		return noun_phrase() + verb_phrase();

	} // End of simple_sentence.

	/**
	 * This method uses randomItem method and verb_phrase. 
	 * The method uses proper_noun, determiner, adjective, and common_noun
	 * variables.
	 * @return String. 
	 */
	public static String noun_phrase() {

		// String to be returned.
		String np;
		int random1 = (int) (2*Math.random());
		int random2 = (int) (2*Math.random());

		if (random1 == 0) {
			np = randomItem(proper_noun);
		}

		else {
			np = randomItem(determiner);
			if(random2 ==0) {
				np += randomItem(adjective);
			}
			np += randomItem(common_noun);
			if (random2 == 1) {
				np += " who "+ verb_phrase();
			}

		}

		return np;

	} // End of noun_phrase.

	/**
	 * This method uses randomItem method, noun_phrase method and 
	 * simple_sentence method.
	 * The method uses intransitive_verb variable, transitive_verb variable and
	 * adjective variable.
	 * @return String.
	 */
	public static String verb_phrase() { 

		// String to be returned.
		String vp;
		int random = (int) (4*Math.random());

		switch(random){

		case 0 ->{
			vp = randomItem(intransitive_verb);
			break;

		}

		case 1 ->{
			vp = randomItem(transitive_verb) + noun_phrase();
			break;
		}

		case 2 ->{
			vp = " is " + randomItem(adjective);
			break;

		}

		default ->{
			vp = " believes that " + simple_sentence();
			break;

		}

		}

		return vp;

	} // End of verb_phrase.

} // End of class.