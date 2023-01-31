package spice.tech.hub.alannoorrestaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spice.tech.hub.alannoorrestaurant.models.Owners;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerRepo extends JpaRepository<Owners,Integer> {
    @Query(value = "select * from owners where owner_name=?1", nativeQuery = true)
    List<Owners> getOwnerByName(String name);

    @Query("select ow from Owners ow where ow.ownerName=?1")
    List<Owners> getOwnersByNameJPQL(String name);
}
