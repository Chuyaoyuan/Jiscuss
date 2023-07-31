package com.jiscuss;

import com.jiscuss.dso.AuthProcessorImpl;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.auth.AuthUtil;

/**
 * @author cyy 2023/7/12 created
 */
@Configuration
public class Config {
    @Bean
    public void authAdapter(){
        AuthUtil.adapter()
                .processor(new AuthProcessorImpl());
    }
}
