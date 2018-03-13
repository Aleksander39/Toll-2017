package jdev.core.dao.repo;

import jdev.core.dao.Point;
import jdev.dto.PointDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PointRepository extends CrudRepository<Point, Integer> {

}
