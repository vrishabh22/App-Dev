package com.example.admin.classmanager;

public class Bunk {
    public Bunk(int _id) {
        this._id = _id;
    }

    private final int _id;
    private int _bunk=0;

    public int getBunk() {
        return _bunk;
    }

    public int get_id() {
        return _id;
    }
}
