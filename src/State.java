import java.io.*;

public interface State extends Serializable {
    void insertQuarter();
    void ejectQuaerter();
    void turnCrank();
    void dispense();
    void refill();
}
