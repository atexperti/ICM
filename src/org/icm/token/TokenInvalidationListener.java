package org.icm.token;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Performs maintainence of the token cache by purging token information of
 * expired sessions
 * 
 */
public class TokenInvalidationListener implements HttpSessionListener {

	/**
	 * Default constructor
	 */
	public TokenInvalidationListener() {
		super();
	}

	/**
	 * standard lifecycle call which is invoked when a session is created. Do
	 * nothing. <small>We could have created the authentication token here also
	 * but there is a possibility that all sessions wouldnt need authentication.
	 * Why increase our management burden unnecessarily </small>
	 * 
	 * @param event
	 */
	public void sessionCreated(HttpSessionEvent event) {
		//do nothing.
	}

	/**
	 * Invoked when a session is destroyed. It removes the <code>Token</code>
	 * from the authentication token cache
	 * 
	 * @param event
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		String sessionId = null;

		// remove the token from the token cache
		sessionId = event.getSession().getId();
		AuthenticationTokenCache.getInstance().removeSessionToken(sessionId);
		
	}

}
