package net.htlgkr.groupK.chess;

import net.htlgkr.groupK.chess.sockets.Client;
import net.htlgkr.groupK.chess.sockets.Server;

import java.io.Serializable;

public class Data implements Serializable {
    private String userName;
    private String password;
    private String ipAddress;
    private int portNumber;

    public Data() {
    }

    public Data(String userName, String password, String ipAddress, int portNumber) {
        this.userName = userName;
        this.password = password;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }
}
