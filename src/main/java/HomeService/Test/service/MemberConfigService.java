package HomeService.Test.service;

import HomeService.Test.bean.memberBean;
import HomeService.Test.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class MemberConfigService {
    @Autowired
    MemberRepository memberRepository;

    public ResponseEntity<?>addMember(memberBean memberBean) {
        return ResponseEntity.ok(memberRepository.save(memberBean));
    }
}
