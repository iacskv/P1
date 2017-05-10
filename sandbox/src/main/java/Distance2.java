

/**
 * Created by Константин on 12.03.2017.
 */
public class Distance2 {
  public static void main (String[] arg){

    Point1 p1 = new Point1(10,20); // экземпляр первой точки
    Point1 p2 = new Point1(20,30); // экземпляр второй точки

    //вывод рассчитанной дистанции
    System.out.println("расстояние между точкой Р1 с координатами (" + p1.x + ", " + p1.y + ") и точкой P2 с координатами (" + p2.x + ", "+ p2.y + ")");
    System.out.println("равно " + Point1.distance(p1,p2));

  }

}