    package com.charitydraw.charitydrawbackend.service;

    import com.charitydraw.charitydrawbackend.dto.LoginRequest;
    import com.charitydraw.charitydrawbackend.entity.User;
    import com.charitydraw.charitydrawbackend.repository.UserRepository;
    import com.charitydraw.charitydrawbackend.security.JwtUtil;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    @Service
    public class AuthService {
        @Autowired
        private UserRepository userRepository;

        @Autowired
        private JwtUtil jwtUtil;

        public User register(User user) {
            return userRepository.save(user);
        }
        public User login(LoginRequest request) {
            User user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            if (!user.getPassword().equals(request.getPassword())) {
                throw new RuntimeException("Invalid password");
            }

            return user;
        }
    //    public String login(String email, String password) {
    //        User user=userRepository.findByEmail(email)
    //                .filter(u -> u.getPassword().equals(password))
    //                .orElseThrow(()-> new RuntimeException("Invalid credentials"));
    //        return jwtUtil.generateToken(user.getEmail());
    //
    //    }

    }
