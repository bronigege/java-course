package io.dumasoft.library.service.admin;

import io.dumasoft.library.models.dao.IUserDao;
import io.dumasoft.library.models.entity.admin.Role;
import io.dumasoft.library.models.entity.admin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService, IUserService {
    private IUserDao userDao;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(IUserDao userDao, BCryptPasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Role role: user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        /*public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
            this(username, password, true, true, true, true, authorities);
        }*/

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getEnabled(),
                true,
                true,
                true,
                authorities
        );
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User findOne(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        userDao.findById(id);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
