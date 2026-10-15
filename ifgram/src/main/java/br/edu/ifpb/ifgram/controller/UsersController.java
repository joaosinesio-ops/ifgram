package br.edu.ifpb.ifgram.controller;

import br.edu.ifpb.ifgram.dto.UsersRequest;
import br.edu.ifpb.ifgram.dto.UsersResponse;
import br.edu.ifpb.ifgram.service.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")

public class UsersController {

    public final UsersService service;

    public UsersController(UsersService service){
        this.service = service;
    }

    @GetMapping
    public String getUsers(){
        return "Me chame de Jota";
    }
    @PostMapping
    public String postUser(){
        return "chamei o endpoint como um POST";
    }

    @DeleteMapping
    public String deleteUser(){
        return "chamei o endpoint DELETE";
    }

    @PutMapping
    public UsersResponse putUser(UsersRequest request) throws Exception {
        return service.atualizarUsuario(request);
    }

    @PatchMapping
    public String patchUser(){
        return "chamei o endpoint PATCH";
    }
}
