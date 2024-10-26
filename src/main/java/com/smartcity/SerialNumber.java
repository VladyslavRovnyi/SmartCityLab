package com.smartcity;

public final class SerialNumber {
    private final String serial;

    public SerialNumber(String base, int... parts) {
        StringBuilder sb = new StringBuilder(base);
        for (int part : parts) {
            sb.append("-").append(String.format("%02d", part));
        }
        this.serial = sb.toString();
    }

    public String getSerial() {
        return serial;
    }

    @Override
    public String toString() {
        return serial;
    }
}
