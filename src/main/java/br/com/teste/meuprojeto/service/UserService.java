package br.com.teste.meuprojeto.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.teste.meuprojeto.model.Concatenado;
import br.com.teste.meuprojeto.model.User;
import br.com.teste.meuprojeto.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public Concatenado aumentarUser(String nome){
        Concatenado coc = new Concatenado();
       
        
         coc.setConcatenado(nome +" é emo");
         return coc;
       
        
    }
    public User SaveData(User  data){
        
     
        
       
        return  repository.save(data);
       

    }
    public List<User> buscarTodos( ){
        
        return repository.findAll();
        
    }
    public Optional<User> buscarId(Long id) {


        return repository.findById(id);
    }
    public String deletarId(Long id) {

       
        try {
            repository.deleteById(id);
            return "deletado com sucesso";
        } catch (Exception e) {
           return "erro central: " +e;
        }
      
        
    }
    public ResponseEntity<Object> updateByid(User user, Long id) {
        
         Optional<User> userOptional  = repository.findById(id);
         if( userOptional.isEmpty()){
            return  ResponseEntity.notFound().build();
         }
         
        user.setId(id);
        repository.save(user);
        return ResponseEntity.noContent().build();

         }  

       
       
      
       
    
   

    
}
