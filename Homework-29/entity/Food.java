package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Food {
    private String name;

    public String getName() {
        return name;
    }

    public static String howeDelicious(String food) {
        return food + "its yummi";
    }
}
