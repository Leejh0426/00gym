package sogaeron.gym.Repository;

import sogaeron.gym.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GymRepository extends JpaRepository<Gym,Long> {


    List<Gym> findBylocation(String location);

}
