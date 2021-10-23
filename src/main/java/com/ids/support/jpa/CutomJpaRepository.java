package com.ids.support.jpa;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CutomJpaRepository<T, ID> extends JpaRepository<T, ID> {

	<P> Optional<P> findProjectedById(Long id, Class<P> projection);
	<P> Collection<P> findAllProjectedBy(Class<P> projection);

}
