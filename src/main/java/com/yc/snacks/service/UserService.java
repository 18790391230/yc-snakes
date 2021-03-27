package com.yc.snacks.service;

import com.yc.snacks.domain.EmpGroup;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    boolean firstLogin(int empId);

    void saveUserTags(int empId, List<Integer> tags);

    void updateLoginStatus(int empId);

    BigDecimal selectEmpInfo(Integer empId);
}
