package at.htl.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;


@ApplicationScoped
public class Repository {

    @Inject
    EntityManager em;
}
