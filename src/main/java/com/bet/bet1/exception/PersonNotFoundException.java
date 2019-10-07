package com.bet.bet1.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonNotFoundException extends RuntimeException implements GraphQLError {
    private Map<String,Object> extensions = new HashMap<>();
    public PersonNotFoundException(String exception, int personId) {
        super(exception);
        extensions.put("invalidPersonId",personId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }
}
