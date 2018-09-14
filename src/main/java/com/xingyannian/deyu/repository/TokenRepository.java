package com.xingyannian.deyu.repository;

import com.xingyannian.deyu.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by XINGYANNIAN on 2018/9/14.
 */
public interface TokenRepository extends JpaRepository<Token,Long> {
}
