package com.sean.mavendemo.main.mapper;

import com.sean.mavendemo.main.mapper.persistencemodal.Sequence;

/**
 * Created by sean on 1/24/16.
 */
public interface IdGeneratorMapper {

    void insert(Sequence sequence);

    void updateHighNumber(String entityName);

    Sequence getSequenceByEntityName(String entityName);
}
