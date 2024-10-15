import java.rmi.*;
import java.rmi.server.*;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
    private static final long serialVersionUID = 2L;
    String location;

    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;
    int count = 0;


    public GumballMachine(String location, int numberOfGumballs) throws RemoteException {
        this.location = location;

        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.count = numberOfGumballs;
        if (numberOfGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void printGumballMachine() {
        System.out.println();
        System.out.println("Gumball Machine #2024");
        System.out.println("Inventory: " + getCount() + " gumballs.");
        if (state == hasQuarterState) {
            System.out.println("The machine has a quarter.");
            System.out.println();
        } else if (state == noQuarterState) {
            System.out.println("The machine is expecting a quarter.");
            System.out.println();
        } else if (state == soldState) {
            System.out.println("The machine is giving a gumball...");
            System.out.println();
        } else if (state == soldOutState) {
            System.out.println("The machine is out of gumballs.");
            System.out.println();
        }

    }

    public void insertQuarter() {
        state.insertQuarter();
    }
    public void ejectQuarter() {
        state.ejectQuaerter();
    }
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            count -= 1;
        }
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }
    public State getNoQuarterState() {
        return noQuarterState;
    }
    public State getSoldOutState() {
        return soldOutState;
    }
    public State getSoldState() {
        return soldState;
    }
    public State getWinnerState() {
        return winnerState;
    }
    public int getCount() {
        return count;
    }

    public void refill(int count) {
        this.count += count;
        System.out.println("The gumball machine was just refilled; its new count is: " + this.count);
        state.refill();
    }

    //proxy
    public String getLocation() {
        return location;
    }

    public State getState() {
        return state;
    }


}
