package fr.ing.interview.kata.webapp.rest.provider.mapper;

import fr.ing.interview.kata.model.exception.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class TooManyResultsExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException pException) {
        return Response.status(Response.Status.PRECONDITION_FAILED).entity(pException.getMessage()).build();
    }
}
