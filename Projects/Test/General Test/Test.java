public class Test {
  public static void main(String[] theArgs) {
     
     int a = 5;
     int b = 10;
     int c = b;
     
     a = a++;
     b = b--;
     c = c + a;
     
     System.out.println(a);
     System.out.println(b);
     System.out.println(c);     
   }
}