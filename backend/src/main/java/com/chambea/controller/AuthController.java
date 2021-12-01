package com.chambea.controller;

import com.chambea.dto.AuthRequest;
import com.chambea.dto.CreateUserRequest;
import com.chambea.model.Usuario;
import com.chambea.repositories.UsuarioRepository;
import com.chambea.security.UserDetailsImpl;
import com.chambea.security.services.AuthService;
import com.chambea.security.util.JwtTokenUtil;
import com.chambea.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private  final AuthService authService;


    /*AuthController(UsuarioService usuarioService, AuthenticationManager authenticationManager){
        this.usuarioService = usuarioService;
        this.authenticationManager = authenticationManager;
    }*/

    @GetMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam String usuario,
            @RequestParam String password){

        Optional<Usuario> usuarioLogeado = usuarioService.getUserByUsernameAndPassword(usuario, password);
        if (usuarioLogeado.isPresent()){
            return new ResponseEntity<String>("Credenciales validas", HttpStatus.OK);
        }
        return new ResponseEntity<>("Credenciales invalidas", HttpStatus.BAD_GATEWAY);
    }

    @PostMapping("/signin")
    public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario){
        Usuario usuarioNew = this.usuarioService.createUsuario(usuario);
        return new ResponseEntity<Usuario>(usuarioNew, HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public ResponseEntity<UserDetailsImpl> log(@RequestBody @Valid AuthRequest request){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            UserDetailsImpl usuario = (UserDetailsImpl) authentication.getPrincipal();

            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.createToken(usuario))
                    .body(usuario);
        } catch (BadCredentialsException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


   @PostMapping("/otroTest")
   public ResponseEntity crear(@RequestBody CreateUserRequest usuario) {

           Usuario newUsuario = authService.createUsuario(usuario);
           UserDetailsImpl userDetails = UserDetailsImpl.build(newUsuario);
           return ResponseEntity.ok()
                   .header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.createToken(newUsuario))
                   .body(userDetails);

   }


}
