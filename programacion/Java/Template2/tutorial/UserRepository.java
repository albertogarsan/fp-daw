package com.example.tutorial;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

//NOTES:
//Per a crear un repositori establim una interficie que exten el CrudRepository (és una interficie que Spring utilitza per a fer el Create, Read, Update, Delete), que té el User, i Integer. El primer ingereix la classe/taula/entitat User.java i accepta també un Integer, que es refereix al tipus de la primary de User.

public interface UserRepository extends CrudRepository<User, Integer> {

}