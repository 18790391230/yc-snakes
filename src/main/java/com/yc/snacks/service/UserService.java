package com.yc.snacks.service;

import java.util.List;

public interface UserService {

    boolean firstLogin(int empId);

    void saveUserTags(int empId, List<Integer> tags);

    void updateLoginStatus(int empId);
}
