package pe.edu.upc.avi_aplicaction.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.avi_aplicaction.entities.Users;
import pe.edu.upc.avi_aplicaction.entities.roles;
import pe.edu.upc.avi_aplicaction.repositories.IUsersRepository;

import java.util.ArrayList;
import java.util.List;

//Clase 2
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsersRepository repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findOneByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not exists", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        user.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getRol()));
        });

        UserDetails ud = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, roles);

        return ud;
    }

}
