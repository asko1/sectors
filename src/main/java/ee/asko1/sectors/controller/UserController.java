package ee.asko1.sectors.controller;

import ee.asko1.sectors.Entity.AppUser;
import ee.asko1.sectors.db.LoadDatabase;
import ee.asko1.sectors.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    private final UserRepository userRepository;
    UserController(UserRepository userRepository) {this.userRepository = userRepository;}

    @GetMapping("appuser/{id}")
    public AppUser getUsers(@PathVariable UUID id) {
        return userRepository.findById(id).get();
    }

    @PostMapping("appuser")
    public AppUser postUser(@RequestBody AppUser newUser) {
        return userRepository.save(newUser);
    }

    @PutMapping("appuser")
    public AppUser putUser(@PathVariable UUID id, @RequestBody AppUser newUser) {
        userRepository.findById(id).map(user -> {
            user.setName(newUser.getName());
            user.setInvolvedSectors(newUser.getInvolvedSectors());
            return userRepository.save(user);
        });
        return null;
    }
}
