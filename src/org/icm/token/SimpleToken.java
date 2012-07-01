package org.icm.token;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * A <code>Token</code> encapsulating a simple autentication
 */
public class SimpleToken implements Token {
    protected String authString = null;

    /**
     * Constructor
     * @param token the encapsulated token
     */
    public SimpleToken(String token) {
        this.authString = token;
    }

    /**
     * Renders the authentication token as a BufferedImage
     * @return the rendered image of the token
     */
    public BufferedImage getTokenImage() {
        //final constants
       // final double shearx = 0.53;
        //final double sheary = 0.2;
        final double rotate = Math.toRadians(-18);
        //default size
        int imageWidth = 100;
        int imageHeight = 60;
        //get a fix on the token dimensions
        BufferedImage i1 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graphics2D g1 = i1.createGraphics();
        AffineTransform t1 = new AffineTransform();
        t1.translate(0, 0);
       // t1.shear(shearx, sheary);
        t1.rotate(rotate);
        Font font1 = new Font("Georgia", Font.ITALIC, 24);
        TextLayout l = new TextLayout(authString, font1, g1.getFontRenderContext());
        Shape s = l.getOutline(t1);
        Rectangle r = s.getBounds();
        //got the tokens rendered dimensions
        double w = r.getWidth();
        double h = r.getHeight();
        //determine the new image size, if required
        if ((w * 1) > imageWidth) {
            imageWidth = (int)w * 1;
        }
        if ((h * 1) > imageHeight) {
            imageHeight = (int)h * 1;
        }
       // System.out.println("imageWidth: "+ imageWidth +" imageHeight:"+imageHeight );
        //now render the actual image
        BufferedImage i2 = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = i2.createGraphics();
        /*g2.setPaint(
            new GradientPaint(0, 0, Color.LIGHT_GRAY, imageWidth / 2, imageHeight / 2, Color.WHITE, true));*/
       // g2.setPaint(new Color(224,82,6));
        g2.setPaint(new Color(223,219,214));
        g2.fill(
            new Rectangle2D.Double(0, 0, (imageWidth*1), (imageHeight*1)));
        AffineTransform t2 = new AffineTransform();
        t2.translate(imageWidth / 2.0 - w / 2.0, imageHeight / 2.0 + h / 2.0);
       // t2.shear(shearx, sheary);
        t2.rotate(rotate);
        g2.setPaint(Color.black);
        g2.fill(l.getOutline(t2));
        return i2;
    }

    /**
     * validates the user inputs. Returns true if the user input matches the captchas value
     * @return true if the users response matched with the authentication token
     */
    public boolean validateResponse(Object response) {
        boolean result = false;
        String key = null;
        if (response != null) {
            key = (String)response.toString();
            if (key.equals(this.authString)) {
                result = true;
            }
        }
        return result;
    }

    /** @return font to be used for rendering */
    public Font getFont() {
        Font f = new Font("Times New Roman", Font.PLAIN, 30);
        return f;
    }
}
