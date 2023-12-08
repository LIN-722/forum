package com.lin.uitl;

import com.lin.entity.User;
import org.springframework.stereotype.Component;

/**
 * 持有用户的信息，用于代替session对象
 */
@Component
public class HostHolder {
    // 已线程为单位存取值，把user存入当前线程，可供本次请求随时获取。
    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }
}
