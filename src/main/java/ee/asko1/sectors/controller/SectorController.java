package ee.asko1.sectors.controller;

import ee.asko1.sectors.Entity.Sector;
import ee.asko1.sectors.repo.SectorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SectorController {
    private final SectorRepository sectorRepository;

    SectorController(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    @GetMapping("sectors")
    public List<Sector> getSectors() {
        return sectorRepository.getAllParentlessSectors().stream().toList();
    }
}
