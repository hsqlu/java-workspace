package com.hsqlu.jmx.standard;

import java.util.concurrent.atomic.AtomicLong;

public class HelloWorld implements HelloMBean {

    private String name;

    private AtomicLong count;

    public HelloWorld(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        count.getAndIncrement();
        return this.name;
    }

    @Override
    public long count() {
        return count.get();
    }
}
