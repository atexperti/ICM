package org.icm.token;
import java.util.Random;

public class RandomAlphaNumericTokenGenerator
{

  private static final char[] symbols = new char[36];

  static {
    for (int idx = 0; idx < 10; ++idx)
      symbols[idx] = (char) ('0' + idx);
    for (int idx = 10; idx < 36; ++idx)
      symbols[idx] = (char) ('a' + idx - 10);
  }

  private final Random random = new Random();

  private final char[] buf;

  public RandomAlphaNumericTokenGenerator(int length)
  {
    if (length < 1)
      throw new IllegalArgumentException("length < 1: " + length);
    buf = new char[length];
  }

  public String nextString()
  {
    for (int idx = 0; idx < buf.length; ++idx) 
      buf[idx] = symbols[random.nextInt(symbols.length)];
    return new String(buf);
  }
  public static void main(String[] args) {
	  RandomAlphaNumericTokenGenerator rs  =new RandomAlphaNumericTokenGenerator(6);
	  System.out.println(rs.nextString().toUpperCase());
	  
  }
}
