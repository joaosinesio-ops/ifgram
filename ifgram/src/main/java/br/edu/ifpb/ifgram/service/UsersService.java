package br.edu.ifpb.ifgram.service;

import br.edu.ifpb.ifgram.dto.UsersRequest;
import br.edu.ifpb.ifgram.dto.UsersResponse;
import br.edu.ifpb.ifgram.model.User;
import br.edu.ifpb.ifgram.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public UsersResponse atualizarUsuario(UsersRequest request) throws Exception {
        Optional<User> usuario = repository.findByEmail(request.email());
        if (usuario.isEmpty()){
            throw new Exception("usuário não existe na base dedos");
        }
        User usuarioSalvo = usuario.get();
        usuarioSalvo.setNome(request.nome());
        repository.save(usuarioSalvo);

        return UsersResponse.from(usuarioSalvo);
    }
}

