package hello.hello_springboot.repository;

import hello.hello_springboot.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    // 회원 정보를 저장할 Map 객체 (key: 회원 ID, value: 회원 객체)
    private static Map<Long, Member> store = new HashMap<>();
    // 회원 ID 생성을 위한 시퀀스 변수
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        // 회원의 ID를 시퀀스로 설정
        member.setId(++sequence);
        // 회원 정보를 Map에 저장
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // Map에서 ID에 해당하는 회원을 찾아 반환 (없으면 null 반환)
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // 저장된 모든 회원 목록을 스트림으로 변환
                .filter(member -> member.getName().equals(name)) // 회원 이름이 파라미터로 받은 name과 일치하는지 검사
                .findAny(); // 일치하는 첫 번째 회원을 반환 (없으면 Optional.empty 반환)
    }

    @Override
    public List<Member> findAll() {
        // Map에 저장된 모든 회원을 List로 변환하여 반환
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
