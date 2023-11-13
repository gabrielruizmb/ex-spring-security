package com.example.ex001springsecurity.index;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
    
    @GetMapping
    public String indexPage() {
        return "<h1>Rota livre para todos!</h1>";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String userPage() {
        return "<h1>Rota livre para usuários e administradores!</h1><a href = '/logout'>Sair</a>";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminPage() {
        return "<h1>Rota livre para administradores!</h1><a href = '/logout'>Sair</a>";
    }
}
