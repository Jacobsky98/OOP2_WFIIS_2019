/**
* Abstrakcyjna klasa Shape, na podstawie ktorej tworzone sa klasy zdefiniowanych ksztaltow
* @author Jakub Salamon
*/
public abstract class Shape
{
	/** Metoda zwracajaca nazwe klasy
	* @return nazwa klasy w ktorej sie znajdujemy
	*/
  public String getName()
  {
    return getClass().getName();
  }

	/** Metoda zwracaja pole powierzchni dla ksztaltu
	* @return pole powierzchni ksztaltu
	*/
  public double area()
  {
    return 0.0;
  }

	/** Metoda zwracaja objetosc dla ksztaltu
	* @return objetosc ksztaltu
	*/
  public double volume()
  {
    return 0.0;
  }

	/** Wypisuje w odpowiednim formacie elementy klasy
	* @return sformatowyny do wypisania obiekt klasy
	*/
  abstract public String toString();

}