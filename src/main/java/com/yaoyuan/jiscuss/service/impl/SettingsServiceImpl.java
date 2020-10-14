package com.yaoyuan.jiscuss.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaoyuan.jiscuss.entity.Setting;
import com.yaoyuan.jiscuss.repository.SettingsRepository;
import com.yaoyuan.jiscuss.service.ISettingsService;

@Service
@Transactional
public class SettingsServiceImpl implements ISettingsService {
    @Autowired
    private SettingsRepository settingsRepository;

    @Override
    public List<Setting> getAllList() {
        return settingsRepository.findAll();
    }

    @Override
    public Setting insert(Setting setting) {
        return settingsRepository.save(setting);
    }
}
