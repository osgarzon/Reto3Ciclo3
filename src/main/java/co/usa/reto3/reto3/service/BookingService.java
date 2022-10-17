package co.usa.reto3.reto3.service;

import co.usa.reto3.reto3.model.Booking;
import co.usa.reto3.reto3.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAll(){
        return bookingRepository.getAll();
    }

    public Optional<Booking> getBooking(int id){
        return bookingRepository.getBooking(id);
    }

    public Booking save(Booking boo){
        if (boo.getId()==null){
            return bookingRepository.save(boo);
        }else {
            Optional<Booking> boaux= bookingRepository.getBooking(boo.getId());
            if (boaux.isEmpty()){
                return bookingRepository.save(boo);
            }else {
                return boo;
            }
        }
    }
}
