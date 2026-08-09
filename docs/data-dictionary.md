# 数据字典（Data Dictionary）

## sys_user（系统用户表）

| 字段名 | 类型           | 约束 | 默认值 | 说明 |
|--------|--------------|------|--------|------|
| id | BIGINT       | PRIMARY KEY, AUTO_INCREMENT | - | 用户唯一标识 |
| username | VARCHAR(20)  | NOT NULL, UNIQUE | - | 登录用户名，长度 3-20 |
| password | VARCHAR(255) | NOT NULL | - | BCrypt 加密后的密码 |
| email | VARCHAR(100) | NOT NULL, UNIQUE | - | 邮箱 |
| status | TINYINT      | - | 1 | 状态：0=禁用，1=正常 |
| created_at | DATETIME     | - | CURRENT_TIMESTAMP | 创建时间 |
| updated_at | DATETIME     | - | CURRENT_TIMESTAMP ON UPDATE | 更新时间 |