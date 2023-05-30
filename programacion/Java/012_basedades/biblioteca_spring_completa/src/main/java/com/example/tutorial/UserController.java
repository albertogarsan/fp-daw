package com.example.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//NOTES:
//./mvnw spring-boot:run
// curl -X POST -d "name=Alberto" -d "email=alberto@email.com" http://localhost:8080/users/add 
//Primer especifiquem amb l'etiqueta @Controller que és una classe que fa de controlador.
//Controla les rutes/path que rep el servidor i gràcies als repositoris que hem creat, podem modificar les dades de les taules SQL segons les diferents rutes i paràmetres que cridem.

@Controller 
@RequestMapping(path="/users") 
public class UserController {

  @Autowired
  private UserRepository userRepository;


  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
    // @ResponseBody l'string és el tipo de lo que retornarà eixe post request
    // @RequestParam means it is a parameter from the GET or POST request

    User n = new User();
    n.setName(name);
    n.setEmail(email);
    userRepository.save(n);
    return "Saved";
  }


  @GetMapping(path={"/all", "/"})
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }
}