package com.example.javabase;

public class Animal {
    private  String _name;
    private  String _speak;
    private  int _icon;
    private  boolean _check;

    public Animal(String name, String speak, int icon, boolean check) {
        _name = name;
        _speak = speak;
        _icon = icon;
        _check = check;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_name() {
        return _name;
    }
    public void set_speak(String _speak) {
        this._speak = _speak;
    }

    public String get_speak() {
        return _speak;
    }

    public void set_icon(int _icon) {
        this._icon = _icon;
    }

    public int get_icon() {
        return _icon;
    }

    public void set_check(boolean _check) {
        this._check = _check;
    }

    public boolean is_check() {
        return _check;
    }
}
