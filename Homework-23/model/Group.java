package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "groups")
@Data
@NoArgsConstructor

public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "group_number")
    private String groupNumb;
    @Column(name = "task_number")
    private String taskNumb;
    @ManyToMany(mappedBy = "groups")
    private Set<Client> client;

}
