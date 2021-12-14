package com.bank.Models;

import java.util.Date;

public class DepotModel extends TransactionModel{

    public DepotModel( Date date_op, Double mnt_op,long num_c_em) {
        super( date_op, mnt_op, num_c_em);
    }
    public DepotModel(long num_op, Date date_op, Double mnt_op,long num_c_em) {
        super(num_op, date_op, mnt_op, num_c_em);
    }


}
