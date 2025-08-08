package HomeService.Test.repository;

import HomeService.Test.bean.MemberBean;
import org.springframework.http.ResponseEntity;

public interface CustomMemberRepository {
    ResponseEntity<?> getMemberByOid(MemberBean memberBean);
}
