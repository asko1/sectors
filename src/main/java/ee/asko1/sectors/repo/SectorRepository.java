package ee.asko1.sectors.repo;

import ee.asko1.sectors.Entity.Sector;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection"})
@Transactional
public interface SectorRepository extends JpaRepository<Sector, Integer> {
    @Query(value = "SELECT * FROM SECTORS where PARENT_SECTOR is null", nativeQuery = true)
    Collection<Sector> getAllParentlessSectors();
}
