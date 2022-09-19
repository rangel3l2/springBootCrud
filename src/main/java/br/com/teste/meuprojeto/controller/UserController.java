package br.com.teste.meuprojeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.meuprojeto.model.Concatenado;
import br.com.teste.meuprojeto.model.User;
import br.com.teste.meuprojeto.repository.UserRepository;
import br.com.teste.meuprojeto.service.UserService;




@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService service;

    @Autowired
    UserRepository rep;
    @GetMapping(value = "/{nome}")
    public Concatenado getMethodName(@PathVariable String nome) {
        User user = new User();
        user.setNome(nome);
        return service.aumentarUser(nome); 
    }

    @PostMapping(value = "/salvar")
    public User salvarUser(@RequestBody User user){
       
        return service.SaveData(user);
    }
    @GetMapping(value = "/buscarTodos")
    public List<User> buscarTodos(){
      
        return service.buscarTodos();

    }
    @GetMapping(value = "/buscarId/{id}")
     Optional<User> buscarPorId(@PathVariable Long id){

        return service.buscarId(id);
     }
     @GetMapping(value = "/deletar/{id}")
     String deletarPorId(@PathVariable Long id){
        
        return service.deletarId(id);

     }
     @PostMapping(value="/atualizar/{id}")
     public ResponseEntity<Object> postMethodName(@RequestBody User user, @PathVariable Long id) {
         
        return  service.updateByid(user, id);
     }
     
     
    
    
}
