package com.anya.crudapp.repository;

import com.anya.crudapp.model.Writer;

import java.util.List;

public interface WriterRepository extends GenericRepository<Writer, Integer> {

    List<Writer> getAllDeleted();

    void totalClean();
}
