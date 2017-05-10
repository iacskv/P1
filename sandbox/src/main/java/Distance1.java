

/**
 * Created by Константин on 11.03.2017.
 */
public class Distance1 {

  public static void main (String[] arg){

    Point p1 = new Point(10,20); // экземпляр первой точки
    Point p2 = new Point(20,30); // экземпляр второй точки

    //вывод рассчитанной дистанции
    System.out.println("расстояние между точкой Р1 с координатами (" + p1.x + ", " + p1.y + ") и точкой P2 с координатами (" + p2.x + ", "+ p2.y + ")");
    System.out.println("равно " + distance(p1,p2));

  }

  //функция расчета расстояния между точками на плоскости (корень из суммы квадратов катетов треугольника)
  public static double distance (Point p1, Point p2){

    double d;
    return d = Math.sqrt(( p2.x - p1.x)*( p2.x - p1.x) + (p2.y - p1.y)*( p2.y - p1.y));
  }

  //класс для координат точки на плоскости
  public static class Point {

     double x, y;

    //конструктор
    public Point(double x, double y) {
      this.x=x;
      this.y=y;
    }
  }
}
