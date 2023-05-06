package com.parking.lot.exceptions;

public class SlotNotAvailableException extends RuntimeException {
    public SlotNotAvailableException(String s) {
        super(s);
    }
}
