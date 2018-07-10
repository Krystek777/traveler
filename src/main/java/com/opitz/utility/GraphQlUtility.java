package com.opitz.utility;

import com.opitz.service.ClaimService;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

import static graphql.GraphQL.newGraphQL;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

@Component
public class GraphQlUtility {

    @Value("classpath:schemas.graphqls")
    private Resource schemaResource;

    @Autowired
    private ClaimService claimService;

    public GraphQL createGraphQlObject() throws IOException {
        File schemas = schemaResource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemas);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        return newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {

        return newRuntimeWiring().type("Query", typeWiring -> typeWiring
                .dataFetcher("users", (env) -> claimService.getUsers())
                .dataFetcher("user",
                        (env) -> claimService.findUser((int) (env.getArguments().get("id"))))
                .dataFetcher("claims", (env) -> claimService.getClaims())
                .dataFetcher("claim",
                        (env) -> claimService.findClaim((Integer) (env.getArguments().get("id"))))).build();
    }
}
