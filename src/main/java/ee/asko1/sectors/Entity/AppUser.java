package ee.asko1.sectors.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private Boolean agreedToTerms;
    @ManyToMany
    @JoinTable(
            name = "involvedSectors",
            joinColumns = @JoinColumn(name = "appuser_id"),
            inverseJoinColumns = @JoinColumn(name = "sector_id")
    )
    @JsonIgnoreProperties("subsectors")
    private List<Sector> involvedSectors;

    public AppUser(UUID id, String name, Boolean agreedToTerms, List<Sector> involvedSectors) {
        this.id = id;
        this.name = name;
        this.agreedToTerms = agreedToTerms;
        this.involvedSectors = involvedSectors;
    }
    public AppUser(String name, Boolean agreedToTerms) {
        this.name = name;
        this.agreedToTerms = agreedToTerms;
    }

    public AppUser() {}
}
