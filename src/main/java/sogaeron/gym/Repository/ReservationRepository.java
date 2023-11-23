package sogaeron.gym.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sogaeron.gym.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.Date;
import java.util.List;

/**
 * DB의 예약 정보 테이블에 접근하여 데이터를 조작하는 클래스
 */
public interface ReservationRepository extends JpaRepository<Reservation,Long> {


}
