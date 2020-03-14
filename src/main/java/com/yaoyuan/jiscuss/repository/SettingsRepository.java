package com.yaoyuan.jiscuss.repository;

import com.yaoyuan.jiscuss.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository  extends JpaRepository<Settings,Integer> {
}
