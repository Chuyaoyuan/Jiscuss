package com.jiscuss.dso;

import org.noear.solon.auth.AuthProcessorBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyy 2023/7/12 created
 */
public  class AuthProcessorImpl extends AuthProcessorBase {
    @Override
    public boolean verifyLogined() {
        return true;
    }

    @Override
    protected List<String> getPermissions() {
        List<String> list = new ArrayList<>();

        list.add("user:add");
        list.add("user:demo");

        return list;
    }

    @Override
    protected List<String> getRoles() {
        List<String> list = new ArrayList<>();

        list.add("admin1");
        list.add("admin2");

        return list;
    }
}
