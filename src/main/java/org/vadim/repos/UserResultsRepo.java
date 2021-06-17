package org.vadim.repos;

import org.springframework.data.repository.CrudRepository;
import org.vadim.domain.UserResults;

public interface UserResultsRepo extends CrudRepository<UserResults, Integer>{
}
