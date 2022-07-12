package com.ronglian.vlv.aes;

public enum CryptoType {
    AES_128(128), AES_192(192), AES_256(256);
    public int value;
    private CryptoType(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
