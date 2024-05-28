package com.joaovellenich.TruckLogistic.infra.gateways;

import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.infra.persistence.entities.UserEntity;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.UserMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.repositories.UserRepository;
import com.joaovellenich.TruckLogistic.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserRepositoryGateway implements UserGateway {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserRepositoryGateway(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public boolean hasUserWithEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    @Override
    public UserDetails findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        UserEntity userToSave = this.userMapper.toEntity(user);
        UserEntity userSaved = this.userRepository.save(userToSave);
        return this.userMapper.toDomain(userSaved);
    }

    @Override
    public User getUserById(UUID id) throws Exception {
        var user = this.userRepository.findById(id).orElseThrow(Exception::new);
        return this.userMapper.toDomain(user);
    }

    @Override
    public List<User> listUserFromCompany(UUID companyId) {
        List<UserEntity> users = this.userRepository.findByCompanyId(companyId);
        return users.stream().map(this.userMapper::toDomain).collect(Collectors.toList());
    }
}
