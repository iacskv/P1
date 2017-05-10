

import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Math.round;

/**
 * Created by Константин on 18.03.2017.
 */
public class DistanceTests {

  @Test
  public void testDistanceZero() {

    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 0);
    Assert.assertEquals(p1.distance(p2),0.0);
  }

  @Test
  public void testDistance1() {

    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 1);
    Assert.assertEquals(p1.distance(p2),1.0);
  }

  @Test
  public void testDistance22() {

    Point p1 = new Point(0, 0);
    Point p2 = new Point(10, 20);
    Assert.assertEquals(round(p1.distance(p2)*100)/100.00,22.36);
  }

}