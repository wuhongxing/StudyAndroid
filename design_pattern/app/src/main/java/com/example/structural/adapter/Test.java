package com.example.structural.adapter;

import com.example.structural.adapter.demo.PowerAdapter;

public class Test {
    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();

        PowerAdapter powerAdapter = new PowerAdapter();
        powerAdapter.outputDC5();
    }
}
