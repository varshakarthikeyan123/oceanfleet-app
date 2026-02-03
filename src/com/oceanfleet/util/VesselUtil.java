package com.oceanfleet.util;

import java.util.ArrayList;
import java.util.List;
import com.oceanfleet.model.Vessel;

public class VesselUtil {

    private List<Vessel> vesselList = new ArrayList<>();

    // Method to add vessel performance
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    // Getter for vessel list (used in later UCs)
    public List<Vessel> getVesselList() {
        return vesselList;
    }
}
