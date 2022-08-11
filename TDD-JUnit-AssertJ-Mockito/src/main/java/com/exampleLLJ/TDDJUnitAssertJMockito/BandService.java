package com.exampleLLJ.TDDJUnitAssertJMockito;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class BandService {
    @Resource
    private BandDao bandDao;

    public void addBand(MusicBand u) {
        bandDao.save(u);
    }

    public Iterable<MusicBand> getBand(Long id) {
        return bandDao.findAll();
    }
}
