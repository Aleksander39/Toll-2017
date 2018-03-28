package jdev.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name ="POINT_DTO")
@IdClass(IdPointDTO.class)
public class PointDTO {
    @Id
    @Column(name = "AUTO_ID")
    private String autoId;

    @Id
    private double lat;
    private double lon;
    private long time;
    private double azimuth;
    private int instaSpeed;


    public int getInstaSpeed() {
        return instaSpeed;
    }

    public void setInstaSpeed(int instaSpeed) {
        this.instaSpeed = instaSpeed;
    }

    public double getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(double azimuth) {
        this.azimuth = azimuth;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    @Override
    public String toString() {
        return "PointDTO{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", azimuth=" +azimuth+
                ", instaSpeed=" +instaSpeed+
                ", autoId=" + autoId +
                ", time=" +time+'\'' +
                '}';
    }

    public void setTime (long time) {
        this.time=time;
    }
    public long getTime(){
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointDTO pointDTO = (PointDTO) o;

        if (time != pointDTO.time) return false;
        return autoId.equals(pointDTO.autoId);
    }

    @Override
    public int hashCode() {
        int result = autoId.hashCode();
        result = 31 * result + (int) (time ^ (time >>> 32));
        return result;
    }
}
