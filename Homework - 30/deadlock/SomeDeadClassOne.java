package deadlock;

import lombok.Data;

@Data
public class SomeDeadClassOne {
    private SomeDeadClassTwo someDeadClassTwo;

    public synchronized String someDeadMethod() {
        return someDeadClassTwo.someDeadMethod();
    }
}
