package classes;

public class Contacte implements java.io.Serializable {
  
  String nom;
  String num;

  public Contacte(String nom, String num)  {
    this.nom = nom;
    this.num = num;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getNum() {
    return num;
  }

  public void setNum(String num) {
    this.num = num;
  }

  @Override
  public String toString() {
    return "Nom: "+this.nom+"\tTelèfon: "+this.num;
  }

}
