public class Main {
    public static void main(String[] args) {
        int[] keyboard_prices = new int[] {10,9,8,7,6,5,4,3,2,1};
        int[] USB_prices = new int[] {1,2,3,4,5,6,7,8,9,11};
        int budget = 18;
        Budgeter budgeter = new Budgeter();
        int[] combo = budgeter.mostexpensiveCombo(keyboard_prices,USB_prices,budget);
        System.out.println("The cheapest keyboard available is: " + budgeter.getcheap(keyboard_prices));
        System.out.println("The most expensive device available is: " + budgeter.getexpensive(keyboard_prices,USB_prices));
        System.out.println("The most expensive USB device available under budget is: " + budgeter.mostexpensiveDevice(USB_prices, budget));
        System.out.println("The most expensive combo available under budget is: " + combo[0] + " " + combo[1]);

    }
}
