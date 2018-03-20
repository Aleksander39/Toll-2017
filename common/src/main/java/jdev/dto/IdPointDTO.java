package jdev.dto;

import java.io.Serializable;

public class IdPointDTO implements Serializable{

    private String autoId;
    private long time;

    public IdPointDTO() {}
    public IdPointDTO(String autoId, long time) {
        this.autoId = autoId;
        this.time = time;
    }

    public String getAutoId() {
        return autoId;
    }

    public long getTime() {
        return time;
    }

    public boolean equals(Object o) {
        return ((o instanceof IdPointDTO) &&
                autoId.equals(((IdPointDTO)o).getAutoId()) &&
                time == ((IdPointDTO)o).getTime());
    }
    public int hashCode() {
        return autoId.hashCode();
    }
}
