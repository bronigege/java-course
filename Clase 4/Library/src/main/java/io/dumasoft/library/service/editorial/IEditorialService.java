package io.dumasoft.library.service.editorial;

import io.dumasoft.library.models.entity.Book;
import io.dumasoft.library.models.entity.Editorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEditorialService {
    public List<Editorial> findAll();

    public void save(Editorial editorial);

    public Editorial findOne(Long id);

    public void delete(Long id);

    public Page<Editorial> findAll(Pageable pageable);
}
