import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.Id;

class RepairingDemandBeanKey implements Serializable {
    private String timeOfDemand;
    private AircraftBean aircraft;
}

@Entity
@Table(name = "REPAIRING_DEMAND")
@IdClass(RepairingDemandBeanKey.class)
public class RepairingDemandBean implements Serializable {
    @OneToMany(mappedBy="TIME_OF_DEMAND", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TIME_OF_DEMAND")
    private String timeOfDemand;

    @OneToMany(mappedBy="AIRCRAFT_ID", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name="AIRCRAFT_ID", referencedColumnName="AIRCRAFT_ID")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private AircraftBean aircraft;

    @Column(name="PRIORITY")
    private Integer priority;

    public RepairingDemandBean(Date timeOfDemand, AircraftBean aircraft, Integer priority) {
        this.timeOfDemand = String.valueOf(timeOfDemand);
        this.aircraft = aircraft;
        this.priority = priority;
    }

    public Date getTimeOfDemand() throws ParseException {
        return new SimpleDateFormat("yyyy-mm-dd HH:MM:SS").parse(timeOfDemand);
    }

    public void setTimeOfDemand(Date timeOfDemand) {
        this.timeOfDemand = String.valueOf(timeOfDemand);
    }

    public AircraftBean getAircraft() {
        return aircraft;
    }

    public void setAircraft(AircraftBean aircraft) {
        this.aircraft = aircraft;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
