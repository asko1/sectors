package ee.asko1.sectors.db;

import ee.asko1.sectors.Entity.Sector;
import ee.asko1.sectors.repo.SectorRepository;
import jakarta.transaction.Transactional;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initSectorDatabase(SectorRepository sectorRepository) {
        return args -> {

            /*
            Builds the database from the given JSON file
            See index.html's comments for how to get one such JSON file


            InputStream file = LoadDatabase.class.getResourceAsStream("/sectors.json");
            assert file != null;
            JSONTokener tokener = new JSONTokener(file);
            JSONArray array = new JSONArray(tokener);
            List<Sector> results = new ArrayList<>();
            for (Object object : array) {
                JSONObject jsonObject = new JSONObject(object.toString());
                Sector sector = new Sector( (Integer) jsonObject.getInt("id"), jsonObject.getString("name"));
                results.add(sector);
            }

            sectorRepository.saveAll(results);
            log.info(sectorRepository.findAll().toString());


            log.info(String.valueOf(array.get(1)));
            for (Object object: array) {
                JSONObject jsonObject = new JSONObject(object.toString());
                int objectId = jsonObject.getInt("id");
                //log.info(objectId);

                if (jsonObject.has("parent")) {
                    int objectParent = jsonObject.getInt("parent");
                    var sector = sectorRepository.getReferenceById(objectId);
                    var parent = sectorRepository.getReferenceById(objectParent);
                    sector.setParentSector(parent);
                    sectorRepository.save(sector);
                }
            }
            List<Sector> sectors = sectorRepository.findAll();
            log.info(String.valueOf(sectors));

            /*results.forEach(result -> {
                var test = sectorRepository.getReferenceById(result.getId());
                //log.info(String.valueOf(test));
                log.info(String.valueOf(result.getParentSector()));
                if (result.getParentSector() != null) {
                    //var parent = sectorRepository.getReferenceById(result.getParentSector())
                    log.info(String.valueOf(result.getParentSector()));
                }
            });*/
        };
    }
}