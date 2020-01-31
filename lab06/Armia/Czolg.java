package Armia;

import java.util.ArrayList;

public class Czolg {
  private ArrayList<Rozkaz> rozkazy;

  public Czolg() {
    rozkazy = new ArrayList<Rozkaz>();
  }

  public void dodajRozkaz(Rozkaz rozkaz) {
    rozkazy.add(rozkaz);
  }

  public String wypiszWszystkieRozkazy() {
    String napis = "";
    for (int i = 0; i < rozkazy.size(); i++) {
      napis += rozkazy.get(i).getRozkaz() + "\n";
    }
    return napis;
  }

  public String ostatniRozkaz() {
    return "Ostatni rozkaz do mnie: " + rozkazy.get(rozkazy.size() - 1).getRozkaz();
  }
}