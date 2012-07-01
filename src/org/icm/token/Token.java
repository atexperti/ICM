package org.icm.token;

import java.awt.image.BufferedImage;

/**
 * The interface for the token used in the anonymous login module
 */
public interface Token {
    /**
     * The token rendered as an image. This is essential since we are providing a visual challenge to the user
     * @return token rendered as an image
     */
    public BufferedImage getTokenImage();

    /**
     * Validate if the users response matches the tokens internal state
     * @param response
     * @return true if the response matches
     */
    public boolean validateResponse(Object response);
}
