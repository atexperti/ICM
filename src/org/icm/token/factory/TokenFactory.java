package org.icm.token.factory;

import org.icm.token.Token;
import org.icm.token.TokenInstantiationException;

/**
 * Factory for producing tokens. 
 * 
 */
public abstract class TokenFactory {
    
    public static final java.lang.String DEFAULT_TOKEN_FACTORY = SimpleTokenFactory.class.getName();

	protected TokenFactory() {
		super();
	}
    
    /**
     * Returns an instance of a token factory based on the input parameter. If no name has been specified
     * it returns the default token factory <code>SimpleTokenFactory</code>
     * @param string fully qualified class name of the token factory
     * @return the token factory instance
     * @throws TokenInstantiationException if the token factory cant be reflectivley instantiated
     */
    public static TokenFactory getInstance(java.lang.String string) throws TokenInstantiationException {
        TokenFactory factory = null;
        
        if ( string == null ) {
            string = DEFAULT_TOKEN_FACTORY;
        }
        
        //determined the factory, now instantiate
        try {
            factory = (TokenFactory) Class.forName(string).newInstance();
        } catch(InstantiationException ie) {
            throw new TokenInstantiationException(
                    "Problem occured while instantiating token factory"+ie.getMessage());
        } catch(IllegalAccessException iae) {
            throw new TokenInstantiationException(
                    "Problem occured while accessing token factory"+iae.getMessage());
        } catch(SecurityException se) {
            throw new TokenInstantiationException(
                    "Problem occured while accessing token factory"+se.getMessage());
        } catch(ClassNotFoundException cnfe) {
            throw new TokenInstantiationException(
                    "Configured token factory cant be located"+cnfe.getMessage());
        }
    
        return factory;
    }
    
    /**
     * Interface of the token factory. Returns the next token. 
     * @return <code>Token</code> 
     */
    public abstract Token getToken();
}
