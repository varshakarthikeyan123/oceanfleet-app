package com.oceanfleet.util;

import java.util.ArrayList;
import java.util.List;
import com.oceanfleet.model.Vessel;

public class VesselUtil {

    private List<Vessel> vesselList = new ArrayList<>();

    // UC2: Add vessel
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    // UC3: Retrieve vessel by ID
    public Vessel getVesselById(String vesselId) {
        for (Vessel vessel : vesselList) {
            if (vessel.getVesselId().equals(vesselId)) {
                return vessel;
            }
        }
        return null;
    }

    // UC4: Get high performance vessels
    public List<Vessel> getHighPerformanceVessels() {
        List<Vessel> result = new ArrayList<>();

        if (vesselList.isEmpty()) {
            return result;
        }

        double maxSpeed = vesselList.get(0).getAverageSpeed();

        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() > maxSpeed) {
                maxSpeed = vessel.getAverageSpeed();
            }
        }

        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() == maxSpeed) {
                result.add(vessel);
            }
        }

        return result;
    }

    // Getter (optional, useful later)
    public List<Vessel> getVesselList() {
        return vesselList;
    }
}
