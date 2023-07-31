package com.jiscuss;

import org.noear.solon.Solon;

/**
 * @author cyy 2023/7/12 created
 */
public class JiscussApp {
    public static void main(String[] args) {
        Solon.start(JiscussApp.class, args)
                .onError(e -> e.printStackTrace());
    }
}
