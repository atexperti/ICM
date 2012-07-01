package org.icm.token;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A cache for all the authentication tokens. It is accessed as a singleton 
 */
public class AuthenticationTokenCache {
    
    private Map<Object,Object > tokens = Collections.synchronizedMap(new HashMap<Object,Object >());
    private static AuthenticationTokenCache instance = null;

	/**
     * default constructor
	 */
    protected AuthenticationTokenCache() {
		super();
	}
     
    /**
     * Retrieves the instance of the cache
     * @return instance of the cache
     */
    public static AuthenticationTokenCache getInstance() {
        if ( instance == null ) {
            AuthenticationTokenCache.instance = new AuthenticationTokenCache();
        }
        
        return AuthenticationTokenCache.instance;
    }
    
    /**
     * Add a sessions token to the cache
     * @param sessionId unique id associated with the users session
     * @param token token associated with the session 
     */
    public void addSessionToken(Object sessionId, Object token) {
    	
        this.tokens.put(sessionId, token);
        //System.out.println(tokens);
    }
    
    /**
     * retrieves the token associated with the users session
     * 
     * @param sessionId unique id associated with the users session
     * @return token associated with the session
     */
    public Object getSessionToken(Object sessionId) {
    	return this.tokens.get(sessionId);
    }
    
    /**
     * Removes the token associated with the users session
     * @param sessionId unique id associated with the users session
     */
    public synchronized void removeSessionToken(Object sessionId) {
    	this.tokens.remove(sessionId);
    }

}
