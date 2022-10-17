package co.usa.reto3.reto3.repository;

import co.usa.reto3.reto3.model.Booking;
import co.usa.reto3.reto3.repository.crud.BookingCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class BookingRepository {

    @Autowired
    private BookingCrudRepository bookingCrudRepository;

    public List<Booking> getAll(){
        return (List<Booking>) bookingCrudRepository.findAll();
    }

    public Optional<Booking> getBooking(int id){
        return bookingCrudRepository.findById(id);
    }

    public Booking save(Booking boo){
        return bookingCrudRepository.save(boo);
    }
}
