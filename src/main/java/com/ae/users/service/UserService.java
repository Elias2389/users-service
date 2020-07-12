package com.ae.users.service;

import com.ae.users.entity.User;

import java.util.List;

public interface UserService {

    /**
     * @param user to create
     * @return user created
     */
    public User createUser(final User user);

    /**
     * @param user to update
     * @return user updated
     */
    public User updateUser(final User user);

    /**
     * @return list of users
     */
    public List<User> getUsers();

    /**
     * @param id of user to find
     * @return user found
     */
    public User getUserById(final Long id);

    /**
     * @param id of user to delete
     */
    public void deleteUserById(final Long id);

}
