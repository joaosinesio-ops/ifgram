package br.edu.ifpb.ifgram.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jota")

public class UsersController {

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
    public String putUser(){
        return "chamei o endpoint PUT";
    }

    @PatchMapping
    public String patchUser(){
        return "chamei o endpoint PATCH";
    }
}
