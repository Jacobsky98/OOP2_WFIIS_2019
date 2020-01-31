import java.util.Scanner;

public class lab7 {

  // zwraca numer indeksu wartosci var w pierwszym wierszu tabeli tab
  public static int index1Row(int tab[][], int var, int n) {
    for (int i = 0; i < n; i++) {
      if (var == tab[0][i])
        return i;
    }
    return -1;
  }

  public static boolean test(int n, int m, int tab[][]) {
    boolean[][] checkTab;
    checkTab = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        checkTab[i][j] = false;
      }
      checkTab[i][i] = true;
    }

    for (int nrTest = 0; nrTest < m; nrTest++) {
      for (int el = 0; el < n; el++) {
        int indexEl = index1Row(tab, tab[nrTest][el], n);

        if ((el < n / 2) && (indexEl >= 0)) {
          for (int k = n / 2; k < n; k++) {
            int indexDrugaStrona = index1Row(tab, tab[nrTest][k], n);
            if (indexDrugaStrona >= 0)
              checkTab[indexEl][indexDrugaStrona] = true;
          }
        }

        else if (indexEl >= 0) {
          for (int k = 0; k < n / 2; k++) {
            int indexDrugaStrona = index1Row(tab, tab[nrTest][k], n);
            if (indexDrugaStrona >= 0)
              checkTab[indexEl][indexDrugaStrona] = true;
          }
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!checkTab[i][j])
          return false;
      }
    }
    return true;
  }

  public static void main(String[] argv) {
    System.out.println("Podaj ilosc elementow i liczbe testow, a nastepnie uzupelnij wszystkie wiersze\n");
    int n = 0;
    int m = 0;
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    m = scan.nextInt();
    int[][] tab;
    tab = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        tab[i][j] = scan.nextInt();
      }
    }
    System.out.println("INSERT OK\n\nWYNIK TESTU");
    if (test(n, m, tab))
      System.out.println("TAK");
    else
      System.out.println("NIE");

    scan.close();

  }
}