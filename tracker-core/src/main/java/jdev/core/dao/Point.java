package jdev.core.dao;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="point")
public class Point {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "LAT", nullable = false)
    Double lat;

    @Column(name = "LON", nullable = false)
    Double lon;

    @Column(name = "AUTO_ID", length = 8, nullable = false)
    String autoId;

    @Column(name = "TIME", nullable = false)
    Long time;

    @Column(name = "AZIMUTH", nullable = false)
    Double azimuth;

    @Column(name = "INSTA_SPEED", nullable = false)
    Integer instaSpeed;

    public Point(){}

    public Point(Double lat, Double lon, Long time, Double azimuth, Integer instaSpeed,String autoId){
        this.lat =lat;
        this.lon= lon;
        this.time= time;
        this.azimuth =azimuth;
        this.instaSpeed = instaSpeed;
        this.autoId= autoId;
    }
    public String toString() {
        return "Point{ id=" + id + ", lat=" + lat + ", lon=" + lon + ", autoId=" + autoId + ", time=" + time +
                ", azimuth=" + azimuth + ", instaSpeed=" + instaSpeed + " }";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(Double azimuth) {
        this.azimuth = azimuth;
    }

    public Integer getSpeed() {
        return instaSpeed;
    }

    public void setSpeed(Integer instaSpeed) {
        this.instaSpeed = instaSpeed;
    }
}
