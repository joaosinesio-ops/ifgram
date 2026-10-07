package br.edu.ifpb.ifgram.service;

import br.edu.ifpb.ifgram.dto.UsersRequest;
import br.edu.ifpb.ifgram.dto.UsersResponse;
import br.edu.ifpb.ifgram.model.User;
import br.edu.ifpb.ifgram.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

        private final UsersRepository repository;

        public UsersService(UsersRepository repository) { this.repository = repository; }

    @Transactional
    public UsersResponse criar(UsersRequest request) throws Exception {
            if (repository.existsByEmail(request.email())){
                throw new Exception(request.email());
            }
        User salvo = repository.save(new User(request.nome(), request.email()));
        return UsersResponse.from(salvo);
    }
}