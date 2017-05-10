

/**
 * Created by Константин on 12.03.2017.
 */
public class Distance {
  public static void main (String[] arg){

    Point p1 = new Point(0,0); // экземпляр первой точки
    Point p2 = new Point(10,20); // экземпляр второй точки

    //вывод рассчитанной дистанции
    System.out.println("расстояние между точкой Р1 с координатами (" + p1.x + ", " + p1.y + ") и точкой P2 с координатами (" + p2.x + ", "+ p2.y + ")");
    System.out.println("равно " + p1.distance(p2));

  }
}
