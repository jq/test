import org.junit.Test;


public class AllsubStringOfString {
  private static boolean isRomeChar(char c) {
    return c >='a' && c <= 'z';
  }
  private static int getCharNumber(String str) {
    int len = str.length();
    int count = 0;
    for (int i =0; i < len; ++i) {
      char c = str.charAt(i);
      
      if (isRomeChar(c)) count++;
    }
    System.out.println(count);
    return count;
  }
  
  public static int decode(String testEncStr) {
    System.out.println(testEncStr);
    throw new RuntimeException("always bad " + testEncStr);
  }
  
  
  public static int decodeFind(String badEncStr) {
    // srejsdf_kljjj324hjks_
    try {
      return decode(badEncStr);
    } catch (RuntimeException e) {
        
    }
    
    int size = getCharNumber(badEncStr);
    int max = 1 << size;
    for (int i = 0; i < max; i++) {
      StringBuilder subStr = new StringBuilder();
      int k = i;
      for (int j = 0; j < badEncStr.length(); ++j) {
        char c = badEncStr.charAt(j);
        if (isRomeChar(c)) {
          if ((k & 1) > 0) {
            subStr.append(Character.toUpperCase(c));
          } else {
            subStr.append(c);
          }
          k >>= 1;
        } else {
          subStr.append(c);
        }
      }
      try {
        return decode(subStr.toString());
      } catch (RuntimeException e) {
        
      }
    }
    return -1;
    }
    @Test
    public void test() {
        AllsubStringOfString.decodeFind("sf_j324hj_");
    }

}
