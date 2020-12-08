package com.sudo.pattern.immutable;

import java.io.Serializable;
import java.util.Date;

public final class ImmutableClass implements Serializable {

    /*
    IMmutable primitive
     */
    private final int number;
    /*immutable String     */
    private final String name;
    /*Mutable date object
     */
    private final Date joinDate;


    public ImmutableClass(int number, String name, Date joinDate) {
        this.number = number;
        this.name = name;
        this.joinDate = joinDate;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Date getJoinDate() {
        return new Date(joinDate.getTime());
    }
}
