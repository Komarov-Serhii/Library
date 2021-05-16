package com.komarov_s_s.final_project.library.dao.Connection;

public abstract class ConnectionSupport {

    protected Connector connector = null;

    public ConnectionSupport(Connector connector) {
        this.connector = connector;
    }

}
