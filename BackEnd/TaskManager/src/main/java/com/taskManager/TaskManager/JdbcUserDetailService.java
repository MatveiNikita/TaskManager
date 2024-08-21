package com.taskManager.TaskManager;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class JdbcUserDetailService extends MappingSqlQuery<UserDetails> implements UserDetailsService {
    public JdbcUserDetailService(DataSource ds) {
        super(ds, """
            SELECT id, username, password, role
            FROM users
            WHERE username = :username;
            """);

        this.declareParameter(new SqlParameter("username",Types.VARCHAR));
        this.compile();
    }

    @Override
    protected UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String username = rs.getString("username");
        String password = rs.getString("password");
        String role = rs.getString("role");

        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .authorities((Collections.singletonList(new SimpleGrantedAuthority(role))))
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(this.findObjectByNamedParam(Map.of("username", username)))
                .orElseThrow(() -> new UsernameNotFoundException("User with this name %s was not found".formatted(username)));
    }
}
