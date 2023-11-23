package sogaeron.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gymStatus")
@Getter
@Setter
public class GymStatus {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="gymstatus_id")
    private Long id;

    @Column(name="remainder")
    private int remainder;

    @Column(name="date_time")
    private LocalDateTime dateTime;

    @Column(name="total_number")
    private int totalNumber;  //2023-11-22 카멜케이스로 고침

    @Column(name="cond_value")
    private boolean condValue;


    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="gym_id")
    private Gym gym;

}
