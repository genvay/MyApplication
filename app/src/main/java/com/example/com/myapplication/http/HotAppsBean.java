package com.example.com.myapplication.http;

import java.util.List;

/**
 * Created by majingwei on 2015/8/4.
 */
public class HotAppsBean {

    public static class Status {

        private int code;

        private String ver;

        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getVer() {
            return ver;
        }

        public void setVer(String ver) {
            this.ver = ver;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class Data {

        private int end;

        private int from;

        private int listnum;

        private int sum;

        private List<App> list;

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getListnum() {
            return listnum;
        }

        public void setListnum(int listnum) {
            this.listnum = listnum;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public List<App> getList() {
            return list;
        }

        public void setList(List<App> list) {
            this.list = list;
        }
    }

    private Status status;

    private Data data;


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
