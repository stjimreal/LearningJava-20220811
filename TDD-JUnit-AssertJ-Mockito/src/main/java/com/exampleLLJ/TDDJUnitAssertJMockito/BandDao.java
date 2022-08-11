package com.exampleLLJ.TDDJUnitAssertJMockito;

import org.springframework.data.repository.CrudRepository;

public interface BandDao extends CrudRepository<MusicBand, Long> {
}
