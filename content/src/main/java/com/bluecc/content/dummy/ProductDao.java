package com.bluecc.content.dummy;
import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Select;

import java.util.UUID;

@Dao
public interface ProductDao {
    @Select
    Product findById(UUID productId);

    @Select
    ImmutableProduct getImmutable(UUID id);

    @Insert
    void save(Product product);

    @Delete
    void delete(Product product);
}

