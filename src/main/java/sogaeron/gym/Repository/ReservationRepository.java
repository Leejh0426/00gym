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


    Reservation findByIdAndCondValue(Long id,int value);
}
