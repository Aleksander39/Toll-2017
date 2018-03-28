package jdev.repositories;

import jdev.dto.IdPointDTO;
import jdev.dto.PointDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  PointDTORepository extends CrudRepository<PointDTO,IdPointDTO>{
    public PointDTO findByAutoIdAndTime(String autoId, long time);
    public List<PointDTO> findByTimeGreaterThan(long time);
    public List<PointDTO> findByAutoIdOrderByTimeDesc(String autoId, Pageable pageable);
}
