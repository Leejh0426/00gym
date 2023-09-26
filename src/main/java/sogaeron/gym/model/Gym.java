package sogaeron.gym.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gym")
public class Gym {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="gym_id")
    private int id;


    private String location;

    private String gym_name;

    private int total_number;




}
