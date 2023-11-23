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
/**
 * DB 풋살장 정보 테이블과 매칭될 클래스
 */
public class Gym {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="gym_id")
    private Long id;

    @Column(name="location", nullable = false, length = 20)
    private String location;

    @Column(name="gym_name", nullable = false, length=30)
    private String gymName;

    @Column(name="total_number", nullable = false)
    private int totalNumber;




}
