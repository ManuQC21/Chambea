package com.chambea.security.services;

import com.chambea.dto.CreateFreelancerRequest;
import com.chambea.dto.CreateUserRequest;
import com.chambea.model.Empleador;
import com.chambea.model.Freelancer;
import com.chambea.model.Usuario;
import com.chambea.repositories.EmpleadorRepository;
import com.chambea.repositories.FreelancerRepository;
import com.chambea.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.time.LocalDate;
import java.util.Calendar;

@Service
public class AuthService {

    private UsuarioRepository usuarioRepository;
    private FreelancerRepository freelancerRepository;
    private PasswordEncoder passwordEncoder;
    private EmpleadorRepository empleadorRepository;

    AuthService(UsuarioRepository usuarioRepository,
                PasswordEncoder passwordEncoder,
                EmpleadorRepository empleadorRepository,
                FreelancerRepository freelancerRepository
    ){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.empleadorRepository = empleadorRepository;
        this.freelancerRepository = freelancerRepository;
    }

    public Usuario createUsuario(CreateUserRequest request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()){
            throw new ValidationException("Ya existe un usuario registrado con ese email");
        }

        if (usuarioRepository.findByNombreUsuario(request.getUsername()).isPresent()){
            throw new ValidationException("Ya existe un usuario registrado con ese nombre de usuario");
        }

        if(!request.getPassword().equals(request.getRePassword())){
            throw new ValidationException("Las contraseñas no coinciden");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(request.getEmail());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setNombreUsuario(request.getUsername());
        usuario.setNombres(request.getNombres());
        usuario.setApellidos(request.getApellidos());

        Usuario savedUsuario = this.usuarioRepository.save(usuario);

        Empleador empleador =  new Empleador();
        empleador.setUsuario(savedUsuario);
        empleador.setFechaRegistro(Calendar.getInstance());
        this.empleadorRepository.save(empleador);

        return savedUsuario;
    }

    public Usuario registroFreelancer(CreateFreelancerRequest request){
        Usuario usuarioFromDb = this.usuarioRepository.findById(request.getIdUsuario()).get();
        Freelancer freelancer = new Freelancer();
        freelancer.setFechaRegistro(LocalDate.now());
        freelancer.setTitulo(request.getTitulo());
        freelancer.setDescripcion(request.getDescripcion());
        freelancer.setUsuario(usuarioFromDb);
        Freelancer savedFreelancer = freelancerRepository.save(freelancer);
        usuarioFromDb.setFreelancer(savedFreelancer);
        return usuarioRepository.save(usuarioFromDb);
    }



}
