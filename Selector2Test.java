import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class Selector2Test {

   Comparator<Integer> comp;
   Collection<Integer> c;
comp = new CompareIntegers()

   /** Fixture initialization (common initialization
    *  for all tests). **/
//   @Before public void setUp() {
  // }

@Test public void kminTestElements() {
   //----------------------------------
      c = new ArrayList<>();
      c.add(10); c.add(4);
   //----------------------------------
      int expected = 4;
      int actual = Selector2.kmin(c, 1, comp);
      String msg = "kmin";
      Assert.assertEquals(msg, expected, actual);
   }
      }