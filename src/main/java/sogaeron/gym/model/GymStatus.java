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
/**
 * DB 시간대 별 풋살장 현황 테이블과 매칭될 클래스 
 */
public class GymStatus {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="gymstatus_id")
    private Long id;

    @Column(name="remainder", nullable = false)
    private int remainder;

    @Column(name="date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name="total_number", nullable = false)
    private int totalNumber;  //2023-11-22 카멜케이스로 고침

    @Column(name="cond_value" ,nullable=false,columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean condValue;


    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="gym_id")
    private Gym gym;

}
