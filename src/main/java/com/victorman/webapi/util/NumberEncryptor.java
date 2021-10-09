package com.victorman.webapi.util;


public class NumberEncryptor {

    private final Long encryptionKey;

    public NumberEncryptor(Long encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public String encrypt(Long number) {
        return Base62.encode(number ^ encryptionKey);
    }

    public Long decrypt(String encodedNumber) {
        return Base62.decode(encodedNumber) ^ encryptionKey;
    }
}
