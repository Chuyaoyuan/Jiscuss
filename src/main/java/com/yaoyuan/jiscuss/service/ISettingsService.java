package com.yaoyuan.jiscuss.service;

import com.yaoyuan.jiscuss.entity.Setting;

import java.util.List;

public interface ISettingsService {

    List<Setting> getAllList();

    Setting insert(Setting setting);
}
