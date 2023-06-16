package io.dumasoft.library.service.owner;

import io.dumasoft.library.models.entity.Format;
import io.dumasoft.library.models.entity.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOwnerService {
    public List<Owner> findAll();

    public void save(Owner format);

    public Owner findOne(Long id);

    public void delete(Long id);
}
