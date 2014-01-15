package com.github.jrh3k5.demo;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class DemoBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(new UsernameNameProvider()).to(NameProvider.class);
    }

}
