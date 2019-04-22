package com.example.pattern.adapter.model;

import com.example.pattern.adapter.interfaces.SocketAdapter;

public class SocketAdapterImpl extends Socket implements SocketAdapter {
    @Override
    public Volt get120Volts() {
        return getVolt();
    }

    @Override
    public Volt get12Volts() {
        return convertVolt(getVolt(), 10);
    }

    @Override
    public Volt get3Volts() {
        return convertVolt(getVolt(), 40);
    }

    @Override
    public Volt get1Volts() {
        return get1Volts();
    }

    private Volt convertVolt(Volt volt, int i) {
        return new Volt(volt.getVolts() / i);
    }
}
