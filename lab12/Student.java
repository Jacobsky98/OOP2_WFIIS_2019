import java.util.*; 

public class Student{
    private String imie;
    private String nazwisko;
    private int wiek;

    public void setImie(String imie_) { imie = imie_; }
    public void setNazwisko(String nazwisko_) { nazwisko = nazwisko_; }
    public void setWiek(int wiek_) { wiek = wiek_; }
    public String getImie() { return imie; }
    public String getNazwisko() { return nazwisko; }
    public int getWiek() { return wiek; }

    public String toString(){
        return getImie() + " " + getNazwisko() + " " + getWiek();
    }
}
