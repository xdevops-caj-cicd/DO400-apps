package com.redhat.shipping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShippingCalculatorTest {

    @Test
    public void onNARegionTheCostIs100() throws RegionNotFoundException {
        // Given
        ShippingCalculator calculator = new ShippingCalculator();

        // When
        int calculatedCost = calculator.costForRegion("NA");

        // Then
        assertEquals(100, calculatedCost);
    }

    @Test
    public void onLATAMRegionTheCostIs200() throws RegionNotFoundException {
        // Given
        ShippingCalculator calculator = new ShippingCalculator();

        // When
        int calculatedCost = calculator.costForRegion("LATAM");

        // Then
        assertEquals(200, calculatedCost);
    }

    @Test
    public void onEMEARegionTheCostIs300() throws RegionNotFoundException {
        // Given
        ShippingCalculator calculator = new ShippingCalculator();

        // When
        int calculatedCost = calculator.costForRegion("EMEA");

        // Then
        assertEquals(300, calculatedCost);
    }

    @Test
    public void onAPACRegionTheCostIs400() throws RegionNotFoundException {
        // Given
        ShippingCalculator calculator = new ShippingCalculator();

        // When
        int calculatedCost = calculator.costForRegion("APAC");

        // Then
        assertEquals(400, calculatedCost);
    }

    @Test
    public void onNonSupportedRegionARegionNotFoundExceptionIsRaised() {
        ShippingCalculator calculator = new ShippingCalculator();

        assertThrows(
            RegionNotFoundException.class, 
            () -> calculator.costForRegion("Unkown Region")
        );
    }

}
