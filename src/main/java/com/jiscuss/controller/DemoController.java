package com.jiscuss.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.ModelAndView;

/**
 * @author cyy 2023/7/12 created
 */
@Controller
public class DemoController {
    @Mapping("/")
    public Object test(){
        ModelAndView model = new ModelAndView("index.htm");
        model.put("title","jiscuss");
        model.put("message","你好 jiscuss!");

        return model;
    }
}
