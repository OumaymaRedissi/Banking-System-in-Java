package com.bank.Models;

import java.util.Date;

public class VirementModel extends TransactionModel{


    private long num_c_ben;

    public VirementModel( Date date_op, Double mnt_op,long num_c_em,long num_c_ben) {
        super(date_op, mnt_op, num_c_em);
        this.num_c_ben = num_c_ben;
    }

    public VirementModel(long num_op, Date date_op, Double mnt_op,long num_c_em,long num_c_ben) {
        super(num_op, date_op, mnt_op, num_c_em);
        this.num_c_ben = num_c_ben;
    }

    public long getNum_c_ben() {
        return num_c_ben;
    }

    public void setNum_c_ben(long num_c_ben) {
        this.num_c_ben = num_c_ben;
    }
}
