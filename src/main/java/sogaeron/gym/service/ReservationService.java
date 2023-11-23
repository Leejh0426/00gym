package sogaeron.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogaeron.gym.Repository.GymRepository;
import sogaeron.gym.Repository.GymStatusRepository;
import sogaeron.gym.Repository.ReservationRepository;
import sogaeron.gym.apiPayload.code.status.ErrorStatus;
import sogaeron.gym.apiPayload.exception.handler.ErrorHandler;
import sogaeron.gym.controller.DTO.ReservationDTO;
import sogaeron.gym.controller.DTO.CheckReservationDTO;
import sogaeron.gym.model.GymStatus;
import sogaeron.gym.model.Reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.time.LocalTime.now;

/**
 * 예약 정보 관련 비즈니스 로직을 처리하는 클래스
 */
@Service
public class ReservationService {

    /**
     * 의존성 주입
     */
    final
    ReservationRepository reservationRepository;
    final
    GymRepository gymRepository;
    final
    GymStatusRepository gymStatusRepository;

    public ReservationService(ReservationRepository reservationRepository, GymRepository gymRepository, GymStatusRepository gymStatusRepository) {
        this.reservationRepository = reservationRepository;
        this.gymRepository = gymRepository;
        this.gymStatusRepository = gymStatusRepository;
    }


    /**
     * 예외처리) 예약인원이 남은인원을 초과하는지 확인한다.
     */
    @Transactional
    public void CheckReservationNumber(ReservationDTO reservationDTO){
        Long gymStatusId = reservationDTO.getGymStatusId();
        GymStatus gymStatus = gymStatusRepository.findById(gymStatusId).get();

        if(gymStatus.getRemainder()<reservationDTO.getReservationNumber()){
            throw new ErrorHandler(ErrorStatus._RESERVATIONNUMBER_NOT_EXCEED_REMAINDER);
        }
    }

    /**
     * 예외처리) reservation_id 가 유효한지 확인한다.
     */
    @Transactional
    public void CheckReservationId(Long id){
        if(reservationRepository.findById(id).isEmpty()){
            throw new ErrorHandler(ErrorStatus._Reservation_ID_NOT_FOUND);
        }
    }


    /**
     * GymStatus_Id와 reservaiton Number를 이용하여 조건 확인 후 데이터베이스에 예약을 저장한다.
     */
    @Transactional
    public String doreservation(ReservationDTO reservationDTO) {
        Long gymStatusId = reservationDTO.getGymStatusId();
        int reservationNumber = reservationDTO.getReservationNumber();

        Optional<GymStatus> optionalGymStatus = gymStatusRepository.findById(gymStatusId);
        GymStatus gymStatus = optionalGymStatus.get();
      //  if(gymStatus.getRemainder()-reservationNumber<0){
      //      return "실패";
      //  }
      //  else {
            gymStatus.setRemainder(gymStatus.getRemainder() - reservationNumber);
       // }

        Reservation reservation = new Reservation();
        reservation.setReservationNumber(reservationDTO.getReservationNumber());
        reservation.setReservationDate(LocalDateTime.now());
        reservation.setGymStatus(gymStatus);

        reservationRepository.save(reservation);
        return "성공";
    }

    /**
     * 유저가 한명 있다고 가정하였으므로 예약테이블의 모든 예약을 조회한다.
     */
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


    /**
     * reservation_id를 이용하여 예약을 삭제하고 예약된 인원값만큼 남은인원에 더해준다.(예약을 삭제했으니깐)
     */
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


}
