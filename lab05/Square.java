public class Square extends Point
{
	// dlugosc boku kwadratu
	double side;
	
		/** Konstruktor tworzacy kwadrat zapisujacy wartosci x oraz y w skladnikach dziedziczonych z klasy Point
	* @param depth bok szescianu
	* @param x wspolrzedna wierzcholka x szescianu
	* @param y wspolrzedna wierzcholka y szescianu
	*/
  Square(double side, double x, double y)
  {
    super(x, y);
    this.side = side;
  }

	/** Wypisuje w odpowiednim formacie elementy klasy
	* @return sformatowyny do wypisania obiekt klasy
	*/
  public String toString()
  {
    return "Corner = " + super.toString() + "; side = " + Double.toString(side);
  }

	/** Metoda liczaca pole powierzchni kwadratu
	* @return pole powierzchni kwadratu
	*/
  public double area()
  {
    return side*side;
  }


}