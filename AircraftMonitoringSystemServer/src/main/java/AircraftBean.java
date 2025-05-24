import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "AIRCRAFT")
public class AircraftBean implements Serializable{
    @OneToMany(mappedBy="AIRCRAFT_ID", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="AIRCARFT_ID")
    private String aircraftID;

    @Column(name="Model")
    private String model;

    @Column(name="TYPE")
    private String type;

    @Column(name="PAYLOAD_CAPACITY")
    private Integer payloadCapacity;

    public AircraftBean(String aircraftID, String model, String type, Integer payloadCapacity) {
        this.aircraftID = aircraftID;
        this.model = model;
        this.type = type;
        this.payloadCapacity = payloadCapacity;
    }

    public String getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(String aircraftID) {
        this.aircraftID = aircraftID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(Integer payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }
}
