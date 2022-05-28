package com.sandip.dynamo_rest.repository;

import com.sandip.dynamo_rest.entities.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {
}
