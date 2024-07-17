package at.htl.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class MechanikerZuteilung {
    @EmbeddedId
    private MechanikerZuteildung_id zuteildung_id;

    public MechanikerZuteilung(MechanikerZuteildung_id zuteildung_id) {
        this.zuteildung_id = zuteildung_id;
    }

    public MechanikerZuteilung() {}

    public MechanikerZuteildung_id getZuteildung_id() {
        return zuteildung_id;
    }

    public void setZuteildung_id(MechanikerZuteildung_id zuteildung_id) {
        this.zuteildung_id = zuteildung_id;
    }
}
