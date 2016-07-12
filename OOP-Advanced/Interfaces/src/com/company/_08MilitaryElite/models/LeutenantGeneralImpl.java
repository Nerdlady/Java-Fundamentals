package com.company.models;

import com.company.interfaces.LeutenantGeneral;
import com.company.interfaces.Private;

import java.util.Collection;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {
    private Collection<Private> privates;

    public LeutenantGeneralImpl(int id, String firstName, String lastName, double salary,Collection<Private> privates) {
        super(id, firstName, lastName, salary);
        this.setPrivates(privates);
    }

    private void setPrivates(Collection<Private> privates) {
        this.privates = privates;
    }

    @Override
    public Collection<Private> getPrivates() {
        return this.privates;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString())
                .append(System.lineSeparator())
                .append("Privates:");

        for (Private aPrivate : privates) {
            builder.append(System.lineSeparator())
                    .append("  ")
                    .append(aPrivate.toString());
        }
        return  builder.toString();
    }
}
