package HomeService.Test.repository;

import HomeService.Test.bean.MemberBean;
import HomeService.Test.exception.MemberNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl implements CustomMemberRepository{
    @PersistenceContext
    private EntityManager entityManager;
    public ResponseEntity<?> getMemberByOid(MemberBean memberBean){
        MemberBean foundMember = entityManager.find(MemberBean.class, memberBean.getOid());

        if (foundMember == null) {
            throw new MemberNotFoundException("member not found");
        }
        return ResponseEntity.ok(foundMember);
    }
}
