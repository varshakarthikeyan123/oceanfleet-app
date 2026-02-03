package com.oceanfleet.ui;

import java.util.List;
import java.util.Scanner;

import com.oceanfleet.model.Vessel;
import com.oceanfleet.util.VesselUtil;

public class UserInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VesselUtil util = new VesselUtil();

        System.out.print("Enter number of vessels: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Enter vessel details (vesselId:vesselName:averageSpeed:vesselType)");
            String input = sc.nextLine();

            String[] data = input.split(":");

            Vessel vessel = new Vessel(
                    data[0],
                    data[1],
                    Double.parseDouble(data[2]),
                    data[3]
            );

            util.addVesselPerformance(vessel);
        }

        // UC3: Retrieve vessel by ID
        System.out.print("Enter vessel id to search: ");
        String searchId = sc.nextLine();

        Vessel foundVessel = util.getVesselById(searchId);

        if (foundVessel != null) {
            System.out.println(
                    foundVessel.getVesselId() + " " +
                            foundVessel.getVesselName() + " " +
                            foundVessel.getAverageSpeed() + " " +
                            foundVessel.getVesselType()
            );
        } else {
            System.out.println("No vessel found");
        }

        // UC4: High performance vessels
        List<Vessel> highPerfList = util.getHighPerformanceVessels();

        System.out.println("High performance vessels:");
        for (Vessel v : highPerfList) {
            System.out.println(
                    v.getVesselId() + " " +
                            v.getVesselName() + " " +
                            v.getAverageSpeed() + " " +
                            v.getVesselType()
            );
        }

        sc.close();
    }
}
