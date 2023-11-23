package sogaeron.gym.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gym")
@Getter
@Setter
public class Gym {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="gym_id")
    private Long id;

    @Column(name="location")
    private String location;

    @Column(name="gym_name")
    private String gymName;

    @Column(name="total_number")
    private int totalNumber;




}
