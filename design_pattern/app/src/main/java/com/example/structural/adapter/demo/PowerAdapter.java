package com.example.structural.adapter.demo;

public class PowerAdapter implements DC5 {
    private AC220 ac220 = new AC220();

    @Override
    public int outputDC5() {
        int adapterInput = ac220.outputAC220V();
        int adapterOutput = adapterInput / 44;
        System.out.println("使用PowerAdapter输入"+adapterInput+"使用PowerAdapter输出"+adapterOutput);
        return adapterOutput;
    }
}
