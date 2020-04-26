package in.SpringbootOCescalade.springboot.dao;

import java.util.HashSet;
import java.util.Set;
import in.SpringbootOCescalade.springboot.model.ParcoursDatabase;

public class Classe {
//ID
private int id = 0;
//Nom du professeur
private String nom = "";


private Set<ParcoursDatabase> listparcours = new HashSet<ParcoursDatabase>();


public Classe(int id, String nom) {
  this.id = id;
  this.nom = nom;
}
public Classe(){}

public int getId() {
  return id;
}

public void setId(int id) {
  this.id = id;
}

public String getNom() {
  return nom;
}

public void setNom(String nom) {
  this.nom = nom;
}

/*********************PARCOURS************************/
 public Set<ParcoursDatabase> getListParcourss() {
  return listparcours;
}
public void setListParcours(Set<ParcoursDatabase> listparcours) {
  this.listparcours = listparcours;
}

//Ajoute un parcours à la classe
public void addParcoursDatabase(ParcoursDatabase parcours){
  if(!this.listparcours.contains(parcours))
    this.listparcours.add(parcours);
}

//Retire un parcours de la classe
public void removeParcours(ParcoursDatabase parcours){
  this.listparcours.remove(parcours);
}




public boolean equals(Classe cls){
  return this.getId() == cls.getId();
}   
}