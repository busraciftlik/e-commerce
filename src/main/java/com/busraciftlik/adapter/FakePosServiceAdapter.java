package com.busraciftlik.adapter;

import com.busraciftlik.business.abstracts.PosService;
import com.busraciftlik.common.constants.Message;
import com.busraciftlik.core.exceptions.BusinessException;

import java.util.Random;

public class FakePosServiceAdapter implements PosService {

    @Override
    public void pay() {
        boolean isPaymentSuccessful = new Random().nextBoolean();
        if(!isPaymentSuccessful){
            throw new BusinessException(Message.Payment.PAYMENT_FAILED);
        }
    }
}
