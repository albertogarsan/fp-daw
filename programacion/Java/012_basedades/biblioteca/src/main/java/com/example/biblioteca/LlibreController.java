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
@RequestMapping(path="/llibres") 
public class LlibreController {

  @Autowired
  private LlibreRepository llibreRepository;

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewLlibre (@RequestParam String nom, @RequestParam Double preu, @RequestParam int idAutor) {
    // @ResponseBody l'string és el tipo de lo que retornarà eixe post request
    // @RequestParam means it is a parameter from the GET or POST request

    Llibre llibre = new Llibre();
    llibre.setNom(nom);
    llibre.setPreu(preu);
    llibre.setIdAutor(idAutor);
    llibreRepository.save(llibre);
    return "Saved";
  }
  
  /* 
  @PostMapping(path="/delete") // Map ONLY POST Requests
  public @ResponseBody String deleteLlibre (@RequestParam int id) {
    // @ResponseBody l'string és el tipo de lo que retornarà eixe post request
    // @RequestParam means it is a parameter from the GET or POST request

    llibreRepository.deleteById(id);
    return "Deleted";
  }
  */

  @DeleteMapping(path="/delete/{id}")
  public ResponseEntity<String> deleteLlibreById(@PathVariable int id) {
    // This returns a JSON or XML with the users
    llibreRepository.deleteById(id);
    return ResponseEntity.ok("Deleted");
  } 

  //Rebem, el navegador, el terminal ens mostra...
  @GetMapping(path={"/all", "/"})
  public @ResponseBody Iterable<Llibre> getAllLlibres() {
    // This returns a JSON or XML with the users
    return llibreRepository.findAll();
  } 

  @GetMapping(path="/{idLlibre}")
  public @ResponseBody Optional<Llibre> getLlibreById(@PathVariable int idLlibre) {
    // This returns a JSON or XML with the users
    return llibreRepository.findById(idLlibre);
  } 


}
