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

    @Column(name="location")
    private String location;

    @Column(name="gym_name")
    private String gym_name;

    @Column(name="total_number")
    private int total_number;




}
