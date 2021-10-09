package com.victorman.webapi.link;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
    @Query(value = "SELECT nextval('link_id_sequence')", nativeQuery = true)
    Long getNextLinkId();

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM links WHERE time_excision <= current_timestamp", nativeQuery = true)
    int deleteAllExpired();
}
