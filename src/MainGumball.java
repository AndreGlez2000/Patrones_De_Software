public class MainGumball {

    public static void main(String[] args) {
       GumballMachine gumballMachine = new GumballMachine(5);

       gumballMachine.printGumballMachine();

       gumballMachine.insertQuarter();
       gumballMachine.turnCrank();

       gumballMachine.printGumballMachine();

       gumballMachine.insertQuarter();
       gumballMachine.turnCrank();
       gumballMachine.insertQuarter();
       gumballMachine.turnCrank();

       gumballMachine.printGumballMachine();

       gumballMachine.refill(10);
       gumballMachine.printGumballMachine();






    }
}
