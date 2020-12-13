package com.yaoyuan.jiscuss.service.impl;

import com.yaoyuan.jiscuss.entity.Setting;
import com.yaoyuan.jiscuss.repository.SettingsRepository;
import com.yaoyuan.jiscuss.service.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
