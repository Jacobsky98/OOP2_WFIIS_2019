public class Stos<T>{

    class Element<T>{
     private T value;
     private Element<T> next;
     
     Element(T val, Element<T> nextt){
       value = val;
       next = nextt;
     }

     public void setValue(T val){
       value = val;
     }
     public void setNext(Element<T> nextt){
       next = nextt;
     }
     public T getValue(){
       return value;
     }
     public Element<T> getNext(){
       return next;
     }
    }
     private Element<T> el;

      Stos(){
        el = null;
      }
      public void push(T val)
      {
        if(el != null)
        {
          Element<T> tmp = new Element<T>(val, el);
          el = tmp;
        }
        else
        {
          el = new Element<T>(val, null);
        }
      }
      public void pop()
      {
          if(el == null)
          {
              return;
          }
          else{
              el = el.getNext();
          }

      }
      public String toString(){
        String toRet = "";
        Element<T> tmp = el;
        while(tmp != null)
        {
          toRet += "{" + tmp.getValue() + "} ";
          tmp = tmp.getNext();
        }
        return toRet;
      }
   }

