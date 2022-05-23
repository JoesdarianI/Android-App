package com.example.insorma;

public class HomeListview {

    private int LvImage;
    private String LvFname;
    private String LvFrating;
    private String LvFprice;

    public HomeListview(int lvImage, String lvFname, String lvFrating, String lvFprice) {
        LvImage = lvImage;
        LvFname = lvFname;
        LvFrating = lvFrating;
        LvFprice = lvFprice;
    }

    public int getLvImage() {
        return LvImage;
    }

    public String getLvFname() {
        return LvFname;
    }

    public String getLvFrating() {
        return LvFrating;
    }

    public String getLvFprice() {
        return LvFprice;
    }
}
