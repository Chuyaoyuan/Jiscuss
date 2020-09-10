package com.yaoyuan.jiscuss.repository;

import com.yaoyuan.jiscuss.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository  extends JpaRepository<Setting,Integer> {
}
