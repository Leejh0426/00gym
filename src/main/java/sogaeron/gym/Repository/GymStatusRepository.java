package sogaeron.gym.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sogaeron.gym.model.GymStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface GymStatusRepository extends JpaRepository<GymStatus,Long> {
    @Query("SELECT g FROM GymStatus g WHERE g.gym.id=:id And g.dateTime > :start AND g.dateTime < :end")
    List<GymStatus> findByGym_IdAndDateTime(Long id, LocalDateTime start,LocalDateTime end);

    //    @Query("SELECT r FROM Reservation r WHERE r.condTime >= :start AND r.condTime <= :end")
    //   List<Reservation> findCondTimeBetween(@Param("start")LocalDateTime start,@Param("end")LocalDateTime end);

    /**
     * 아두이누에서 보내준 id값 이 일치하면서 condValue가 1이면 그것을 뽑아낸다.
     */
    List<GymStatus> findByGym_IdAndCondValue(Long id,boolean value);
}
