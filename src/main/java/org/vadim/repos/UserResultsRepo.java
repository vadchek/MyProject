package org.vadim.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vadim.domain.UserResults;

import java.util.List;

public interface UserResultsRepo extends JpaRepository<UserResults, Long>{

    List<UserResults> findByAuthorName(String authorName);
}
