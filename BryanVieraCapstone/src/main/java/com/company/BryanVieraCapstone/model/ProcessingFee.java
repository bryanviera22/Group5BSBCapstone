package com.company.BryanVieraCapstone.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ProcessingFee {

    private String productFee;
    private BigDecimal fee;

    public String getProductFee() {
        return productFee;
    }

    public void setProductFee(String productFee) {
        this.productFee = productFee;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessingFee that = (ProcessingFee) o;
        return Objects.equals(getProductFee(), that.getProductFee()) && Objects.equals(getFee(), that.getFee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductFee(), getFee());
    }
}
