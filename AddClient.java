
import java.io.FileWriter;
import java.io.PrintWriter;
import java.rmi.*;

public class AddClient {
  public static void main(String args[]) {
    try (FileWriter fileWriter = new FileWriter("output.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter)) {
      String addServerURL = "rmi://" + args[0] + "/AddServer";
      AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup(addServerURL);

      System.out.println("The first number is: " + args[1]);
      double d1 = Double.valueOf(args[1]).doubleValue();

      System.out.println("The second number is: " + args[2]);
      double d2 = Double.valueOf(args[2]).doubleValue();

      System.out.println("The third number is: " + args[3]);
      double d3 = Double.valueOf(args[3]).doubleValue();

      System.out.println("The area of our rectangle is: " + addServerIntf.rectangle(d1, d2));

      System.out.println("The area of our circle is: " + addServerIntf.circle(d1));

      System.out.println("The area of our trapezoid is: " + addServerIntf.trapezoid(d1, d2, d3));

      System.out.println("The area of our triangle is: " + addServerIntf.triangle(d1, d2)); // added by Luis Irizarry

      printWriter.println("The area of our rectangle is: " + addServerIntf.rectangle(d1, d2));
      
      printWriter.println("The area of our circle is: " + addServerIntf.circle(d1));
      
      printWriter.println("The area of our trapezoid is: " + addServerIntf.trapezoid(d1, d2, d3));
      
      printWriter.println("The area of our triangle is: " + addServerIntf.triangle(d1, d2)); // added by Luis Irizarry

    } catch (Exception e) {
      System.out.println("Exception: " + e);
    }
  }
}