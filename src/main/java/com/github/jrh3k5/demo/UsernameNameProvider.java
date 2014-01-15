package com.github.jrh3k5.demo;


public class UsernameNameProvider implements NameProvider {

    @Override
    public String getName() {
        return System.getProperty("user.name");
    }

}
