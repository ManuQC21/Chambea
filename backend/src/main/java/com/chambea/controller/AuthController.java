package com.chambea.controller;

import com.chambea.dto.AuthRequest;
import com.chambea.dto.CreateFreelancerRequest;
import com.chambea.dto.CreateUserRequest;
import com.chambea.dto.UsuarioDto;
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


    @PostMapping("/login")
    public ResponseEntity<UsuarioDto> log(@RequestBody @Valid AuthRequest request){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            UserDetailsImpl usuario = (UserDetailsImpl) authentication.getPrincipal();
            Usuario usuarioFromDb = this.usuarioRepository.getById(usuario.getId());

            UsuarioDto usuarioDto = UsuarioDto.build(usuarioFromDb);


            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.createToken(usuario))
                    .body(usuarioDto);
        } catch (BadCredentialsException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


   @PostMapping("/signup")
   public ResponseEntity crear(@RequestBody CreateUserRequest usuario) {

           Usuario newUsuario = authService.createUsuario(usuario);
           UserDetailsImpl userDetails = UserDetailsImpl.build(newUsuario);

           UsuarioDto usuarioDto = UsuarioDto.build(newUsuario);

           return ResponseEntity.ok()
                   .header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.createToken(newUsuario))
                   .body(usuarioDto);

   }



   @PostMapping("/registroFreelancer")
    public ResponseEntity probar(@RequestBody CreateFreelancerRequest request){
        Usuario usuario1 = this.authService.registroFreelancer(request);
        return new ResponseEntity(usuario1, HttpStatus.CREATED);

   }


}
