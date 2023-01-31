package spice.tech.hub.alannoorrestaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spice.tech.hub.alannoorrestaurant.models.Students;

@Repository
public interface StudentRepo extends JpaRepository<Students,Integer> {
}
