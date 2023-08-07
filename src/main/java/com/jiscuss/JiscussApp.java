package com.jiscuss;

import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;

/**
 * @author cyy 2023/7/12 created
 */
@SolonMain
public class JiscussApp {
    public static void main(String[] args) {
        Solon.start(JiscussApp.class, args)
                .onError(e -> e.printStackTrace());
    }
}
