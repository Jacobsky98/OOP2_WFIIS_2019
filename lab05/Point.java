/**
* Klasa Point dziedziczaca po klasie Shape
* @author Jakub Salamon
*/
public class Point extends Shape
{
	double x; // wspolrzedna x punktu
  double y; // wspolrzedna y punktu
  
	
	/** Konstruktor tworzacy punkt
	* @param x wspolrzedna wierzcholka x
	* @param y wspolrzedna wierzcholka y
	*/
  Point(double x, double y)
  {
    this.x = x;
    this.y = y;
  }


	/** Wypisuje w odpowiednim formacie elementy klasy
	* @return sformatowyny do wypisania obiekt klasy
	*/
  public String toString()
  {
    return "[" + Double.toString(x) + ", " + Double.toString(y) + "]";
  }


}