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






    /**
     * 이렇게도 된다는거 확인
     */
    //Reservation findByIdAndCondTimeBetween(Long id, LocalDateTime localDateTime, LocalDateTime localDateTime1);
}
