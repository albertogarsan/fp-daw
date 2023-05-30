package com.example.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;

@Controller 
@RequestMapping(path="/autors") 
public class AutorController {

  @Autowired
  private AutorRepository autorRepository;


  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewAutor (@RequestParam String nom) {
    // @ResponseBody l'string és el tipo de lo que retornarà eixe post request
    // @RequestParam means it is a parameter from the GET or POST request

    Autor autor = new Autor();
    autor.setNom(nom);
    autorRepository.save(autor);
    return "Saved";
  }

  //curl http://localhost:8080/autors/delete -d idAutor=1
  /* @PostMapping(path="/delete") // Map ONLY POST Requests
  public @ResponseBody String deleteAutor (@RequestParam int idAutor) {
    // @ResponseBody l'string és el tipo de lo que retornarà eixe post request
    // @RequestParam means it is a parameter from the GET or POST request

    autorRepository.deleteById(idAutor);
    return "Deleted";
  } */
  
  //curl -X DELETE http://localhost:8080/autors/delete/3
  @DeleteMapping(path="/delete/{idAutor}")
  public ResponseEntity<String> deleteAutorById(@PathVariable int idAutor) {
    // This returns a JSON or XML with the users
    autorRepository.deleteById(idAutor);
    return ResponseEntity.ok("Deleted");
  } 


  @GetMapping(path={"/all", "/"})
  public @ResponseBody Iterable<Autor> getAllAutors() {
    // This returns a JSON or XML with the users
    return autorRepository.findAll();
  } 
  
  @GetMapping(path="/{idAutor}")
  public @ResponseBody Optional<Autor> getAutorById(@PathVariable int idAutor) {
    // This returns a JSON or XML with the users
    return autorRepository.findById(idAutor);
  } 
}
