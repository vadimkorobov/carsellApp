package edu.vadimkorobov.carsell.repository;

import edu.vadimkorobov.carsell.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    @Query("delete from Car c where c.id= :id")
    void delete(@Param("id") long id);

    @Query("select c from Car c where c.id = :id")
    Car findById (@Param("id") long id);

    @Query("select c from Car c where c.model = :model")
    Car findByModelAndPrice (@Param("model") String model);
}
