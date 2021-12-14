package com.bank.Models;

import java.util.Date;

public class RetraitModel extends TransactionModel{

    public RetraitModel(long num_op, Date date_op, Double mnt_op,long num_c_em) {
        super(num_op, date_op, mnt_op, num_c_em);
    }
}
