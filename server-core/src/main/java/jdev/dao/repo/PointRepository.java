package jdev.dao.repo;

import jdev.dao.Point;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PointRepository extends CrudRepository<Point, Integer> {
    @Query("SELECT p FROM Point p WHERE p.time >= (:currentTime - :time) AND p.car.idCar LIKE :autoId")
    public Iterable<Point> filterByTime(@Param("autoId") String autoId,
                                        @Param("time") long time,
                                        @Param("currentTime") long currentTime);
}
