package ohjelmistoprojekti.ticketGuru.Classes;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
    Event findByEvent(String event);
}