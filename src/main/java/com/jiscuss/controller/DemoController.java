package com.jiscuss.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author cyy 2023/7/12 created
 */
@Controller
public class DemoController {

    static Logger log = LoggerFactory.getLogger(DemoController.class);

    @Mapping("/")
    public Object test(){
        log.info("test");
        ModelAndView model = new ModelAndView("index.htm");
        model.put("title","jiscuss");
        model.put("message","你好 jiscuss!");

        return model;
    }
}
