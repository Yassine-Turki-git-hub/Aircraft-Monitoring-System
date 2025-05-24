import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.Id;

class StatusLogBeanKey implements Serializable {
    private AircraftBean aircraft;
    private String timeOfLog;
}

@Entity
@Table(name="STATUS_LOGS")
@IdClass(StatusLogBeanKey.class)
public class StatusLogBean implements Serializable{

    @ManyToOne
    @JoinColumn(name="AIRCRAFT_ID", referencedColumnName="AIRCRAFT_ID")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private AircraftBean aircraft;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TIME_OF_LOG")
    private String timeOfLog;

    @Column(name="FUSELAGE_STATUS")
    private Integer fuselageStatus;

    @Column(name="RIGHT_WING_STATUS")
    private Integer rightWingStatus;

    @Column(name="LEFT_WING_STATUS")
    private Integer leftWingStatus;

    @Column(name="TAIL_STATUS")
    private Integer tailStatus;

    @Column(name="RIGHT_ENGINE_STATUS")
    private Integer rightEngineStatus;

    @Column(name="LEFT_ENGINE_STATUS")
    private Integer leftEngineStatus;

    @Column(name="PROBLEMS")
    private String problems;

    public StatusLogBean(AircraftBean aircraft, Date timeOfLog, Integer fuselageStatus, Integer rightWingStatus, Integer leftWingStatus, Integer tailStatus, Integer rightEngineStatus, Integer leftEngineStatus, String problems) {
        this.aircraft = aircraft;
        this.timeOfLog = String.valueOf(timeOfLog);
        this.fuselageStatus = fuselageStatus;
        this.rightWingStatus = rightWingStatus;
        this.leftWingStatus = leftWingStatus;
        this.tailStatus = tailStatus;
        this.rightEngineStatus = rightEngineStatus;
        this.leftEngineStatus = leftEngineStatus;
        this.problems = problems;
    }

    public AircraftBean getAircraft() {
        return aircraft;
    }

    public void setAircraft(AircraftBean aircraft) {
        this.aircraft = aircraft;
    }

    public Date getTimeOfLog() throws ParseException {
        return new SimpleDateFormat("yyyy-mm-dd HH:MM:SS").parse(timeOfLog);
    }

    public void setTimeOfLog(Date timeOfLog) {
        this.timeOfLog = String.valueOf(timeOfLog);
    }

    public Integer getFuselageStatus() {
        return fuselageStatus;
    }

    public void setFuselageStatus(Integer fuselageStatus) {
        this.fuselageStatus = fuselageStatus;
    }

    public Integer getRightWingStatus() {
        return rightWingStatus;
    }

    public void setRightWingStatus(Integer rightWingStatus) {
        this.rightWingStatus = rightWingStatus;
    }

    public Integer getLeftWingStatus() {
        return leftWingStatus;
    }

    public void setLeftWingStatus(Integer leftWingStatus) {
        this.leftWingStatus = leftWingStatus;
    }

    public Integer getTailStatus() {
        return tailStatus;
    }

    public void setTailStatus(Integer tailStatus) {
        this.tailStatus = tailStatus;
    }

    public Integer getRightEngineStatus() {
        return rightEngineStatus;
    }

    public void setRightEngineStatus(Integer rightEngineStatus) {
        this.rightEngineStatus = rightEngineStatus;
    }

    public Integer getLeftEngineStatus() {
        return leftEngineStatus;
    }

    public void setLeftEngineStatus(Integer leftEngineStatus) {
        this.leftEngineStatus = leftEngineStatus;
    }

    public String getProblems() {
        return problems;
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }
}
