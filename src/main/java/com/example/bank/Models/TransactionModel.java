package com.example.bank.Models;

import java.util.Date;

public class TransactionModel {
    private enum TypeTransaction{Depot, Retrait, Virement}
    private long num_op;
    private TypeTransaction type_op;
    private Date date_op;
    private float mnt_op;

    public TransactionModel(long num_op, TypeTransaction type_op, Date date_op, float mnt_op) {
        this.num_op = num_op;
        this.type_op = type_op;
        this.date_op = date_op;
        this.mnt_op = mnt_op;
    }

    public long getNum_op() {
        return num_op;
    }

    public TypeTransaction getType_op() {
        return type_op;
    }

    public Date getDate_op() {
        return date_op;
    }

    public float getMnt_op() {
        return mnt_op;
    }
}
