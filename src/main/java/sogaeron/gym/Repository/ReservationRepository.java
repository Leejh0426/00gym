package sogaeron.gym.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sogaeron.gym.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {


    @Query("SELECT r FROM Reservation r WHERE r.condTime >= :start AND r.condTime <= :end")
    List<Reservation> findCondTimeBetween(@Param("start")LocalDateTime start,@Param("end")LocalDateTime end);

    /**
     * 아두이누에서 보내준 id값 이 일치하면서 condValue가 1이면 그것을 뽑아낸다.
     */
    Reservation findByIdAndCondValue(Long id,int value);

    /**
     * 이렇게도 된다는거 확인
     */
    //Reservation findByIdAndCondTimeBetween(Long id, LocalDateTime localDateTime, LocalDateTime localDateTime1);
}
