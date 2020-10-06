package com.example.experiment3;

class Marks {
    private int _id;
    private String _studentName;
    //subject marks
    private String  _MC;
    private String  _ACA;
    private String  _FA;
    private String _ET;

    public Marks() {
    }

    public Marks(String _studentName, String _MC, String _ACA, String _FA, String _ET) {
        this._studentName = _studentName;
        this._MC = _MC;
        this._ACA = _ACA;
        this._FA = _FA;
        this._ET = _ET;
    }

    public String get_studentName() {
        return _studentName;
    }

    public String get_MC() {
        return _MC;
    }

    public String get_ACA() {
        return _ACA;
    }

    public String get_FA() {
        return _FA;
    }

    public String get_ET() {
        return _ET;
    }

    public void set_studentName(String _studentName) {
        this._studentName = _studentName;
    }

    public void set_MC(String _MC) {
        this._MC = _MC;
    }

    public void set_ACA(String _ACA) {
        this._ACA = _ACA;
    }

    public void set_FA(String _FA) {
        this._FA = _FA;
    }

    public void set_ET(String _ET) {
        this._ET = _ET;
    }
}
