package com.spring.backend.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
	
	@Query("select m.memberMail from MemberEntity m")
    List<String> findMail();
	
    boolean existsByMemberMail(String memberMail);

}
