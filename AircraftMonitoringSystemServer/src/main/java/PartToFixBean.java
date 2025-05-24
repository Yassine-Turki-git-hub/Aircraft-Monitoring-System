import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.Id;

class PartToFixBeanKey implements Serializable {
    private RepairingDemandBean repairingDemand;
    private String part;
}

@Entity
@Table(name = "PARTS_TO_FIX")
@IdClass(PartToFixBeanKey.class)
public class PartToFixBean implements Serializable{

    @ManyToOne
    @JoinColumn(name="TIME_OF_DEMAND", referencedColumnName="TIME_OF_DEMAND")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private RepairingDemandBean repairingDemand;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PART")
    private String part;

    @Column(name="APPROXIMATE_COST")
    private Double approximateCost;

    PartToFixBean(RepairingDemandBean repairingDemand, Double approximateCost) {
        this.repairingDemand = repairingDemand;
        this.approximateCost = approximateCost;
    }

    public RepairingDemandBean getRepairingDemand() {
        return repairingDemand;
    }

    public String getPart() {
        return part;
    }

    public double getApproximateCost() {
        return approximateCost;
    }

    public void setRepairingDemand(RepairingDemandBean repairingDemand) {
        this.repairingDemand = repairingDemand;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public void setApproximateCost(Double approximateCost) {
        this.approximateCost = approximateCost;
    }
}