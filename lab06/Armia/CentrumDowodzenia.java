package Armia;

import Armia.Czolg;
import java.util.ArrayList;

public class CentrumDowodzenia {
  private ArrayList<Czolg> czolgi;

  public CentrumDowodzenia() {
    czolgi = new ArrayList<Czolg>();
  }

  public void zarejestrujCzolg(Czolg czolg) {
    czolgi.add(czolg);
  }

  public void wydajRozkaz(String number, Rozkaz rozkaz) {
    czolgi.get(Integer.parseInt(number) - 1).dodajRozkaz(rozkaz);
  }

  public String toString() {
    String napis = "Do tej pory centrum dowodzenia wyslalo nastepujace rozkazy:\n";
    for (int i = 0; i < czolgi.size(); i++) {
      napis += "Czolg nr " + (i + 1) + " otrzymal rozkazy: \n" + czolgi.get(i).wypiszWszystkieRozkazy() + "\n";
    }
    return napis;
  }
}