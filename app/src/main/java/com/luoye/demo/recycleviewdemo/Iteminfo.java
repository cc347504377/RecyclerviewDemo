package com.luoye.demo.recycleviewdemo;

/**
 * Created by Luoye on 2016/10/24.
 */

public class Iteminfo{
    private String tv;
    private boolean checked;

    public Iteminfo(String tv, boolean checked) {
        this.tv = tv;
        this.checked = checked;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
