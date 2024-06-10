package com.example.demo1.user.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    private List<User> users = new ArrayList<>();
    private Long nextId = 1L;

    // 사용자를 저장하는 메서드
    public User save(User user) {
        user.setId(nextId++);
        users.add(user);
        return user;
    }

    // 모든 사용자를 반환하는 메서드
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    // ID로 사용자를 찾는 메서드
    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    // 사용자 업데이트 메서드
    public User update(User user) {
        findById(user.getId()).ifPresent(existingUser -> {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
        });
        return user;
    }

    // ID로 사용자를 삭제하는 메서드
    public boolean deleteById(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}