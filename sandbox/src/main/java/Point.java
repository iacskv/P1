

/**
 * Created by Константин on 12.03.2017.
 */
public class Point {
  double x, y;

  //конструктор
  public Point(double x, double y) {
    this.x=x;
    this.y=y;
  }
  //функция расчета расстояния между точками от "первой" точки до новой
  public double distance (Point p1){

    return Math.sqrt(( this.x - p1.x)*( this.x - p1.x) + (this.y - p1.y)*( this.y - p1.y));

  }
}
