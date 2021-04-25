package deadlock;

import lombok.Data;

@Data
public class SomeDeadClassTwo {
    private SomeDeadClassOne someDeadClassOne;

    public synchronized String someDeadMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return someDeadClassOne.someDeadMethod();
    }
}
