package HomeService.Test.service;

import HomeService.Test.bean.MemberBean;
import HomeService.Test.bean.RequestBean;
import HomeService.Test.repository.CustomMemberRepository;
import HomeService.Test.repository.MemberRepository;
import HomeService.Test.repository.MemberRepositoryImpl;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class MemberConfigService {
    @Autowired
    MemberRepository memberRepository;
    private final CustomMemberRepository customMemberRepository;

    private MemberBean memberBean;
    private RequestBean requestBean;

    private ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    public MemberConfigService(CustomMemberRepository customMemberRepository) {
        this.customMemberRepository = customMemberRepository;
    }

    public ResponseEntity<?>addMember(MemberBean memberBean) {
        memberRepository.save(memberBean);
        return ResponseEntity.ok("member created successfully");
    }

    public ResponseEntity<?> getMember( String json ) throws JsonProcessingException {
        requestBean = objectMapper.readValue(json,RequestBean.class);
        memberBean = objectMapper.treeToValue(requestBean.getData(),MemberBean.class);
        System.err.println("memberBean"+memberBean.toString());
        if (requestBean.getFind() == 1) {
            ResponseEntity<?> foundMember = customMemberRepository.getMemberByOid(memberBean);
            return ResponseEntity.ok(foundMember);
        }

        return ResponseEntity.badRequest().body("Invalid request type");
    }
}
