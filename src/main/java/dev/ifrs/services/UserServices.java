package dev.ifrs.services;


import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ifrs.entity.User;


@Path("/user")
@Transactional
public class UserServices {

    /**
     * @param name
     * @return
     */
    @GET
    @Path("/add/{name}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public User addUser(@PathParam("name")String name){

        User user = new User();
        user.setName(name);
        // 2 - O método do Panache `persist` possibilita persistir um objeto.
        user.persist();
        return user;
    }
   
    /**
     *
     */
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    
    public List<User>listUser(){
        // 3 - O método `listAll` recupera todos os objetos da classe User.
       return User.listAll();
    }

    /**
     * @param id
     * @return
     */
    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public User list(@PathParam("id") Long id) {
        // 4 - O método do Panache `findById` recupera um objeto da classe User.
        return User.findById(id);
    }
   
    
}
