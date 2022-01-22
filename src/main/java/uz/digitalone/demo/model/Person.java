package uz.digitalone.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 255)
    private String firstname;

    @Column(name = "last_name", nullable = false, length = 255)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

}
