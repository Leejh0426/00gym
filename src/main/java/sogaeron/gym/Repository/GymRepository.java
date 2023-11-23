package sogaeron.gym.Repository;

import sogaeron.gym.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * DB의 풋살장 정보 테이블에 접근하여 데이터를 조작하는 클래스
 */
public interface GymRepository extends JpaRepository<Gym,Long> {


    List<Gym> findBylocation(String location);

}
