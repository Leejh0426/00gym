package sogaeron.gym.Repository;

import sogaeron.gym.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym,Long> {
}
