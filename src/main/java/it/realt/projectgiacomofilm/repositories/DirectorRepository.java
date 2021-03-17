package it.realt.projectgiacomofilm.repositories;


import it.realt.projectgiacomofilm.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DirectorRepository extends JpaRepository<Director, Long>, JpaSpecificationExecutor<Director> {
}

//CrudRepository<Director, Long>
