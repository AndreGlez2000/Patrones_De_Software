public class SoldOutState implements State{
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("The gumball machine is out of gumballs. Try again later");
    }

    @Override
    public void ejectQuaerter() {
        System.out.println("The gumball machine is sold out, you can't insert a quarter!");
    }

    @Override
    public void turnCrank() {
        System.out.println("The gumball machine is sold out, you can't turn the crank!");
    }

    @Override
    public void dispense() {
        System.out.println("The gumball machine is sold out, it can't dispense anything");
    }

    @Override
    public void refill() {
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }
}
