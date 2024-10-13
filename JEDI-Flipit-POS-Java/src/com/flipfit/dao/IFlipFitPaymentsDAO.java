package com.flipfit.dao;

import com.flipfit.bean.FlipFitPayments;

public interface IFlipFitPaymentsDAO {
    public void setPaymentInfo(FlipFitPayments FFP);
    public void deletePaymentInfo(FlipFitPayments FFP);
}
