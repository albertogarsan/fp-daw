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
import org.springframework.web.bind.annotation.PutMapping;

/* import java.util.ArrayList; */
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

  @PostMapping(path="/search") // Map ONLY POST Requests
  public @ResponseBody Iterable<Llibre> searchLlibre (@RequestParam String term) {
    // @ResponseBody l'string és el tipo de lo que retornarà eixe post request
    // @RequestParam means it is a parameter from the GET or POST request

    //findByNomContains és un mètode que he declarat en la interficie (LlibreRepository) i ell automàticament s'encarrega de buscar la columna que s'anomena nom i aplicar-li la lògica perquè la búsqueda siga amb contains.
    return llibreRepository.findByNom(term);
  }

  //Açò fa el mateix però implementat de manera manual amb logica propia
  /* @PostMapping(path="/searchV2") // Map ONLY POST Requests
  public @ResponseBody Iterable<Llibre> searchLlibre2 (@RequestParam String term) {
    Iterable<Llibre> llibres = llibreRepository.findAll();
    ArrayList<Llibre> resultat = new ArrayList<Llibre>();

    for (Llibre llibre : llibres){
      if (llibre.getNom().contains(term)) {
        resultat.add(llibre);
      }
    }

    return resultat;
  } */
  

  /* @PostMapping(path="/delete") // Map ONLY POST Requests
  public @ResponseBody String deleteLlibre (@RequestParam int id) {
    // @ResponseBody l'string és el tipo de lo que retornarà eixe post request
    // @RequestParam means it is a parameter from the GET or POST request

    llibreRepository.deleteById(id);
    return "Deleted";
  } */
  
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


  /* @PutMapping("{id}/updateNom")
  public String updateNom(@PathVariable int id, @RequestParam String nom) {

    //Creem un llibre opcional per si no existeix cap llibre
    Optional<Llibre> llibreOptional = llibreRepository.findById(id);

    //Comprovem que l'optional existeix i no és null amb isPresent() sobre un objecte Optional.
    if (llibreOptional.isPresent()) {
      //Obtenim el llibre amb el mètode get() de l'optional i assignant-lo ja és un llibre.
      Llibre llibre = llibreOptional.get();
      // I com que és un llibre ja podem utilitzar els mètodes propis de la classe Llibre
      llibre.setNom(nom);
      // Una vegada fetes les modificacions guardem tot amb el repositori.save(llibre) per a que es propague a les taules SQL
      llibreRepository.save(llibre);
      return "Nom guardat correctament a " + nom;

    } else {
      return "No s'ha trobat l'element amb id " + id;
    }
  } */

  @PutMapping("/{id}/updateNom")
  public @ResponseBody String updateLlibreNom(@PathVariable("id") Integer llibreId, @RequestParam("nom") String nouNom) {
    Optional<Llibre> optionalLlibre = llibreRepository.findById(llibreId);
    if (optionalLlibre.isPresent()) {
      Llibre llibre = optionalLlibre.get();
      llibre.setNom(nouNom);
      llibreRepository.save(llibre);
      return "Nom del llibre amb id: "+llibreId+" actualitzat correctament a: "+nouNom+".";
    } else {
      return "No s'ha trobat el llibre.";
    }
  }

  //curl -X PUT -d preu=29.99 http://localhost:8080/llibres/2/updatePreu -> Preu guardat correctament a 29.99
  @PutMapping("{id}/updatePreu")
  public @ResponseBody String updatePreu(@PathVariable("id") int id, @RequestParam("preu") Double preu) {

    Optional<Llibre> llibreOptional = llibreRepository.findById(id);

    if (llibreOptional.isPresent()) {
      Llibre llibre = llibreOptional.get();
      llibre.setPreu(preu);
      llibreRepository.save(llibre);
      return "Preu guardat correctament a " + preu;

    } else {
      return "No s'ha trobat l'element amb id " + id;
    }
  }
}
