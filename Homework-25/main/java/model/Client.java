package model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private int phone;
    @Column(name = "age")
    private String age;
    @Column(name = "about")
    private String about;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToMany
    @JoinTable(
            name = "client_group",
            joinColumns = {@JoinColumn(name = "client_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")})
    private Set<Group> groups;
}
