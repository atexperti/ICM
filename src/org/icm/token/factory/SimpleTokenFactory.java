package org.icm.token.factory;

import org.icm.token.RandomAlphaNumericTokenGenerator;
import org.icm.token.SimpleToken;
import org.icm.token.Token;


/**
 * Simple token factory. It produces string tokens from a random generator
 */
public class SimpleTokenFactory extends TokenFactory {

    /** 
     * Default constructor
     */
    public SimpleTokenFactory() {
		super();
	}

	/**
     * Creates and returns a new token
     * @return Token 
	 */
    public Token getToken() {
        Token token = null;
        String strToken = null;
        //get the next random int and convert it to a string
        RandomAlphaNumericTokenGenerator rs  =new RandomAlphaNumericTokenGenerator(6);
    	strToken = rs.nextString().toUpperCase();
        token = new SimpleToken(strToken);
        return token;
	}
}
