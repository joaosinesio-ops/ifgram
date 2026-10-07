package br.edu.ifpb.ifgram.dto;

import br.edu.ifpb.ifgram.model.User;

public record UsersResponse(Long id, String nome, String email)  {
    public static UsersResponse from (User user) {
        return new UsersResponse(user.getId(), user.getNome(), user.getEmail());
    }
}
