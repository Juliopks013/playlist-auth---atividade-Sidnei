package com.saov.playlist_auth.services;


import com.saov.playlist_auth.dto.AuthRequest;
import com.saov.playlist_auth.dto.AuthResponse;
import com.saov.playlist_auth.entities.User;
import com.saov.playlist_auth.repositories.UserRepository;
import com.saov.playlist_auth.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public void register(AuthRequest authRequest){
        if(userRepository.findByUserName(authRequest.userName()).isPresent()){
            throw new RuntimeException("Usuário já existe");
        }

        User user = new User(
                authRequest.userName(),
                passwordEncoder.encode(authRequest.password()),
                "USER");
        userRepository.save(user);
    }

    public AuthResponse login(AuthRequest authRequest){
        User user = userRepository.findByUserName(authRequest.userName()).orElseThrow(
                ()->new RuntimeException("Credenciais inválidas"));
        if(!passwordEncoder.matches(authRequest.password(),user.getPassword())){
            throw new RuntimeException("Credenciais inválidas");
        }
        String token = jwtUtil.generateToken(user.getUserName(),user.getRole());
        return new AuthResponse(token);
    }
}
