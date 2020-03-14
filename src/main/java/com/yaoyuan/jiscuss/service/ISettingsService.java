package com.yaoyuan.jiscuss.service;

import java.util.List;

import com.yaoyuan.jiscuss.entity.Settings;

public interface ISettingsService {

    List<Settings> getAllList();

    Settings insert(Settings settings);
}
