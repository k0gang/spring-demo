package com.example.demo1.user.model;

public class UserRequestDto {
    private String username;
    private String password;

    // 기본 생성자
    public UserRequestDto() {}

    // 모든 필드를 받는 생성자
    public UserRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter와 Setter 메서드
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}