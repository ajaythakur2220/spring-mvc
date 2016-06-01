package com.voca.seve.tset.reception;

/**
 * Created by ajay.thakur on 01/06/2016.
 */
public class DocHdr {

    String MsgId;
    Long NbOfTxs;
    String SubmtrMmbId;
    String ChrgdMmbId;

    public String getChrgdMmbId() {
        return ChrgdMmbId;
    }

    public void setChrgdMmbId(String chrgdMmbId) {
        ChrgdMmbId = chrgdMmbId;
    }

    public String getSubmtrMmbId() {
        return SubmtrMmbId;
    }

    public void setSubmtrMmbId(String submtrMmbId) {
        SubmtrMmbId = submtrMmbId;
    }

    public Long getNbOfTxs() {
        return NbOfTxs;
    }

    public void setNbOfTxs(Long nbOfTxs) {
        NbOfTxs = nbOfTxs;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }



}
