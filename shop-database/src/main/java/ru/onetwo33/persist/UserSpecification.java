package ru.onetwo33.persist;

import org.springframework.data.jpa.domain.Specification;

public final class UserSpecification {

    public static Specification<User> usernamePrefix(String prefix) {
        return (root, query, cb) -> cb.like(root.get("username"), prefix + "%");
    }

    public static Specification<User> minAge(Integer minAge) {
        return (root, query, cb) -> cb.ge(root.get("age"), minAge);
    }

    public static Specification<User> maxAge(Integer maxAge) {
        return (root, query, cb) -> cb.le(root.get("age"), maxAge);
    }
}
