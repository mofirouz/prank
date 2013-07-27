package com.mofirouz.prank;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

public class SambaFileMonitor {
    private final NtlmPasswordAuthentication auth;
    private final SmbFile file;

    public SambaFileMonitor(String userAuth, String waitFilePath) throws IOException {
        auth = new NtlmPasswordAuthentication(userAuth);
        file = new SmbFile(waitFilePath, auth);
    }

    public boolean exists() throws MalformedURLException, UnknownHostException, SmbException {
        return file.exists();
    }

    public SmbFile getFile() {
        return file;
    }
}
