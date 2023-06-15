package io.dumasoft.library.service.format;

import io.dumasoft.library.models.entity.Editorial;
import io.dumasoft.library.models.entity.Format;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFormatService {
        public List<Format> findAll();

        public void save(Format format);

        public Format findOne(Long id);

        public void delete(Long id);

        public Page<Format> findAll(Pageable pageable);
}
