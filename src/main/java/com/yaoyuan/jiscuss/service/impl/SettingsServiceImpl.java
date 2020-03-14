package com.yaoyuan.jiscuss.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaoyuan.jiscuss.entity.Settings;
import com.yaoyuan.jiscuss.repository.SettingsRepository;
import com.yaoyuan.jiscuss.service.ISettingsService;

@Service
@Transactional
public class SettingsServiceImpl implements ISettingsService {
    @Autowired
    private SettingsRepository settingsRepository;

    @Override
    public List<Settings> getAllList() {
        return settingsRepository.findAll();
    }

    @Override
    public Settings insert(Settings settings) {
        return settingsRepository.save(settings);
    }
}
