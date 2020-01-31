import java.util.*;

public class Lista_Studentow {
    ArrayList<Student> list = new ArrayList<Student>();
    public void add(Student st)
    {
        list.add(st);
    }
    public void add(String imie, String nazwisko, int wiek){
        Student st = new Student();
        st.setImie(imie);
        st.setNazwisko(nazwisko);
        st.setWiek(wiek);
        list.add(st);
    }

    Comparator<Student> sortByName = (Student s1, Student s2) ->
            s1.getImie().compareTo(s2.getImie());
    Comparator<Student> sortBySurname = (Student s1, Student s2) ->
            s1.getNazwisko().compareTo(s2.getNazwisko() );
    Comparator<Student> sortByAge  = (Student s1, Student s2) ->
            s1.getWiek()-(s2.getWiek() );


    public void wypisz_wszystkich(){
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
    public void sort_imie_rosnaca(){
        Collections.sort(list, sortByName);
    }
    public void sort_imie_malejaca(){
        Collections.sort(list, sortByName.reversed());
    }

    public void sort_nazwisko_rosnaca(){
        Collections.sort(list, sortBySurname);
    }
    public void sort_nazwisko_malejaca(){
        Collections.sort(list, sortBySurname.reversed());
    }

    public void sort_wiek_rosnaca(){
        Collections.sort(list, sortByAge);
    }
    public void sort_wiek_malejaca(){
        Collections.sort(list, sortByAge.reversed());
    }
}