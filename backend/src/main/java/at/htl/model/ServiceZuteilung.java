package at.htl.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ServiceZuteilung {
    @EmbeddedId
    private ServiceZuteilung_id serviceZuteilung_id;

    public ServiceZuteilung(ServiceZuteilung_id serviceZuteilung_id) {
        this.serviceZuteilung_id = serviceZuteilung_id;
    }

    public ServiceZuteilung() {}

    public ServiceZuteilung_id getServiceZuteilung_id() {
        return serviceZuteilung_id;
    }

    public void setServiceZuteilung_id(ServiceZuteilung_id serviceZuteilung_id) {
        this.serviceZuteilung_id = serviceZuteilung_id;
    }
}
