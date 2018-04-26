package com.loyer.hrsystem.repository;

import com.loyer.hrsystem.model.App;
import org.springframework.data.repository.CrudRepository;

/**
 * dataya erişim objemiz.
 * CrudRepository'i extend ederek delete, save, find gibi
 * fonksyionları AppRepository'i implement ettiğimiz sınıflarda kullanabileceğiz.
 */
public interface AppRepository extends CrudRepository<App, Long> {
}
