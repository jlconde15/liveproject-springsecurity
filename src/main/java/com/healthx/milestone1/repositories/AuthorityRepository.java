/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.repositories;

import com.healthx.milestone1.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jose
 */

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
