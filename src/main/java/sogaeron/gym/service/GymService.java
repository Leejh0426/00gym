package sogaeron.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sogaeron.gym.Repository.GymRepository;
import sogaeron.gym.Repository.GymStatusRepository;
import sogaeron.gym.model.Gym;

import java.util.List;

@Service
public class GymService {

    final
    GymRepository gymRepository;

    final
    GymStatusRepository gymStatusRepository;

    public GymService(GymRepository gymRepository, GymStatusRepository gymStatusRepository) {
        this.gymRepository = gymRepository;
        this.gymStatusRepository = gymStatusRepository;
    }

    public List<Gym> findGym(String location) {
        List<Gym> gyms = gymRepository.findBylocation(location);
        return gyms;

    }

}
