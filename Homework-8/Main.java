package com.company;

public class Main {

    public static void main(String[] args) {
        User user = new User("Bob", "Dilan", 18, "Dilan@gmail.com", "Password", "user");
        Admin admin = new Admin("Artur", "Dilan", 53, "DilanSenior@gmail.com", "SeniorPassword", "Admin");
        UserService uServ = new UserService();
        AdminService aServ = new AdminService();
        uServ.dataRecording(user);
        aServ.dataRecording(user);
        aServ.dataRecording(admin);
        System.out.println(uServ.checkUser(admin));
        System.out.println(aServ.checkUser(user));

    }
}
