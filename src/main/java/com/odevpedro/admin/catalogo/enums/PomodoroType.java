package com.odevpedro.admin.catalogo.enums;

public enum PomodoroType {
    SHORT(25),

    MEDIUM(30),

    LONG(45);

    private final int durationMinutes;

    PomodoroType(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes(){
        return durationMinutes;
    }

}
