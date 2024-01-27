package ee.asko1.sectors.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Transactional
@Table(name = "sectors")
public class Sector {
    @Id
    private Integer id;

    @Column(nullable = false)
    private String sectorName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parentSector")
    @JsonIgnore
    private Sector parentSector;

    @OneToMany(mappedBy = "parentSector")
    @JsonIgnoreProperties("parentSector")
    @Fetch(FetchMode.SUBSELECT)
    private List<Sector> subsectors = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "involvedSectors")
    private List<AppUser> involvedAppUsers = new ArrayList<>();

    public Sector(Integer id, String sectorName,  Sector parentSector, List<Sector> subsectors) {
        this.id = id;
        this.sectorName = sectorName;
        this.parentSector = parentSector;
        this.subsectors = subsectors;

    }

    public Sector (Integer id, String sectorName) {
        this(id, sectorName, null, null);
    }

    public Sector (Integer id, String sectorName, List<Sector> subsectors) { this(id, sectorName, null, subsectors);}

    public Sector() {

    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Sector sector = (Sector) o;
        return getId() != null && Objects.equals(getId(), sector.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}