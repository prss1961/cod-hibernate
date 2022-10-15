package dev.ifrs.services;

import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ifrs.entity.Message;
import dev.ifrs.entity.User;

@Path("/message")
@Transactional

public class MessageService {



    @GET
    @Path("/add/{name}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Message add(@PathParam("text") String text, @PathParam("idUser") Long idUser) {

        Message message = new Message();
        message.setText(text);
        message.persistAndFlush();
  
        User user = User.findById(idUser);
        if (user == null)
           throw new BadRequestException("Usario não encontrado");
  
        user.addMessage(message);
        user.persistAndFlush();
  
        return message;
     }
   
    
}
