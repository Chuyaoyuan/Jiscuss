package com.yaoyuan.jiscuss.service;

import java.util.List;

import com.yaoyuan.jiscuss.entity.Setting;

public interface ISettingsService {

    List<Setting> getAllList();

    Setting insert(Setting setting);
}
