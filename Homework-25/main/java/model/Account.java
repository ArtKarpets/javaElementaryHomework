package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "number")
    private String number;
    @Column(name = "value")
    private double value;
    @OneToOne(mappedBy = "account")
    private Client client;
}
