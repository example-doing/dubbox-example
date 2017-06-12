package com.zenggang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.zenggang.model.User;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private static List<User> users;

    static {
        users = new ArrayList<User>();
        users.add(new User(1, "李四", 23));
        users.add(new User(2, "老王", 43));
        users.add(new User(4, "joy", 16));
        users.add(new User(15, "steven", 89));
    }

    public List<User> findAll() {
        Collections.sort(UserServiceImpl.users, new Comparator<User>() {
            public int compare(User o1, User o2) {
                return o1.getId() - o2.getId();
            }
        });

        return UserServiceImpl.users;
    }

    public User get(int id) {
        User result = null;
        for (User user : UserServiceImpl.users) {
            if (user.getId() == id) {
                result = user;
                break;
            }
        }
        return result;
    }

    public int add(User user) {
        if (user == null) {
            return -1;
        }
        int nextId = 0;
        for (User u : UserServiceImpl.users) {
            nextId = Math.max(nextId, u.getId());
        }
        user.setId(nextId + 1);
        UserServiceImpl.users.add(user);

        return 0;
    }

    public int update(User user) {
        if (user == null) {
            return -1;
        }
        User u = this.get(user.getId());
        if (u == null) {
            return -1;
        }
        u.setName(user.getName());
        u.setAge(user.getAge());

        return 0;
    }

    public int delete(int id) {
        for (Iterator<User> iter = UserServiceImpl.users.iterator(); iter.hasNext(); ) {
            if (iter.next().getId() == id) {
                iter.remove();
            }
        }
        return 0;
    }
}
