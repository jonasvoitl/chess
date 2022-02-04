package net.htlgkr.groupK.chess;

import net.htlgkr.groupK.chess.sockets.Client;
import net.htlgkr.groupK.chess.sockets.Server;

import java.io.Serializable;

public class Data implements Serializable {
    private String userName;
    private String password;

    public Data() {
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
}
