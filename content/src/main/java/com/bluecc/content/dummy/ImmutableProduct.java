package com.bluecc.content.dummy;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import com.datastax.oss.driver.api.mapper.annotations.PropertyStrategy;
import lombok.Value;

import java.util.UUID;

/**
 * You can also map Lombok "value" classes as immutable entities.
 *
 * <p>We show both in this example for demonstration purposes, but you would typically pick the
 * one that fits best with your programming style.
 */
@Value
@Entity
@CqlName("product")
@PropertyStrategy(mutable = false)
public class ImmutableProduct {
    @PartitionKey
    private UUID id;
    private String description;
}
