package com.cloud.config;

public enum Teacher {
    Name("姓名"),
    Age("年龄");

    private String _customName;
    Teacher(String customName) {
        _customName = customName;
    }

    public String getCustomName() {
        return _customName;
    }

    public void setCustomName(String customName) {
        _customName = customName;
    }
}
