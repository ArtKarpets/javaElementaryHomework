package entity;


import lombok.Data;

@Data
public class Client {
    private int id;
    private String name;
    private String email;
    private String phone;
    private int age;
    private String about;

}
