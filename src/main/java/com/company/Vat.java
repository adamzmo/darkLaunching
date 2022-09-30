package com.company;

import java.math.BigDecimal;
import java.util.Map;

public class Vat {
    private static Map<String, BigDecimal> vatPerProduct = Map.of(
      "charity", BigDecimal.ZERO,
      "bread", BigDecimal.valueOf(4)
    );

    private static Map<String, BigDecimal> newVatPerProduct = Map.of(
            "charity", BigDecimal.valueOf(5),
            "bread", BigDecimal.valueOf(10)
    );

    private final boolean useNewVatRates;

    public Vat(boolean useNewVatRates) {
        this.useNewVatRates = useNewVatRates;
    }

    public Vat() {
        useNewVatRates = false;
    }

    public BigDecimal calculate(String product) {
        if (useNewVatRates) {
            return newVatPerProduct.get(product);
        }
        return vatPerProduct.get(product);
    }
}
