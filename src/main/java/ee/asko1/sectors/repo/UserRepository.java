package ee.asko1.sectors.repo;

import ee.asko1.sectors.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<AppUser, UUID> {}
