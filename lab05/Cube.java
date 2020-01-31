/**
* Klasa Cube dziedziczaca po klasie Square
* @author Jakub Salamon
*/
public class Cube extends Square
{
	// wysokosc szescianu, reszta parametrow jest zapisywana w skladnikach dziedziczonych z klasy Square
	double depth;
	
	/** Konstruktor tworzacy szescian zapisujacy wartosci depth jako bok,
	*   x oraz y jako wierzcholki w skladnikach dziedziczonych z klasy Square
	* @param depth wysokosc szescianu
	* @param x wspolrzedna wierzcholka x szescianu
	* @param y wspolrzedna wierzcholka y szescianu
	*/
  Cube(double depth, double x, double y)
  {
    super(depth, x, y);
    this.depth = depth;
  }

	/** Wypisuje w odpowiednim formacie elementy klasy
	* @return sformatowyny do wypisania obiekt klasy
	*/
  public String toString()
  {
    return super.toString() + "; depth = " + Double.toString(depth);
  }

	/** Metoda liczaca pole powierzchni szczescianu
	* @return pole powierzchni szescianu
	*/
  public double area()
  {
    return super.area() * 6.0;
  }
	
	
	/** Metoda liczca objetosc szescianu
	* @return pole objetosc szescianu
	*/
  public double volume()
  {
    return super.side * super.side * depth;
  }

 
}