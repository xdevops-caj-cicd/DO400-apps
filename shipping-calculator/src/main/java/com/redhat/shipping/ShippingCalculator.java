package com.redhat.shipping;

import java.util.Map;
import java.util.HashMap;

public class ShippingCalculator {
    private static final Map<String, Integer> REGIONS = new HashMap<>();

    public ShippingCalculator() {
        REGIONS.put("NA", 100);
        REGIONS.put("LATAM", 200);
        REGIONS.put("EMEA", 300);
        REGIONS.put("APAC", 400);
    }

    public int costForRegion(String region) throws RegionNotFoundException {
        if (REGIONS.containsKey(region)) {
            return REGIONS.get(region);
        }
        throw new RegionNotFoundException();
    }
}
