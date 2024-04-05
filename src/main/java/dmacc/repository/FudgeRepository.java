package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Fudge;

/**
 * @author chumb - djackson16
 * CIS175 - Spring 2024
 * Apr 2, 2024
 */

@Repository
public interface FudgeRepository extends JpaRepository<Fudge, Long> {
}
