package fr.ing.interview.kata.webapp.rest.provider.mapper;

import fr.ing.interview.kata.model.exception.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException pException) {
        return Response.status(Response.Status.NOT_FOUND).entity(pException.getMessage()).build();
    }
}
