package com.cere.service.repository;

import com.cere.service.entity.User;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

/**
 * Created by CheRevir on 2021/7/21
 */
public interface UserRepository extends ReactiveSortingRepository<User, Long> {
}
