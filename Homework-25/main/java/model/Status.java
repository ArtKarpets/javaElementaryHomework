package model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "statuses")
@Data
@NoArgsConstructor
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "alias")
    private String alias;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "status",fetch = FetchType.EAGER)
    private Set<Client> client;

}
