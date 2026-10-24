package problem1;

import java.util.ArrayList;
import java.util.Scanner;
public class Shop
{
    public static void main (String[] args)
    {
        ArrayList<Item> cart = new ArrayList();
        Item item;
        String itemName;
        double itemPrice;
        int quantity;
        Scanner scan = new Scanner(System.in);
        String keepShopping = "y";
        do
        {
            System.out.print ("Enter the name of the item: ");
            itemName = scan.nextLine();
            System.out.print ("Enter the unit price: ");
            itemPrice = scan.nextDouble();
            System.out.print ("Enter the quantity: ");
            quantity = scan.nextInt();
// *** create a new item and add it to the cart
            // *** print the contents of the cart object using println
            item = new Item(itemName, itemPrice, quantity);
            cart.add(item);
            double totalPrice = 0;

            for (Item i : cart) {
                System.out.println(i);
                totalPrice += i.getPrice() * i.getQuantity();
            }

            System.out.println("Total price: " + totalPrice + " MAD");

            System.out.print ("Continue shopping (y/n)? ");
            keepShopping = scan.nextLine();
        }
        while (keepShopping.equals("y"));
    }
}
