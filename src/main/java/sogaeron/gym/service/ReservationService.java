package sogaeron.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogaeron.gym.Repository.GymRepository;
import sogaeron.gym.Repository.GymStatusRepository;
import sogaeron.gym.Repository.ReservationRepository;
import sogaeron.gym.controller.DTO.ReservationDTO;
import sogaeron.gym.controller.DTO.CheckReservationDTO;
import sogaeron.gym.model.GymStatus;
import sogaeron.gym.model.Reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.time.LocalTime.now;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    GymRepository gymRepository;
    @Autowired
    GymStatusRepository gymStatusRepository;



    @Transactional
    public String doreservation(ReservationDTO reservationDTO) {
        Long gymStatusId = reservationDTO.getGymStatusId();
        int reservationNumber = reservationDTO.getReservationNumber();

        Optional<GymStatus> optionalGymStatus = gymStatusRepository.findById(gymStatusId);
        GymStatus gymStatus = optionalGymStatus.get();
        if(gymStatus.getRemainder()-reservationNumber<0){
            return "실패";
        }
        else {
            gymStatus.setRemainder(gymStatus.getRemainder() - reservationNumber);
        }


        Reservation reservation = new Reservation();
        reservation.setReservationNumber(reservationDTO.getReservationNumber());
        reservation.setReservationDate(LocalDateTime.now());
        reservation.setGymStatus(gymStatus);


        reservationRepository.save(reservation);

        return "성공";
    }

    @Transactional
    public List<CheckReservationDTO> checkReservation() {
        List<Reservation> allReservation = reservationRepository.findAll();
        List<CheckReservationDTO> checkReservationDTOS = new ArrayList<>();

        for(int i=0;i< allReservation.size();i++){
            CheckReservationDTO checkReservationDTO = new CheckReservationDTO();
            Reservation reservation = allReservation.get(i);
            checkReservationDTO.setReservationId(reservation.getId());
            checkReservationDTO.setReservationDate(reservation.getReservationDate());
            checkReservationDTO.setReservationNumber(reservation.getReservationNumber());
            checkReservationDTO.setDateTime(reservation.getGymStatus().getDateTime());

            checkReservationDTOS.add(checkReservationDTO);
        }
        return checkReservationDTOS;
    }

    @Transactional
    public void deleteReservation(Long reservationId) {
        Optional<Reservation> Opreservation = reservationRepository.findById(reservationId);
        Reservation reservation = Opreservation.get();

        // 예약이 취소됨으로 인해 gymstatus 값들 다시 복구
        GymStatus gymStatus = reservation.getGymStatus();
        if(gymStatus.getRemainder()+reservation.getReservationNumber() == gymStatus.getTotalNumber())
            gymStatus.setCondValue(false);
        gymStatus.setRemainder(gymStatus.getRemainder()+reservation.getReservationNumber());


        reservationRepository.delete(reservation);
    }


    /*
    @Transactional
    public void testreservation(TestReservationDTO testReservationDTO) {


        Reservation reservation = new Reservation();

        System.out.println(testReservationDTO.getGymId());

        Optional<Gym> gym = gymRepository.findById(testReservationDTO.getGymId());
        Optional<User> user = userRepository.findById(testReservationDTO.getUserId());

        reservation.setReservationNumber(testReservationDTO.getReservationNumber());
        reservation.setReservationDate(testReservationDTO.getReservationDate());
        reservation.setUser(user.get());
        reservation.setGym(gym.get());
        reservation.setCondTime(testReservationDTO.getCondTime());
        reservation.setCondValue(0);

        reservationRepository.save(reservation);

    }

     */
}
