package com.bank.Models;

import java.util.Date;

public class TransactionModel {

    private long num_op;
    private Date date_op;
    private Double mnt_op;
    private long num_c_em;

    public  TransactionModel(){};

    public TransactionModel(long num_op, Date date_op, Double mnt_op, long num_c_em) {
        this.num_op = num_op;
        this.date_op = date_op;
        this.mnt_op = mnt_op;
        this.num_c_em = num_c_em;
    }

    public TransactionModel(Date date_op, Double mnt_op, long num_c_em) {
        this.date_op = date_op;
        this.mnt_op = mnt_op;
        this.num_c_em = num_c_em;
    }

    public long getNum_c_em() {
        return num_c_em;
    }

    public long getNum_op() {
        return num_op;
    }

    public Date getDate_op() {
        return date_op;
    }

    public Double getMnt_op() {
        return mnt_op;
    }
}
