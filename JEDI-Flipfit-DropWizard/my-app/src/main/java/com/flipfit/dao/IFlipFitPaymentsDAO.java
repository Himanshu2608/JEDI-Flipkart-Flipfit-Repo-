package com.flipfit.dao;

import com.flipfit.model.FlipFitPayments;

public interface IFlipFitPaymentsDAO {
    public void setPaymentInfo(FlipFitPayments FFP);
    public void deletePaymentInfo(FlipFitPayments FFP);
}
