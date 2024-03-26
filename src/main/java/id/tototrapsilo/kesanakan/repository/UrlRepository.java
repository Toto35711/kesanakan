package id.tototrapsilo.kesanakan.repository;

import id.tototrapsilo.kesanakan.model.Url;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends CrudRepository<Url, String> {
}
