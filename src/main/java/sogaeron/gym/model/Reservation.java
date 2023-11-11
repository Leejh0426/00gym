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

    @Column(name="reservation_number")
    private int reservationNumber;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="gymstatus_id")
    private GymStatus gymStatus;


}
