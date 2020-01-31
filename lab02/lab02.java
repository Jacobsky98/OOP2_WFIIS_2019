/*
Na tablicy napisane są dwa ciągi zer i jedynek. Chcemy teraz w każdym z tych ciągów skreślić niektóre cyfry tak, żeby pozostałe ciągi były takie same oraz były uporządkowane, tj. po pierwszym wystąpieniu jedynki nie może już wystąpić żadne zero (czyli np. 0000111111). Jaki najdłuższy ciąg może pozostać na tablicy? Na wejściu podane są długości obu ciągów oraz same ciągi np:

4 4
0 1 0 1
0 0 1 1

daje wynik:
3
[ bo taki sam ciąg to : 0 1 1 i powstaje on z pierwszego poprzez skreślenie ostatniego 0 oraz z drugiego poprzez skreślenie pierwszego zera]

inny przykład:
5 5
0 1 0 1 1
0 1 1 0 0
daje wynik:
3
[ ciąg: 0 1 1] 
*/

import java.util.Scanner;

public class lab02
{
 public static int pow(int liczba, int potega)
 {
  if(potega == 0)
    return 1;
  int wynik = liczba;
  for(int i = 2; i <= potega; i++)
  {
    wynik *= liczba;
  }
  return wynik;
 }

 public static void sprawdzCiag(int[] tab1, int[] tab2)
 {
    int poprzednie1 = tab1[tab1.length-1];
    int iloscWystapien1_0 = 0;
    int iloscWystapien1_1 = 0;
    for(int i = tab1.length-1; i >= 0; i--) 
    {   
      if(tab1[i] == 1)
        iloscWystapien1_1++;
      else 
        iloscWystapien1_0++;
    }

    int poprzednie2 = tab2[tab2.length-1];
    int iloscWystapien2_0 = 0;
    int iloscWystapien2_1 = 0;
    for(int i = tab2.length-1; i >= 0; i--) 
    {   
      if(tab2[i] == 1)
        iloscWystapien2_1++;
      else 
        iloscWystapien2_0++;
    }
    int dlugosc = 0;
    if(iloscWystapien1_0 > iloscWystapien2_0)
      dlugosc = iloscWystapien2_0;
    else
      dlugosc = iloscWystapien1_0;
    
    int wspolnyPodciag_0 = 0;
    for(int j = (dlugosc-1); j>=0; j--)
    {     
        wspolnyPodciag_0 += pow(2, j-dlugosc+1);
    }

    dlugosc = 0;
    if(iloscWystapien1_1 > iloscWystapien2_1)
      dlugosc = iloscWystapien2_1;
    else
      dlugosc = iloscWystapien1_1;
    
    int wspolnyPodciag_1 = 0;
    for(int j = (dlugosc-1); j>=0; j--)
    {     
        wspolnyPodciag_1 += pow(2, j-dlugosc+1);
    }
    if(wspolnyPodciag_0 > wspolnyPodciag_1)
      System.out.println("daje wynik:\n" + wspolnyPodciag_0);
    else
      System.out.println("daje wynik:\n" + wspolnyPodciag_1);
  
  }

 public static void main(String[] args)
 {
  Scanner in = new Scanner(System.in);
  int dlugosc_ciagu1 = in.nextInt();
  int dlugosc_ciagu2 = in.nextInt();
  int[] tab1 = new int[dlugosc_ciagu1];
  int[] tab2 = new int[dlugosc_ciagu2];

  for(int i = 0; i < dlugosc_ciagu1; i++)
  {
    tab1[i] = in.nextInt();
  }

  for(int i = 0; i < dlugosc_ciagu1; i++)
  {
    tab2[i] = in.nextInt();
  }

  sprawdzCiag(tab1, tab2);
  

 }
}
