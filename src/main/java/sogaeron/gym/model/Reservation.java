package sogaeron.gym.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="reservation_id")
    private Long id;

    @Column(name="reservation_date")
    private LocalDateTime reservationDate;

    @Column(name="cond_time")
    private LocalDateTime condTime;

    @Column(name="reservation_number")
    private int reservationNumber;

    @Column(name="cond_value")
    private int condValue;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="gym_id")
    private Gym gym;


}
