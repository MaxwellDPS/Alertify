package com.github.alertify;

public class SSLSettings {
    public boolean validateSSL;
    public String cert;

    public SSLSettings(boolean validateSSL, String cert) {
        this.validateSSL = validateSSL;
        this.cert = cert;
    }
}
