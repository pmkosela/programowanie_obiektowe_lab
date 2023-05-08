package com.company;

import java.util.List;

public class AmbigiousProductException extends Exception {
    List<String> names;

    public AmbigiousProductException(List<String> names) {
        this.names = names;
    }

    @Override
    public String getMessage() {
        return names.toString();
    }
}
